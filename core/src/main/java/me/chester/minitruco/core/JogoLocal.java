package me.chester.minitruco.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/* SPDX-License-Identifier: BSD-3-Clause */
/* Copyright © 2005-2023 Carlos Duarte do Nascimento "Chester" <cd@pobox.com> */

/**
 * Jogo rodando no celular.
 * <p>
 * Um jogador só passa a fazer parte do jogo se for adicionado a ele pelo método
 * <code>adiciona()</code>.
 * <p>
 * A classe notifica aos jogadores participantes os eventos relevantes (ex.:
 * início da partida, vez passando para um jogador, carta jogada, pedido de
 * truco), e os jogadores podem usar os métodos de entrada (ex.:
 * <code>jogaCarta()</code>, <code>aumentaAposta</code>, etc.) para interagir
 * com o jogo.
 * <p>
 *
 *
 */
public class JogoLocal extends Jogo {

    private final static Logger LOGGER = Logger.getLogger("JogoLocal");

	/**
	 * Cria um novo jogo.
	 * <p>
	 * O jogo é criado, mas apenas inicia quando forem adicionados jogadores
	 *
	 * @param modoStr "P"aulista, "M"ineiro, ou "L"impo (paulista com baralho limpo)
	 */
	public JogoLocal(String modoStr, boolean humanoDecide, boolean jogoAutomatico) {
		super(modoStr);
		this.baralho = new Baralho(modo.isBaralhoLimpo());
		this.humanoDecide = humanoDecide;
        this.jogoAutomatico = jogoAutomatico;
	}

	/**
	 * Baralho que será usado durante esse jogo
	 */
	private final Baralho baralho;

	/**
	 * Resultados de cada rodada (1 para vitória da equipe 1/3, 2 para vitória
	 * da equipe 2/4 e 3 para empate)
	 */
	private final int[] resultadoRodada = new int[3];

	/**
	 * Valor atual da mão (1, 3, 6, 9 ou 12)
	 */
	private int valorMao;

	/**
	 * Jogador que está pedindo aumento de aposta (pedindo truco, 6, 9 ou 12).
	 * Se for null, ninguém está pedindo
	 */
	private Jogador jogadorPedindoAumento;

	/**
	 * Status das respsotas para um pedido de aumento de aposta para cada
	 * jogador.
	 * <p>
	 * false signfica que não respondeu ainda, true que respondeu recusando
	 */
	private final boolean[] recusouAumento = new boolean[4];

	/**
	 * Posição (1 a 4) do jogador da vez
	 */
	private int posJogadorDaVez;

	/**
	 * Jogador que abriu a rodada
	 */
	private Jogador jogadorAbriuRodada;

	/**
	 * Jogador que abriu a mão
	 */
	private Jogador jogadorAbriuMao;

	/**
	 * Indica, para cada jogador, se estamos aguardando a resposta dele
	 * de aceite/recusa da mão de ferro
	 */
	private final boolean[] aguardandoRespostaMaoDeFerro = new boolean[4];

	/**
	 * Sinaliza para o loop principal que alguém jogou uma carta
	 */
	boolean alguemJogou = false;

	/**
	 * Se alguemJogou = true, é o alguém que jogou
	 */
	private Jogador jogadorQueJogou;

	/**
	 * Se alguemJogou = true, é a carta jogada
	 */
	private Carta cartaJogada;

	private final boolean humanoDecide;
    private final boolean jogoAutomatico;

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#run()
	 */
	public void run() {

		// Avisa os jogadores que o jogo vai começar
		LOGGER.log(Level.INFO, "Jogo (.run) iniciado");
		for (Jogador interessado : jogadores) {
			interessado.inicioPartida(pontosEquipe[0], pontosEquipe[1]);
		}

		// Inicia a primeira rodada, usando o jogador na posição 1, e processa
		// as jogadas até alguém ganhar ou o jogo ser abortado (o que pode
		// ocorrer em paralelo, daí os múltiplos checks a jogoFinalizado)
		iniciaMao(getJogador(1));
		while (pontosEquipe[0] < 12 && pontosEquipe[1] < 12 && !jogoFinalizado) {
			while ((!alguemJogou) && (!jogoFinalizado)) {
				sleep();
			}
			if (!jogoFinalizado) {
				LOGGER.log(Level.INFO, "alguém jogou!");
				processaJogada();
				alguemJogou = false;
			}
		}
		LOGGER.log(Level.INFO, "Jogo (.run) finalizado");
	}

	/**
	 * Inicia uma mão (i.e., uma distribuição de cartas)
	 *
	 * @param jogadorQueAbre
	 *            Jogador que abre a rodada
	 */
	private void iniciaMao(Jogador jogadorQueAbre) {

		// Embaralha as cartas e reinicia a mesa
		baralho.embaralha();
		cartasJogadasPorRodada = new Carta[3][4];

		// Distribui as cartas de cada jogador
		for (int j = 1; j <= 4; j++) {
			Jogador jogador = getJogador(j);
			Carta[] cartas = new Carta[3];
			for (int i = 0; i <= 2; i++) {
				cartas[i] = baralho.sorteiaCarta();
			}
			jogador.setCartas(cartas);
		}

		// Vira a carta da mesa, determinando a manilha
		cartaDaMesa = baralho.sorteiaCarta();
		setManilha(cartaDaMesa);

		// Inicializa a mão
		valorMao = modo.valorInicialDaMao();

		jogadorPedindoAumento = null;
		numRodadaAtual = 1;
		jogadorAbriuMao = jogadorAbriuRodada = jogadorQueAbre;

		LOGGER.log(Level.INFO, "Abrindo mao com j" + jogadorQueAbre.getPosicao()
				+ ",manilha=" + getManilha());

		// Abre a primeira rodada, informando a carta da mesa e quem vai abrir
		posJogadorDaVez = jogadorQueAbre.getPosicao();
		for (Jogador interessado : jogadores) {
			interessado.inicioMao();
		}

		if (pontosEquipe[0] == modo.pontuacaoQueDeterminaMaoDeFerro()
				^ pontosEquipe[1] == modo.pontuacaoQueDeterminaMaoDeFerro()) {
			if (pontosEquipe[0] == modo.pontuacaoQueDeterminaMaoDeFerro()) {
				setEquipeAguardandoMaoDeFerro(1);
				getJogador(1).informaMaoDeFerro(getJogador(3).getCartas());
				getJogador(3).informaMaoDeFerro(getJogador(1).getCartas());
				for (Jogador interessado : jogadores) {
					// Interessados que não sejam Jogador (ex.: a Partida na
					// versão Android) devem ser notificados também
					if (!(interessado instanceof Jogador)) {
						interessado.informaMaoDeFerro(getJogador(3).getCartas());
					}
				}
			} else {
				setEquipeAguardandoMaoDeFerro(2);
				getJogador(2).informaMaoDeFerro(getJogador(4).getCartas());
				getJogador(4).informaMaoDeFerro(getJogador(2).getCartas());
			}
		} else {
			// Se for uma mão normal, passa a vez para o jogador que abre
			setEquipeAguardandoMaoDeFerro(0);
			notificaVez();
		}

	}

	/**
	 * Processa uma jogada e passa a vez para o próximo jogador (ou finaliza a
	 * rodoada/mão/jogo), notificando os jogadores apropriadamente
	 *
	 */
	private void processaJogada() {

		Jogador j = this.jogadorQueJogou;
		Carta c = this.cartaJogada;

		LOGGER.log(Level.INFO, "processaJogada: j" + j.getPosicao() + " joga " + c +
				"; jogadorPedindoAumento:" + (jogadorPedindoAumento == null ? "null" : jogadorPedindoAumento.getPosicao()) +
				"; isAguardandoRespostaMaoDeFerro:" + isAguardandoRespostaMaoDeFerro() +
				"; jogadorDaVez: "+getJogadorDaVez().getPosicao());

		// Se o jogo acabou, a mesa não estiver completa, já houver alguém
		// trucando, estivermos aguardando ok da mão de ferro ou não for a vez do
		// cara, recusa
		if (jogoFinalizado || numJogadores < 4 || jogadorPedindoAumento != null
				|| (isAguardandoRespostaMaoDeFerro())
				|| !j.equals(getJogadorDaVez())) {
			return;
		}

		// Verifica se a carta já não foi jogada anteriormente (normalmente não
		// deve acontecer - mesmo caso do check anterior)
		for (int i = 0; i <= 2; i++) {
			for (int k = 0; k <= 3; k++) {
				if (c.equals(cartasJogadasPorRodada[i][k])) {
					LOGGER.log(Level.INFO, "carta jogada anteriormente: "+ c + "," + i + "," + k);
					renotificaVezCPU();
					return;
				}
			}
		}

		// Verifica se a carta realmente pertence ao jogador
		Carta cartaNaMaoDoJogador = null;
		for (int i = 0; i <= 2; i++) {
			if (j.getCartas()[i].equals(c)) {
				cartaNaMaoDoJogador = c;
			}
		}
		if (cartaNaMaoDoJogador == null) {
			LOGGER.log(Level.INFO, "j" + j.getPosicao() + " tentou jogar " + c +
					" mas esta carta não está na mão dele");
			renotificaVezCPU();
			return;
		}

		// Garante que a regra para carta fechada seja respeitada
		if (!isPodeFechada()) {
			c.setFechada(false);
		}

		LOGGER.log(Level.INFO, "J" + j.getPosicao() + " joga " + c);

		// Dá a carta como jogada, notificando os jogadores
		cartasJogadasPorRodada[numRodadaAtual - 1][j.getPosicao() - 1] = c;
		for (Jogador interessado : jogadores) {
			interessado.cartaJogada(j, c);
		}

		// Passa a vez para o próximo jogador
		posJogadorDaVez++;
		if (posJogadorDaVez == 5) {
			posJogadorDaVez = 1;
		}
		if (posJogadorDaVez == jogadorAbriuRodada.getPosicao()) {

			// Completou a volta da rodada - acha o valor da maior carta da mesa
			Carta[] cartas = getCartasDaRodada(numRodadaAtual);
			int valorMaximo = 0;
			for (int i = 0; i <= 3; i++) {
				valorMaximo = Math.max(valorMaximo, getValorTruco(cartas[i]));
			}

			// Determina a equipe vencedora (1/2= equipe 1 ou 2; 3=empate) e o
			// jogador que vai "tornar", i.e., abrir a próxima rodada
			setResultadoRodada(numRodadaAtual, 0);
			Jogador jogadorQueTorna = null;
			for (int i = 0; i <= 3; i++) {
				if (getValorTruco(cartas[i]) == valorMaximo) {
					if (jogadorQueTorna == null) {
						jogadorQueTorna = getJogador(i + 1);
					}
					if (i == 0 || i == 2) {
						setResultadoRodada(numRodadaAtual,
								getResultadoRodada(numRodadaAtual) | 1);
					} else {
						setResultadoRodada(numRodadaAtual,
								getResultadoRodada(numRodadaAtual) | 2);
					}
				}
			}

			LOGGER.log(Level.INFO, "Rodada fechou. Resultado: "
					+ getResultadoRodada(numRodadaAtual));

			// Se houve vencedor, passa a vez para o jogador que fechou a
			// vitória, senão deixa quem abriu a mão anterior abrir a próxima
			if (getResultadoRodada(numRodadaAtual) != 3) {
				posJogadorDaVez = jogadorQueTorna.getPosicao();
			} else {
				jogadorQueTorna = getJogadorDaVez();
			}

			// Notifica os interessados que a mão foi feita
			for (Jogador interessado : jogadores) {
				interessado.rodadaFechada(numRodadaAtual,
						getResultadoRodada(numRodadaAtual), jogadorQueTorna);
			}

			// Verifica se já temos vencedor na rodada
			int resultadoRodada = 0;
			if (numRodadaAtual == 2) {
				if (getResultadoRodada(1) == 3 && getResultadoRodada(2) != 3) {
					// Empate na 1a. mão, quem fez a 2a. leva
					resultadoRodada = getResultadoRodada(2);
				} else if (getResultadoRodada(1) != 3
						&& getResultadoRodada(2) == 3) {
					// Empate na 2a. mão, quem fez a 1a. leva
					resultadoRodada = getResultadoRodada(1);
				} else if (getResultadoRodada(1) == getResultadoRodada(2)
						&& getResultadoRodada(1) != 3) {
					// Quem faz as duas primeiras leva
					resultadoRodada = getResultadoRodada(2);
				}
			} else if (numRodadaAtual == 3) {
				if (getResultadoRodada(3) != 3) {
					// Quem faz a 3a. leva
					resultadoRodada = getResultadoRodada(3);
				} else {
					// Se a 3a. empatou, a 1a. decide
					resultadoRodada = getResultadoRodada(1);
				}
			}

			// Se já tivermos vencedor (ou empate final), notifica e abre uma
			// nova mao, senão segue a vida na mão seguinte
			if (resultadoRodada != 0) {
				// Soma os pontos (se não deu emptate)
				if (resultadoRodada != 3) {
					pontosEquipe[resultadoRodada - 1] += valorMao;
				}
				fechaMao();
			} else {
				numRodadaAtual++;
				jogadorAbriuRodada = jogadorQueTorna;
				notificaVez();
			}
		} else {
			notificaVez();
		}

	}

	/**
	 * Conclui a mão atual, e, se o jogo não acabou, inicia uma nova.
	 *
	 */
	private void fechaMao() {

		LOGGER.log(Level.INFO, "Mao fechou. Placar: " + pontosEquipe[0] + " a "
				+ pontosEquipe[1]);

		// Notifica os interessados que a rodada acabou, e, se for o caso, que o
		// jogo acabou também

		for (Jogador interessado : jogadores) {
			interessado.maoFechada(pontosEquipe);
			if (pontosEquipe[0] > modo.pontuacaoQueDeterminaMaoDeFerro()) {
				interessado.jogoFechado(1);
				jogoFinalizado = true;
			} else if (pontosEquipe[1] > modo.pontuacaoQueDeterminaMaoDeFerro()) {
				interessado.jogoFechado(2);
				jogoFinalizado = true;
			}
		}

		// Se ainda estivermos em jogo, incia a nova mao
		if (pontosEquipe[0] <= modo.pontuacaoQueDeterminaMaoDeFerro()
				&& pontosEquipe[1] <= modo.pontuacaoQueDeterminaMaoDeFerro()) {
			int posAbre = jogadorAbriuMao.getPosicao() + 1;
			if (posAbre == 5)
				posAbre = 1;
			iniciaMao(getJogador(posAbre));
		}

	}

	// /// NOTIFICAÇÕES RECEBIDAS DOS JOGADORES

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#jogaCarta(mt.Jogador, mt.Carta)
	 */
	public synchronized void jogaCarta(Jogador j, Carta c) {

		// Se alguém tiver jogado e ainda não foi processado, segura a onda
		while (alguemJogou) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// No worries
			}
		}

		this.jogadorQueJogou = j;
		this.cartaJogada = c;
		this.alguemJogou = true;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#decideMaoDeFerro(mt.Jogador, boolean)
	 */
	public synchronized void decideMaoDeFerro(Jogador j, boolean aceita) {

		// Só entra se estivermos jogando e se estivermos agurardando resposta
		// daquele jogador para a pergunta (isso é importante para evitar duplo
		// início)
		if (jogoFinalizado || !aguardandoRespostaMaoDeFerro[j.getPosicao() - 1])
			return;

		LOGGER.log(Level.INFO, "J" + j.getPosicao() + (aceita ? "" : " nao")
				+ " quer jogar mao de 11 ");

		// Se for uma CPU parceira de humano num jogo 100% local, trata como recusa
		// (quem decide mão de ferro é o humano) e nem notifica (silenciando o balão)
		if (isIgnoraDecisao(j)) {
			aceita = false;
		} else {
			// Avisa os outros jogadores da decisão
			for (Jogador interessado : jogadores) {
				interessado.decidiuMaoDeFerro(j, aceita);
			}
		}

		aguardandoRespostaMaoDeFerro[j.getPosicao() - 1] = false;

		if (aceita) {
			// Se aceitou, desencana da resposta do parceiro e pode tocar o
			// jogo, valendo 3
			aguardandoRespostaMaoDeFerro[j.getParceiro() - 1] = false;
			valorMao = modo.valorDaMaoDeFerro();
			notificaVez();
		} else {
			// Se recusou (e o parceiro também), a equipe perde um ponto e
			// recomeça a mao
			if (!aguardandoRespostaMaoDeFerro[j.getParceiro() - 1]) {
				pontosEquipe[j.getEquipeAdversaria() - 1] += modo
						.valorInicialDaMao();
				fechaMao();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#aumentaAposta(mt.Jogador)
	 */
	public void aumentaAposta(Jogador j) {

		// Se o jogo estiver fianlizado, a mesa não estiver completa, já houver
		// alguém trucando, estivermos aguardando a mão de ferro ou não for a vez
		// do cara, recusa
		if ((jogoFinalizado) || (numJogadores < 4)
				|| (jogadorPedindoAumento != null)
				|| isAguardandoRespostaMaoDeFerro() || !j.equals(getJogadorDaVez())) {
			return;
		}

		LOGGER.log(Level.INFO, "Jogador  " + j.getPosicao() + " pede aumento");

		// Atualiza o status e notifica os outros jogadores do pedido
		jogadorPedindoAumento = j;
		for (int i = 0; i <= 3; i++)
			recusouAumento[i] = false;

		int valor = modo.valorSeHouverAumento(valorMao);

		// Notifica os interessados
		for (Jogador interessado : jogadores) {
			interessado.pediuAumentoAposta(j, valor);
		}
		LOGGER.log(Level.INFO, "Jogadores notificados do aumento");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#respondeAumento(mt.Jogador, boolean)
	 */
	public synchronized void respondeAumento(Jogador j, boolean aceitou) {
		// Apenas os adversários de quem trucou respondem
		if (jogadorPedindoAumento == null
				|| jogadorPedindoAumento.getEquipeAdversaria() != j.getEquipe()) {
			return;
		}

		LOGGER.log(Level.INFO, "Jogador  " + j.getPosicao()
				+ (aceitou ? "aceitou" : "recusou"));

		int posParceiro = (j.getPosicao() + 1) % 4 + 1;
		// Se, num jogo 100% local (só o humano e CPUs)
		// o bot parceiro do humano aceita, trata como recusa
		// (mas notifica humano do aceite)
		boolean ignorarAceite = isIgnoraDecisao(j) && aceitou;
		if (aceitou && !ignorarAceite) {
			// Se o jogador aceitou, seta o novo valor, notifica a galera e tira
			// o jogo da situtação de truco
			valorMao = modo.valorSeHouverAumento(valorMao);
			jogadorPedindoAumento = null;
			for (Jogador interessado : jogadores) {
				interessado.aceitouAumentoAposta(j, valorMao);
			}
		} else {
			// Primeiro notifica todo mundo da recusa
			// (se for um aceite ignorado, diz pro humano que aceitou, só pra ele saber o que seria feito)
			for (Jogador interessado : jogadores) {
				if (aceitou && ignorarAceite && (interessado == jogadores[posParceiro - 1])) {
					interessado.aceitouAumentoAposta(j, valorMao);
				} else {
					interessado.recusouAumentoAposta(j);
				}
			}
			if (recusouAumento[posParceiro - 1]) {
				// Se o parceiro também recusou, derrota da dupla
				pontosEquipe[jogadorPedindoAumento.getEquipe() - 1] += valorMao;
				fechaMao();
			} else {
				// Sinaliza a recusa, deixando a decisão na mão do parceiro
				recusouAumento[j.getPosicao() - 1] = true;
			}
		}
	}

	@Override
	public boolean semJogadoresRemotos() {
		for (int i = 0; i < 3; i ++)
			if (!(jogadores[i] instanceof JogadorHumano || jogadores[i] instanceof JogadorCPU)) {
				return false;
			}
		return true;
	}

	/**
	 * Determina se o jogador em questão deve ter sua decisão (aceite de aumento ou mão 11) ignorada.
	 *
	 * @param jogador jogador que acabou de tomar uma decisão
	 * @return true se o jogador for uma CPU cujo parceiro é humano em um jogo 100% local
	 */
	public boolean isIgnoraDecisao(Jogador jogador) {
		int posParceiro = (jogador.getPosicao() + 1) % 4 + 1;
		return  humanoDecide &&
				semJogadoresRemotos() &&
				(jogador instanceof JogadorCPU) &&
				(jogadores[posParceiro - 1] instanceof JogadorHumano);
	}

	/**
	 * Determina qual a equipe que está aguardando mão de ferro
	 *
	 * @param i
	 *            1 ou 2 para a respectiva equipe, 0 para ninguém aguardando mão
	 *            de 11 (jogo normal)
	 */
	private void setEquipeAguardandoMaoDeFerro(int i) {
		aguardandoRespostaMaoDeFerro[0] = aguardandoRespostaMaoDeFerro[2] = (i == 1);
		aguardandoRespostaMaoDeFerro[1] = aguardandoRespostaMaoDeFerro[3] = (i == 2);
	}

	private int getResultadoRodada(int mao) {
		return resultadoRodada[mao - 1];
	}

	private void setResultadoRodada(int mao, int valor) {
		resultadoRodada[mao - 1] = valor;
	}

	/**
	 * Informa aos jogadores participantes que é a vez de um deles.
	 */
	private void notificaVez() {

		// Esses dados têm que ser coletados *antes* de chamar as Threads.
		// Motivo: se uma delas resolver jogar, a informação para as outras pode
		// ficar destaualizada.
		Jogador j = getJogadorDaVez();
		boolean pf = isPodeFechada();

		for (Jogador interessado : jogadores) {
			interessado.vez(j, pf);
		}

	}

	/**
	 * Se o jogador da vez for CPU, re-notifica ele que é sua vez.
	 *
	 * Isso é usado para casos em que a CPU joga uma jogada inválida (ex.: porque
	 * jogou depois que a mão fechou), evitando que ela fique "travada"
	 */
	private void renotificaVezCPU() {
		Jogador j = getJogadorDaVez();
		boolean pf = isPodeFechada();

		if (j instanceof JogadorCPU) {
			j.vez(j, pf);
		}
	}

	/**
	 * Informa se o jogador da vez pode jogar carta fechada (se mudar a regra,
	 * basta alterar aqui).
	 * <p>
	 * Regra atual: só vale carta fechada se não for a 1a. rodada e se o
	 * parceiro não tiver jogado fechada também
	 *
	 */
	private boolean isPodeFechada() {
		Carta cartaParceiro = cartasJogadasPorRodada[numRodadaAtual - 1][getJogadorDaVez()
				.getParceiro() - 1];
		return (numRodadaAtual > 1 && (cartaParceiro == null || !cartaParceiro
				.isFechada()));
	}

	/**
	 * Recupera o jogador cuja vez é a atual
	 *
	 */
	private Jogador getJogadorDaVez() {
		return getJogador(posJogadorDaVez);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mt.JogoGenerico#atualizaSituacao(mt.SituacaoJogo, mt.Jogador)
	 */
	public void atualizaSituacao(SituacaoJogo s, Jogador j) {
		s.baralhoSujo = !modo.isBaralhoLimpo();
		if (modo.isManilhaVelha()) {
			s.manilha = SituacaoJogo.MANILHA_INDETERMINADA;
		} else {
			s.manilha = this.getManilha();
		}
		s.numRodadaAtual = this.numRodadaAtual;
		s.posJogador = j.getPosicao();
		s.posJogadorQueAbriuRodada = this.jogadorAbriuRodada.getPosicao();
		if (this.jogadorPedindoAumento != null)
			s.posJogadorPedindoAumento = this.jogadorPedindoAumento
					.getPosicao();
		s.valorMao = this.valorMao;

		System.arraycopy(this.pontosEquipe, 0, s.pontosEquipe, 0, 2);
		System.arraycopy(this.resultadoRodada, 0, s.resultadoRodada, 0, 3);

		for (int i = 0; i <= 2; i++)
			for (int k = 0; k <= 3; k++) {
				Carta c = cartasJogadasPorRodada[i][k];
				if (c == null) {
					s.cartasJogadas[i][k] = null;
				} else if (s.cartasJogadas[i][k] == null) {
					s.cartasJogadas[i][k] = new Carta(c.getLetra(),
							c.getNaipe());
				} else {
					s.cartasJogadas[i][k].setLetra(c.getLetra());
					s.cartasJogadas[i][k].setNaipe(c.getNaipe());
				}
				// Se for uma carta fechada, limpa letra/naipe na cópia (pra
				// evitar que uma estratégia maligna tente espiar uma carta
				// fechada)
				if (c != null && c.isFechada()) {
					s.cartasJogadas[i][k].setFechada(true);
					s.cartasJogadas[i][k].setLetra(Carta.LETRA_NENHUMA);
					s.cartasJogadas[i][k].setNaipe(Carta.NAIPE_NENHUM);
				}
			}

	}

	/**
	 * Verifica se estamos aguardando resposta para mão de ferro
	 *
	 * @return true se falta alguém responder, false caso contrário
	 */
	private boolean isAguardandoRespostaMaoDeFerro() {
		for (int i = 0; i <= 3; i++) {
			if (aguardandoRespostaMaoDeFerro[i]) {
				return true;
			}
		}
		return false;
	}

	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isJogoAutomatico() {
		return jogoAutomatico;
	}

}
