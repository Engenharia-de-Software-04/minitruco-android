package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ThreadFactory;
import javax.management.loading.MLet;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JogadorBotDiffblueTest {
    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez2() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez3() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez4() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(null, tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez5() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(false);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez6() {
        // Arrange
        Thread thread = new Thread();
        thread.setName("JogadorBot ");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez7() {
        // Arrange
        Thread thread = new Thread();
        thread.setName("42");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez8() {
        // Arrange
        Thread thread = new Thread();
        thread.setPriority(1);
        thread.setName("JogadorBot ");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez9() {
        // Arrange
        Thread thread = new Thread();
        thread.setName("[ (.run) iniciado");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#vez(Jogador, boolean)}
     */
    @Test
    void testVez10() {
        // Arrange
        EstrategiaGasparotto e = new EstrategiaGasparotto();
        e.setGameLevel(-1);
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(e, tf);

        // Act
        jogadorBot.vez(new JogadorBot(), true);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#run()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        JogadorBot jogadorBot = null;

        // Act
        jogadorBot.run();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 42, 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta2() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread("foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 42, 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta3() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 2, 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta4() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setPosicao(1);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 42, 1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta5() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread("42"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 42, 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta6() {
        // Arrange
        Runnable runnable = mock(Runnable.class);
        doNothing().when(runnable).run();
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread(runnable, "foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 2, 1);

        // Assert that nothing has changed
        verify(runnable).run();
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta7() {
        // Arrange
        Runnable runnable = mock(Runnable.class);
        doNothing().when(runnable).run();
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread(runnable, "foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 0, 1);

        // Assert that nothing has changed
        verify(runnable).run();
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#pediuAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testPediuAumentoAposta8() {
        // Arrange
        Runnable runnable = mock(Runnable.class);
        doNothing().when(runnable).run();
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread(runnable, "foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.pediuAumentoAposta(new JogadorBot(), 2, 3);

        // Assert that nothing has changed
        verify(runnable).run();
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 42, 1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(45, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta2() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 2, 1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(5, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta3() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 12, 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(0, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta4() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setPosicao(1);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 42, 1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(0, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta5() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(new EstrategiaGasparotto(), tf);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 2, 1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(5, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#aceitouAumentoAposta(Jogador, int, int)}
     */
    @Test
    void testAceitouAumentoAposta6() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(null, tf);

        // Act
        jogadorBot.aceitouAumentoAposta(new JogadorBot(), 2, 12);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        assertEquals(5, jogadorBot.valorProximaAposta);
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta2() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread("foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta3() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setFingeQuePensa(true);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta4() {
        // Arrange
        Thread thread = new Thread("foo");
        thread.setName("foo");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta5() {
        // Arrange
        Thread thread = new Thread("foo");
        thread.setName("foo");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setNome("JogadorBot ");

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta6() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread("foo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 10);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta7() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread("foofoo"));
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta8() {
        // Arrange
        Thread thread = new Thread("foo42");
        thread.setName("foo");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setNome("JogadorBot ");

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), 1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta9() {
        // Arrange
        Thread thread = new Thread("foo42");
        thread.setName("foo");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setNome("JogadorBot ");

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), -1);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#recusouAumentoAposta(Jogador, int)}
     */
    @Test
    void testRecusouAumentoAposta10() {
        // Arrange
        Thread thread = new Thread("foo42");
        thread.setContextClassLoader(new MLet());
        thread.setName("foo");
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(thread);

        JogadorBot jogadorBot = new JogadorBot(tf);
        jogadorBot.setNome("JogadorBot ");

        // Act
        jogadorBot.recusouAumentoAposta(new JogadorBot(), -1);

        // Assert that nothing has changed
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#maoFechada(int[])}
     */
    @Test
    void testMaoFechada() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        (new JogadorBot(tf)).maoFechada(new int[]{1, -1, 1, -1});

        // Assert
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Method under test: {@link JogadorBot#inicioMao(Jogador)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInicioMao() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot load from object array because the return value of "me.chester.minitruco.core.JogadorBot.getCartas()" is null
        //       at me.chester.minitruco.core.JogadorBot.inicioMao(JogadorBot.java:339)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        JogadorBot jogadorBot = new JogadorBot();

        // Act
        jogadorBot.inicioMao(new JogadorBot());
    }

    /**
     * Method under test: {@link JogadorBot#informaMaoDeX(Carta[])}
     */
    @Test
    void testInformaMaoDeX() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
        JogadorBot jogadorBot = new JogadorBot(tf);

        // Act
        jogadorBot.informaMaoDeX(new Carta[]{new Carta("S Carta")});

        // Assert
        verify(tf).newThread(isA(Runnable.class));
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JogadorBot#setFingeQuePensa(boolean)}
     *   <li>{@link JogadorBot#cartaJogada(Jogador, Carta)}
     *   <li>{@link JogadorBot#decidiuMaoDeX(Jogador, boolean, int)}
     *   <li>{@link JogadorBot#inicioPartida(int, int)}
     *   <li>{@link JogadorBot#jogoAbortado(int, int)}
     *   <li>{@link JogadorBot#jogoFechado(int, int)}
     *   <li>{@link JogadorBot#rodadaFechada(int, int, Jogador)}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     JogadorBot.aceitaramTruco
        //     JogadorBot.cartasDoParceiroDaMaoDeX
        //     JogadorBot.cartasRestantes
        //     JogadorBot.estouAguardandoRepostaAumento
        //     JogadorBot.estrategia
        //     JogadorBot.fingeQuePensa
        //     JogadorBot.minhaVez
        //     JogadorBot.numRespostasAguardando
        //     JogadorBot.podeFechada
        //     JogadorBot.recebiPedidoDeAumento
        //     JogadorBot.recebiPedidoDeMaoDeX
        //     JogadorBot.situacaoJogo
        //     JogadorBot.thread
        //     JogadorBot.valorProximaAposta
        //     Jogador.cartas
        //     Jogador.nome
        //     Jogador.partida
        //     Jogador.posicao

        // Arrange
        JogadorBot jogadorBot = new JogadorBot();

        // Act
        jogadorBot.setFingeQuePensa(true);
        JogadorBot j = new JogadorBot();
        jogadorBot.cartaJogada(j, new Carta("S Carta"));
        jogadorBot.decidiuMaoDeX(new JogadorBot(), true, 1);
        jogadorBot.inicioPartida(1, 1);
        jogadorBot.jogoAbortado(1, 1);
        jogadorBot.jogoFechado(10, 1);
        jogadorBot.rodadaFechada(10, 1, new JogadorBot());
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot()}
     */
    @Test
    void testNewJogadorBot() {
        // Arrange and Act
        JogadorBot actualJogadorBot = new JogadorBot();

        // Assert
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(ThreadFactory)}
     */
    @Test
    void testNewJogadorBot2() {
        // Arrange and Act
        JogadorBot actualJogadorBot = new JogadorBot(null);

        // Assert
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(ThreadFactory)}
     */
    @Test
    void testNewJogadorBot3() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        JogadorBot actualJogadorBot = new JogadorBot(tf);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(Estrategia, ThreadFactory)}
     */
    @Test
    void testNewJogadorBot4() {
        // Arrange and Act
        JogadorBot actualJogadorBot = new JogadorBot(null, null);

        // Assert
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(Estrategia, ThreadFactory)}
     */
    @Test
    void testNewJogadorBot5() {
        // Arrange and Act
        JogadorBot actualJogadorBot = new JogadorBot(new EstrategiaGasparotto(), null);

        // Assert
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(Estrategia, ThreadFactory)}
     */
    @Test
    void testNewJogadorBot6() {
        // Arrange
        EstrategiaGasparotto e = new EstrategiaGasparotto();
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        JogadorBot actualJogadorBot = new JogadorBot(e, tf);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }

    /**
     * Method under test: {@link JogadorBot#JogadorBot(Estrategia, ThreadFactory)}
     */
    @Test
    void testNewJogadorBot7() {
        // Arrange
        ThreadFactory tf = mock(ThreadFactory.class);
        when(tf.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

        // Act
        JogadorBot actualJogadorBot = new JogadorBot(null, tf);

        // Assert
        verify(tf).newThread(isA(Runnable.class));
        SituacaoJogo situacaoJogo = actualJogadorBot.situacaoJogo;
        assertEquals('\u0000', situacaoJogo.manilha);
        assertNull(actualJogadorBot.getCartas());
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
        assertNull(actualJogadorBot.partida);
        assertEquals(0, actualJogadorBot.getPosicao());
        assertEquals(0, actualJogadorBot.valorProximaAposta);
        assertEquals(0, situacaoJogo.numRodadaAtual);
        assertEquals(0, situacaoJogo.posJogador);
        assertEquals(0, situacaoJogo.posJogadorPedindoAumento);
        assertEquals(0, situacaoJogo.posJogadorQueAbriuRodada);
        assertEquals(0, situacaoJogo.valorMao);
        assertEquals(0, situacaoJogo.valorProximaAposta);
        assertEquals(1, actualJogadorBot.getEquipeAdversaria());
        assertEquals(2, actualJogadorBot.getEquipe());
        assertEquals(2, actualJogadorBot.getParceiro());
        assertEquals(3, cartaArray.length);
        assertEquals(4, cartaArray2.length);
        assertEquals(4, cartaArray3.length);
        assertEquals(4, cartaArray4.length);
        assertFalse(situacaoJogo.baralhoSujo);
        assertFalse(situacaoJogo.podeFechada);
        assertEquals(JogadorBot.APELIDO_BOT, actualJogadorBot.getNome());
        assertArrayEquals(new int[]{0, 0}, situacaoJogo.pontosEquipe);
        assertArrayEquals(new int[]{0, 0, 0}, situacaoJogo.resultadoRodada);
    }
}
