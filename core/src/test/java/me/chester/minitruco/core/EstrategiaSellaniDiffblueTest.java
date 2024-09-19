package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EstrategiaSellaniDiffblueTest {
    /**
     * Method under test: {@link EstrategiaSellani#joga(SituacaoJogo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testJoga() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read the array length because "s.cartasJogador" is null
        //       at me.chester.minitruco.core.EstrategiaSellani.classificaCartas(EstrategiaSellani.java:39)
        //       at me.chester.minitruco.core.EstrategiaSellani.joga(EstrategiaSellani.java:367)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();

        // Act
        estrategiaSellani.joga(new SituacaoJogo());
    }

    /**
     * Method under test: {@link EstrategiaSellani#aceitaTruco(SituacaoJogo)}
     */
    @Test
    void testAceitaTruco() {
        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();
        SituacaoJogo s = new SituacaoJogo();
        s.cartasJogador = new Carta[]{new Carta("S Carta")};

        // Act and Assert
        assertFalse(estrategiaSellani.aceitaTruco(s));
        assertArrayEquals(new int[]{0, 0, 0}, estrategiaSellani.C);
    }

    /**
     * Method under test: {@link EstrategiaSellani#aceitaTruco(SituacaoJogo)}
     */
    @Test
    void testAceitaTruco2() {
        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();
        SituacaoJogo s = new SituacaoJogo();
        Carta carta = new Carta("4567QJKA23");
        s.cartasJogador = new Carta[]{carta, new Carta("4567QJKA23")};

        // Act and Assert
        assertFalse(estrategiaSellani.aceitaTruco(s));
        assertArrayEquals(new int[]{1, 0, 0}, estrategiaSellani.C);
    }

    /**
     * Method under test: {@link EstrategiaSellani#aceitaTruco(SituacaoJogo)}
     */
    @Test
    void testAceitaTruco3() {
        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();

        Carta carta = new Carta("S Carta");
        carta.setFechada(true);
        SituacaoJogo s = new SituacaoJogo();
        s.cartasJogador = new Carta[]{carta};

        // Act and Assert
        assertFalse(estrategiaSellani.aceitaTruco(s));
        assertArrayEquals(new int[]{0, 0, 0}, estrategiaSellani.C);
    }

    /**
     * Method under test: {@link EstrategiaSellani#aceitaTruco(SituacaoJogo)}
     */
    @Test
    void testAceitaTruco4() {
        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();
        SituacaoJogo s = new SituacaoJogo();
        Carta carta = new Carta("A23456789JQK");
        s.cartasJogador = new Carta[]{carta, new Carta("4567QJKA23")};

        // Act and Assert
        assertFalse(estrategiaSellani.aceitaTruco(s));
        assertArrayEquals(new int[]{0, 1, 1}, estrategiaSellani.C);
    }

    /**
     * Method under test:
     * {@link EstrategiaSellani#aceitaMaoDeX(Carta[], SituacaoJogo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAceitaMaoDeX() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot load from object array because "s.cartasJogador" is null
        //       at me.chester.minitruco.core.EstrategiaSellani.aceitaMaoDeX(EstrategiaSellani.java:737)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        EstrategiaSellani estrategiaSellani = new EstrategiaSellani();

        // Act
        estrategiaSellani.aceitaMaoDeX(new Carta[]{new Carta("S Carta")}, new SituacaoJogo());
    }
}
