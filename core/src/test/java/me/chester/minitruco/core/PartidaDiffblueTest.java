package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PartidaDiffblueTest {
    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco() {
        // Arrange, Act and Assert
        assertEquals(0, Partida.getValorTruco(new Carta("S Carta"), 'A'));
        assertEquals(0, Partida.getValorTruco(new Carta("A23456789JQK"), 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco2() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(1);
        c.setFechada(false);
        c.setLetra('7');

        // Act and Assert
        assertEquals(11, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco3() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(2);
        c.setFechada(false);
        c.setLetra('7');

        // Act and Assert
        assertEquals(4, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco4() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(0);
        c.setFechada(false);
        c.setLetra('7');

        // Act and Assert
        assertEquals(13, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco5() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(1);
        c.setFechada(false);
        c.setLetra('A');

        // Act and Assert
        assertEquals(8, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco6() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(2);
        c.setFechada(false);
        c.setLetra('A');

        // Act and Assert
        assertEquals(12, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco7() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(1);
        c.setFechada(false);
        c.setLetra('4');

        // Act and Assert
        assertEquals(1, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco8() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setNaipe(3);
        c.setFechada(false);
        c.setLetra('4');

        // Act and Assert
        assertEquals(14, Partida.getValorTruco(c, Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco9() {
        // Arrange
        Carta c = new Carta("S Carta");
        c.setFechada(true);

        // Act and Assert
        assertEquals(0, Partida.getValorTruco(c, 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco10() {
        // Arrange
        Carta c = new Carta("A23456789JQK");
        c.setNaipe(3);

        // Act and Assert
        assertEquals(14, Partida.getValorTruco(c, 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco11() {
        // Arrange
        Carta c = new Carta("A23456789JQK");
        c.setNaipe(1);

        // Act and Assert
        assertEquals(11, Partida.getValorTruco(c, 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco12() {
        // Arrange
        Carta c = new Carta("A23456789JQK");
        c.setNaipe(2);

        // Act and Assert
        assertEquals(12, Partida.getValorTruco(c, 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta, char)}
     */
    @Test
    void testGetValorTruco13() {
        // Arrange
        Carta c = new Carta("A23456789JQK");
        c.setNaipe(0);

        // Act and Assert
        assertEquals(13, Partida.getValorTruco(c, 'A'));
    }

    /**
     * Method under test: {@link Partida#getValorTruco(Carta)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetValorTruco14() {
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

        // Act
        partidaLocal.getValorTruco(new Carta("S Carta"));
    }

    /**
     * Method under test: {@link Partida#adiciona(Jogador)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAdiciona() {
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

        // Act
        partidaLocal.adiciona(new JogadorBot());
    }

    /**
     * Method under test: {@link Partida#getJogador(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetJogador() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).getJogador(1);
    }

    /**
     * Method under test: {@link Partida#getManilha()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetManilha() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).getManilha();
    }

    /**
     * Method under test: {@link Partida#setManilha(Carta)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetManilha() {
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

        // Act
        partidaLocal.setManilha(new Carta("S Carta"));
    }

    /**
     * Method under test: {@link Partida#isPlacarPermiteAumento()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsPlacarPermiteAumento() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).isPlacarPermiteAumento();
    }

    /**
     * Method under test: {@link Partida#textoModo(String)}
     */
    @Test
    void testTextoModo() {
        // Arrange, Act and Assert
        assertNull(Partida.textoModo("Modo"));
        assertEquals("Truco Paulista", Partida.textoModo("P"));
        assertEquals("Truco Mineiro", Partida.textoModo("M"));
        assertEquals("Baralho Limpo", Partida.textoModo("L"));
        assertEquals("Manilha Velha", Partida.textoModo("V"));
        assertEquals("DEBUG: Finaliza em 1", Partida.textoModo("1"));
    }

    /**
     * Method under test: {@link Partida#getModo()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetModo() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).getModo();
    }

    /**
     * Method under test: {@link Partida#getCartasDaRodada(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCartasDaRodada() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).getCartasDaRodada(1);
    }

    /**
     * Method under test: {@link Partida#semJogadoresRemotos()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSemJogadoresRemotos() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).semJogadoresRemotos();
    }

    /**
     * Method under test: {@link Partida#isJogoAutomatico()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsJogoAutomatico() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).isJogoAutomatico();
    }

    /**
     * Method under test: {@link Partida#nomeNoTruco(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNomeNoTruco() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Modo deve ser M, P, V ou L
        //       at me.chester.minitruco.core.Modo.fromString(Modo.java:32)
        //       at me.chester.minitruco.core.PartidaLocal.<init>(PartidaLocal.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new PartidaLocal(true, true, "Modo Str")).nomeNoTruco(42);
    }
}
