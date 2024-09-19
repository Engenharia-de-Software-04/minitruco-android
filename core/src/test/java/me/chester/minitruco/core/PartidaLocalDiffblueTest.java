package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ThreadFactory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PartidaLocalDiffblueTest {
    /**
     * Method under test: {@link PartidaLocal#run()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).run();
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("S Carta"));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta2() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "L");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("S Carta"));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta3() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "1");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("S Carta"));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta4() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot j = new JogadorBot(tf);

        // Act
        partidaLocal.jogaCarta(j, new Carta("S Carta"));

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta5() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("S Carta"));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta6() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("coepx"));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta7() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        JogadorBot j = new JogadorBot();

        Carta c = new Carta("S Carta");
        c.setLetra('\u0001');

        // Act
        partidaLocal.jogaCarta(j, c);

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta8() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        JogadorBot j = new JogadorBot();

        Carta c = new Carta("S Carta");
        c.setNaipe(1);

        // Act
        partidaLocal.jogaCarta(j, c);

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#jogaCarta(Jogador, Carta)}
     */
    @Test
    void testJogaCarta9() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        JogadorBot j = new JogadorBot();

        // Act
        partidaLocal.jogaCarta(j, new Carta("JogadorBot JogadorBot "));

        // Assert
        assertTrue(partidaLocal.alguemJogou);
    }

    /**
     * Method under test: {@link PartidaLocal#decideMaoDeX(Jogador, boolean)}
     */
    @Test
    void testDecideMaoDeX() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        partidaLocal.abandona(1);
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        partidaLocal.decideMaoDeX(new JogadorBot(tf), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link PartidaLocal#decideMaoDeX(Jogador, boolean)}
     */
    @Test
    void testDecideMaoDeX2() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot j = new JogadorBot(tf);
        j.setPosicao(1);

        // Act
        partidaLocal.decideMaoDeX(j, true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link PartidaLocal#aumentaAposta(Jogador)}
     */
    @Test
    void testAumentaAposta() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        partidaLocal.aumentaAposta(new JogadorBot(tf));

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link PartidaLocal#aumentaAposta(Jogador)}
     */
    @Test
    void testAumentaAposta2() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        partidaLocal.abandona(4);
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        partidaLocal.aumentaAposta(new JogadorBot(tf));

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link PartidaLocal#respondeAumento(Jogador, boolean)}
     */
    @Test
    void testRespondeAumento() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        partidaLocal.respondeAumento(new JogadorBot(tf), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link PartidaLocal#semJogadoresRemotos()}
     */
    @Test
    void testSemJogadoresRemotos() {
        // Arrange, Act and Assert
        assertFalse((new PartidaLocal(true, true, "M")).semJogadoresRemotos());
    }

    /**
     * Method under test: {@link PartidaLocal#semJogadoresRemotos()}
     */
    @Test
    void testSemJogadoresRemotos2() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot j = new JogadorBot(new EstrategiaGasparotto(), tf);

        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        partidaLocal.abandona(1);
        partidaLocal.decideMaoDeX(j, true);

        // Act
        boolean actualSemJogadoresRemotosResult = partidaLocal.semJogadoresRemotos();

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertFalse(actualSemJogadoresRemotosResult);
    }

    /**
     * Method under test: {@link PartidaLocal#abandona(int)}
     */
    @Test
    void testAbandona() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");

        // Act
        partidaLocal.abandona(1);

        // Assert
        assertTrue(partidaLocal.finalizada);
    }

    /**
     * Method under test: {@link PartidaLocal#trocaPorBot(Jogador)}
     */
    @Test
    void testTrocaPorBot() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        JogadorBot j = mock(JogadorBot.class);
        when(j.getPosicao()).thenReturn(1);
        Carta carta = new Carta("unnamed");
        Carta carta2 = new Carta("unnamed");
        Carta carta3 = new Carta("unnamed");
        when(j.getCartas()).thenReturn(new Carta[]{carta, carta2, carta3});

        // Act
        partidaLocal.trocaPorBot(j);

        // Assert
        verify(j).getCartas();
        verify(j).getPosicao();
        Jogador[] jogadorArray = partidaLocal.jogadores;
        Jogador jogador = jogadorArray[0];
        assertTrue(jogador instanceof JogadorBot);
        SituacaoJogo situacaoJogo = ((JogadorBot) jogador).situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(situacaoJogo.cartasJogador);
        Carta[][] cartaArray = situacaoJogo.cartasJogadas;
        Carta[] cartaArray2 = cartaArray[0];
        assertNull(cartaArray2[0]);
        assertNull(cartaArray2[1]);
        assertNull(cartaArray2[2]);
        assertNull(cartaArray2[3]);
        Carta[] cartaArray3 = cartaArray[1];
        assertNull(cartaArray3[0]);
        assertNull(cartaArray3[1]);
        assertNull(cartaArray3[2]);
        assertNull(cartaArray3[3]);
        Carta[] cartaArray4 = cartaArray[2];
        assertNull(cartaArray4[0]);
        assertNull(cartaArray4[1]);
        assertNull(cartaArray4[2]);
        assertNull(cartaArray4[3]);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, jogador.getEquipe());
        assertEquals(1, jogador.getPosicao());
        assertEquals(2, jogador.getEquipeAdversaria());
        assertEquals(3, jogador.getParceiro());
        Carta[] cartas = jogador.getCartas();
        assertEquals(3, cartas.length);
        assertEquals(3, cartaArray.length);
        assertEquals(3, ((JogadorBot) jogador).valorProximaAposta);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertEquals(4, jogadorArray.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, jogador.getNome());
        assertSame(carta, cartas[0]);
        assertSame(carta2, cartas[1]);
        assertSame(carta3, cartas[2]);
        assertSame(partidaLocal, ((JogadorBot) jogador).partida);
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link PartidaLocal#trocaPorBot(Jogador)}
     */
    @Test
    void testTrocaPorBot2() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "1");
        JogadorBot j = mock(JogadorBot.class);
        when(j.getPosicao()).thenReturn(1);
        Carta carta = new Carta("unnamed");
        Carta carta2 = new Carta("unnamed");
        Carta carta3 = new Carta("unnamed");
        when(j.getCartas()).thenReturn(new Carta[]{carta, carta2, carta3});

        // Act
        partidaLocal.trocaPorBot(j);

        // Assert
        verify(j).getCartas();
        verify(j).getPosicao();
        Jogador[] jogadorArray = partidaLocal.jogadores;
        Jogador jogador = jogadorArray[0];
        assertTrue(jogador instanceof JogadorBot);
        SituacaoJogo situacaoJogo = ((JogadorBot) jogador).situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(situacaoJogo.cartasJogador);
        Carta[][] cartaArray = situacaoJogo.cartasJogadas;
        Carta[] cartaArray2 = cartaArray[0];
        assertNull(cartaArray2[0]);
        assertNull(cartaArray2[1]);
        assertNull(cartaArray2[2]);
        assertNull(cartaArray2[3]);
        Carta[] cartaArray3 = cartaArray[1];
        assertNull(cartaArray3[0]);
        assertNull(cartaArray3[1]);
        assertNull(cartaArray3[2]);
        assertNull(cartaArray3[3]);
        Carta[] cartaArray4 = cartaArray[2];
        assertNull(cartaArray4[0]);
        assertNull(cartaArray4[1]);
        assertNull(cartaArray4[2]);
        assertNull(cartaArray4[3]);
        assertEquals(0, ((JogadorBot) jogador).valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, jogador.getEquipe());
        assertEquals(1, jogador.getPosicao());
        assertEquals(2, jogador.getEquipeAdversaria());
        assertEquals(3, jogador.getParceiro());
        Carta[] cartas = jogador.getCartas();
        assertEquals(3, cartas.length);
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertEquals(4, jogadorArray.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, jogador.getNome());
        assertSame(carta, cartas[0]);
        assertSame(carta2, cartas[1]);
        assertSame(carta3, cartas[2]);
        assertSame(partidaLocal, ((JogadorBot) jogador).partida);
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link PartidaLocal#isIgnoraDecisao(Jogador)}
     */
    @Test
    void testIsIgnoraDecisao() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");

        // Act and Assert
        assertFalse(partidaLocal.isIgnoraDecisao(new JogadorBot()));
    }

    /**
     * Method under test: {@link PartidaLocal#isIgnoraDecisao(Jogador)}
     */
    @Test
    void testIsIgnoraDecisao2() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        boolean actualIsIgnoraDecisaoResult = partidaLocal.isIgnoraDecisao(new JogadorBot(tf));

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertFalse(actualIsIgnoraDecisaoResult);
    }

    /**
     * Method under test: {@link PartidaLocal#isIgnoraDecisao(Jogador)}
     */
    @Test
    void testIsIgnoraDecisao3() {
        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(false, true, "M");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        boolean actualIsIgnoraDecisaoResult = partidaLocal.isIgnoraDecisao(new JogadorBot(tf));

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertFalse(actualIsIgnoraDecisaoResult);
    }

    /**
     * Method under test: {@link PartidaLocal#getJogadorDaVez()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetJogadorDaVez() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).getJogadorDaVez();
    }

    /**
     * Method under test:
     * {@link PartidaLocal#atualizaSituacao(SituacaoJogo, Jogador)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAtualizaSituacao() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        PartidaLocal partidaLocal = new PartidaLocal(true, true, "Modo Str");
        SituacaoJogo s = new SituacaoJogo();

        // Act
        partidaLocal.atualizaSituacao(s, new JogadorBot());
    }

    /**
     * Method under test: {@link PartidaLocal#isJogoAutomatico()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsJogoAutomatico() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Exception in arrange section.
        //   Diffblue Cover was unable to construct an instance of the class under test using
        //   me.chester.minitruco.core.PartidaLocal.isJogoAutomatico().
        //   The arrange section threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R081 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        PartidaLocal partidaLocal = null;

        // Act
        boolean actualIsJogoAutomaticoResult = partidaLocal.isJogoAutomatico();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test:
     * {@link PartidaLocal#PartidaLocal(boolean, boolean, String)}
     */
    @Test
    void testNewPartidaLocal() {
        // Arrange and Act
        PartidaLocal actualPartidaLocal = new PartidaLocal(true, true, "M");

        // Assert
        Modo modo = actualPartidaLocal.getModo();
        assertTrue(modo instanceof ModoMineiro);
        assertEquals('\u0000', actualPartidaLocal.getManilha());
        assertNull(actualPartidaLocal.cartasJogadasPorRodada);
        assertNull(actualPartidaLocal.cartaDaMesa);
        Jogador[] jogadorArray = actualPartidaLocal.jogadores;
        assertNull(jogadorArray[0]);
        assertNull(jogadorArray[1]);
        assertNull(jogadorArray[2]);
        assertNull(jogadorArray[3]);
        assertEquals(0, actualPartidaLocal.numJogadores);
        assertEquals(0, actualPartidaLocal.numRodadaAtual);
        assertEquals(4, jogadorArray.length);
        assertFalse(modo.isBaralhoLimpo());
        assertFalse(actualPartidaLocal.finalizada);
        assertFalse(actualPartidaLocal.alguemJogou);
        assertTrue(modo.isManilhaVelha());
        assertTrue(actualPartidaLocal.isJogoAutomatico());
        assertArrayEquals(new int[]{0, 0}, actualPartidaLocal.pontosEquipe);
    }

    /**
     * Method under test:
     * {@link PartidaLocal#PartidaLocal(boolean, boolean, String)}
     */
    @Test
    void testNewPartidaLocal2() {
        // Arrange and Act
        PartidaLocal actualPartidaLocal = new PartidaLocal(true, true, "P");

        // Assert
        Modo modo = actualPartidaLocal.getModo();
        assertTrue(modo instanceof ModoPaulista);
        assertEquals('\u0000', actualPartidaLocal.getManilha());
        assertNull(actualPartidaLocal.cartasJogadasPorRodada);
        assertNull(actualPartidaLocal.cartaDaMesa);
        Jogador[] jogadorArray = actualPartidaLocal.jogadores;
        assertNull(jogadorArray[0]);
        assertNull(jogadorArray[1]);
        assertNull(jogadorArray[2]);
        assertNull(jogadorArray[3]);
        assertEquals(0, actualPartidaLocal.numJogadores);
        assertEquals(0, actualPartidaLocal.numRodadaAtual);
        assertEquals(4, jogadorArray.length);
        assertFalse(modo.isBaralhoLimpo());
        assertFalse(modo.isManilhaVelha());
        assertFalse(actualPartidaLocal.finalizada);
        assertFalse(actualPartidaLocal.alguemJogou);
        assertTrue(actualPartidaLocal.isJogoAutomatico());
        assertArrayEquals(new int[]{0, 0}, actualPartidaLocal.pontosEquipe);
    }

    /**
     * Method under test:
     * {@link PartidaLocal#PartidaLocal(boolean, boolean, String)}
     */
    @Test
    void testNewPartidaLocal3() {
        // Arrange and Act
        PartidaLocal actualPartidaLocal = new PartidaLocal(true, true, "V");

        // Assert
        Modo modo = actualPartidaLocal.getModo();
        assertTrue(modo instanceof ModoManilhaVelha);
        assertEquals('\u0000', actualPartidaLocal.getManilha());
        assertNull(actualPartidaLocal.cartasJogadasPorRodada);
        assertNull(actualPartidaLocal.cartaDaMesa);
        Jogador[] jogadorArray = actualPartidaLocal.jogadores;
        assertNull(jogadorArray[0]);
        assertNull(jogadorArray[1]);
        assertNull(jogadorArray[2]);
        assertNull(jogadorArray[3]);
        assertEquals(0, actualPartidaLocal.numJogadores);
        assertEquals(0, actualPartidaLocal.numRodadaAtual);
        assertEquals(4, jogadorArray.length);
        assertFalse(modo.isBaralhoLimpo());
        assertFalse(actualPartidaLocal.finalizada);
        assertFalse(actualPartidaLocal.alguemJogou);
        assertTrue(modo.isManilhaVelha());
        assertTrue(actualPartidaLocal.isJogoAutomatico());
        assertArrayEquals(new int[]{0, 0}, actualPartidaLocal.pontosEquipe);
    }

    /**
     * Method under test:
     * {@link PartidaLocal#PartidaLocal(boolean, boolean, String)}
     */
    @Test
    void testNewPartidaLocal4() {
        // Arrange and Act
        PartidaLocal actualPartidaLocal = new PartidaLocal(true, true, "L");

        // Assert
        Modo modo = actualPartidaLocal.getModo();
        assertTrue(modo instanceof ModoBaralhoLimpo);
        assertEquals('\u0000', actualPartidaLocal.getManilha());
        assertNull(actualPartidaLocal.cartasJogadasPorRodada);
        assertNull(actualPartidaLocal.cartaDaMesa);
        Jogador[] jogadorArray = actualPartidaLocal.jogadores;
        assertNull(jogadorArray[0]);
        assertNull(jogadorArray[1]);
        assertNull(jogadorArray[2]);
        assertNull(jogadorArray[3]);
        assertEquals(0, actualPartidaLocal.numJogadores);
        assertEquals(0, actualPartidaLocal.numRodadaAtual);
        assertEquals(4, jogadorArray.length);
        assertFalse(modo.isManilhaVelha());
        assertFalse(actualPartidaLocal.finalizada);
        assertFalse(actualPartidaLocal.alguemJogou);
        assertTrue(modo.isBaralhoLimpo());
        assertTrue(actualPartidaLocal.isJogoAutomatico());
        assertArrayEquals(new int[]{0, 0}, actualPartidaLocal.pontosEquipe);
    }

    /**
     * Method under test:
     * {@link PartidaLocal#PartidaLocal(boolean, boolean, String)}
     */
    @Test
    void testNewPartidaLocal5() {
        // Arrange and Act
        PartidaLocal actualPartidaLocal = new PartidaLocal(true, true, "1");

        // Assert
        Modo modo = actualPartidaLocal.getModo();
        assertTrue(modo instanceof ModoFinalizaEm1);
        assertEquals('\u0000', actualPartidaLocal.getManilha());
        assertNull(actualPartidaLocal.cartasJogadasPorRodada);
        assertNull(actualPartidaLocal.cartaDaMesa);
        Jogador[] jogadorArray = actualPartidaLocal.jogadores;
        assertNull(jogadorArray[0]);
        assertNull(jogadorArray[1]);
        assertNull(jogadorArray[2]);
        assertNull(jogadorArray[3]);
        assertEquals(0, actualPartidaLocal.numJogadores);
        assertEquals(0, actualPartidaLocal.numRodadaAtual);
        assertEquals(4, jogadorArray.length);
        assertFalse(modo.isBaralhoLimpo());
        assertFalse(modo.isManilhaVelha());
        assertFalse(actualPartidaLocal.finalizada);
        assertFalse(actualPartidaLocal.alguemJogou);
        assertTrue(actualPartidaLocal.isJogoAutomatico());
        assertArrayEquals(new int[]{0, 0}, actualPartidaLocal.pontosEquipe);
    }
}
