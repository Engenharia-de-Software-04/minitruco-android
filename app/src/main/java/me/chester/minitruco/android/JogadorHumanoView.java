package me.chester.minitruco.android;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.chester.minitruco.core.Carta;
import me.chester.minitruco.core.Jogador;
import me.chester.minitruco.core.Partida;
import me.chester.minitruco.core.PartidaLocal;

/* SPDX-License-Identifier: BSD-3-Clause */
/* Copyright © 2005-2023 Carlos Duarte do Nascimento "Chester" <cd@pobox.com> */

/**
 * Jogador que controla o celular.
 * <p>
 * Esta classe trabalha em conjunto com uma <code>TrucoActivity</code> e uma
 * <code>MesaView</code>, que mostram a partida ao usuário, capturam seu input e
 * executam as jogadas.
 */
public class JogadorHumanoView extends me.chester.minitruco.core.JogadorHumano {

    private static final Logger LOGGER = Logger.getLogger("JogadorHumano");

    private final TrucoActivity activity;

    private final MesaView mesa;

    private int valProxAposta;

    public JogadorHumanoView(final TrucoActivity activity, final MesaView mesa) {
        super();
        this.activity = activity;
        this.mesa = mesa;
    }

    @Override
    public void cartaJogada(final Jogador jogador2, final Carta carta2) {
        mesa.escondePergunta();
        mesa.setPosicaoVez(0);
        mesa.escondeBotaoAumento();
        mesa.escondeBotaoAbertaFechada();
        mesa.descarta(carta2, posicaoNaTela(jogador2));
        LOGGER.log(Level.INFO, "Jogador na posição de tela {0} jogou {1}", new Object[]{posicaoNaTela(jogador2), carta2});
    }

    @Override
    public void decidiuMaoDeX(final Jogador jogador2,final boolean aceita, final int rndFrase) {
        if (posicaoNaTela(jogador2) == 3 && aceita) {
            mesa.escondePergunta();
        }
        if (aceita) {
            activity.setValorMao(partida.getModo().valorDaMaoDeX());
        }
        mesa.diz(aceita ? "mao_de_x_sim" : "mao_de_x_nao", posicaoNaTela(jogador2), 1500, rndFrase);
    }

    @Override
    public void entrouNoJogo(Jogador jogador2, Partida partidaAtual) {
    }

    @Override
    public void informaMaoDeX(final Carta[] cartasParceiro) {
        mesa.maoDeX(cartasParceiro);
    }

    @Override
    public void inicioMao(final Jogador jogadorQueAbre) {
        valProxAposta = 3;
        for (int rodada = 1; rodada <= 3; rodada++) {
            activity.setResultadoRodada(rodada, 0);
        }
        LOGGER.log(Level.INFO, "distribuindo a mão");
        mesa.distribuiMao();
        activity.setValorMao(partida.getModo().valorInicialDaMao());
        mesa.setPosicaoVez(posicaoNaTela(jogadorQueAbre));
        activity.tiraDestaqueDoPlacar();
    }

    @Override
    public void inicioPartida(final int placarEquipe1,final int placarEquipe2) {
        activity.placar[0] = placarEquipe1;
        activity.placar[1] = placarEquipe2;
        activity.atualizaPlacar(placarEquipe1, placarEquipe2);
    }

    @Override
    public void jogoAbortado(final int posicao,final int rndFrase) {
        if (posicao != 0 && mesa != null) {
            mesa.diz("abortou", convertePosicaoJogadorParaPosicaoTela(posicao),
                    1000, rndFrase);
            mesa.aguardaFimAnimacoes();
        }
        if (activity != null) {
            activity.partidaAbortada = true;
            activity.finish();
        }
    }

    @Override
    public void jogoFechado(final int numEquipeVenc,final int rndFrase) {
        final boolean ganhei = numEquipeVenc == this.getEquipe();
        mesa.diz(ganhei ? "vitoria" : "derrota", 1, 1000, rndFrase);
        mesa.aguardaFimAnimacoes();
        activity.jogoFechado(numEquipeVenc);
    }

    @Override
    public void maoFechada(final int[] pontosEquipe) {
        final int pontosNos = pontosEquipe[getEquipe() - 1];
        final int pontosRivais = pontosEquipe[getEquipeAdversaria() - 1];
        activity.atualizaPlacar(pontosNos, pontosRivais);
        activity.setValorMao(0);
        mesa.escondeBotaoAumento();
        mesa.escondeBotaoAbertaFechada();
        mesa.setPosicaoVez(0);
        mesa.recolheMao();
    }

    @Override
    public void pediuAumentoAposta(final Jogador jogador2,final int valor, final int rndFrase) {
        LOGGER.log(Level.INFO, "pedindo para mostrar pergunta aumento");
        mesa.pedeAumento(posicaoNaTela(jogador2), valor, rndFrase);
    }

    @Override
    public void aceitouAumentoAposta( final Jogador jogador2, final int valor, final int rndFrase) {
        if (jogador2.getEquipe() == this.getEquipe()) {
            // Numa partida sem bluetooth/etc, o bot não aumenta, só
            // sinaliza a intenção de aumentar
            if (partida instanceof PartidaLocal && ((PartidaLocal) partida).isIgnoraDecisao(jogador2)) {
                mesa.diz("aumento_quero", posicaoNaTela(jogador2), 1500, rndFrase);
                return;
            }
            // Nós aceitamos um truco, então podemos pedir aumento (se o valor atual ainda permitir)
            valProxAposta = partida.getModo().valorSeHouverAumento(valor);
        } else {
            // Eles aceitaram um truco, temos que esperar eles pedirem
            valProxAposta = 0;
        }
        mesa.escondePergunta();
        mesa.diz("aumento_sim", posicaoNaTela(jogador2), 1500, rndFrase);
        mesa.aceitouAumentoAposta();
        activity.setValorMao(valor);
    }

    @Override
    public void recusouAumentoAposta( final Jogador jogador2, final int rndFrase) {
        mesa.diz("aumento_nao", posicaoNaTela(jogador2), 1300, rndFrase);
    }

    @Override
    public void rodadaFechada( final int numRodada, final int resultado,
            final Jogador jogadorQueTorna) {
        int novoResultado = resultado;
        if (getEquipe() == 2) {
            // Se o humano nao é equipe 1 e não for empate, troca o resultado
            if (resultado == 1) {
                novoResultado = 2;
            } else if (resultado == 2) {
                novoResultado = 1;
            }
        }
        mesa.escondePergunta();
        mesa.setPosicaoVez(0);
        mesa.atualizaResultadoRodada(numRodada, novoResultado, jogadorQueTorna);
    }

    @Override
    public void vez( final Jogador jogador2, final boolean podeFechada) {
        LOGGER.log(Level.INFO, "vez do jogador {0}", posicaoNaTela(jogador2));
        mesa.escondeBotaoAumento();
        mesa.escondeBotaoAbertaFechada();
        if (jogador2.equals(this)) {
            if ((valProxAposta > 0) && partida.isPlacarPermiteAumento()) {
                mesa.mostraBotaoAumento(valProxAposta);
            }
            if (podeFechada) {
                mesa.mostraBotaoAbertaFechada();
            }
        }
        mesa.vez(jogador2.equals(this));
        mesa.setPosicaoVez(posicaoNaTela(jogador2));
    }

    /**
     * Retorna a posição do jogador na tela.
     * <p>
     * Num partida local, o 1 é o humano *e* a posição inferior da tela. Em jogos
     * remotos, o jogador 1 pode não ser o inferior, e esta função calcula a
     * posição que aquele jogador ocupa na tela sob o ponto de vista local.
     * <p>
     *
     * @return 1 para a posição inferior, 2 para a direita, 3 para cima, 4 para
     *         esquerda
     */
    private int posicaoNaTela( final Jogador jogador2) {
        int pos = jogador2.getPosicao() - this.getPosicao() + 1;
        if (pos < 1) {
            pos = pos + 4;
        }
        return pos;
    }

    private int convertePosicaoJogadorParaPosicaoTela( final int posicaoJogador) {
        int pos = posicaoJogador - this.getPosicao() + 1;
        if (pos < 1) {
            pos = pos + 4;
        }
        return pos;
    }

}
