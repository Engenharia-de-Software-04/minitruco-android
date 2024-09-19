package me.chester.minitruco.core;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EstrategiaGasparottoDiffblueTest {
    /**
     * Method under test: {@link EstrategiaGasparotto#joga(SituacaoJogo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testJoga() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read the array length because "s.cartasJogador" is null
        //       at me.chester.minitruco.core.EstrategiaGasparotto.classificaCartas(EstrategiaGasparotto.java:79)
        //       at me.chester.minitruco.core.EstrategiaGasparotto.joga(EstrategiaGasparotto.java:1725)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        EstrategiaGasparotto estrategiaGasparotto = new EstrategiaGasparotto();

        // Act
        estrategiaGasparotto.joga(new SituacaoJogo());
    }

    /**
     * Method under test: {@link EstrategiaGasparotto#aceitaTruco(SituacaoJogo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAceitaTruco() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read the array length because "s.cartasJogador" is null
        //       at me.chester.minitruco.core.EstrategiaGasparotto.classificaCartas(EstrategiaGasparotto.java:79)
        //       at me.chester.minitruco.core.EstrategiaGasparotto.aceitaTruco(EstrategiaGasparotto.java:1772)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        EstrategiaGasparotto estrategiaGasparotto = new EstrategiaGasparotto();

        // Act
        estrategiaGasparotto.aceitaTruco(new SituacaoJogo());
    }

    /**
     * Method under test:
     * {@link EstrategiaGasparotto#aceitaMaoDeX(Carta[], SituacaoJogo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAceitaMaoDeX() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot load from object array because "s.cartasJogador" is null
        //       at me.chester.minitruco.core.EstrategiaGasparotto.aceitaMaoDeX(EstrategiaGasparotto.java:2015)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        EstrategiaGasparotto estrategiaGasparotto = new EstrategiaGasparotto();

        // Act
        estrategiaGasparotto.aceitaMaoDeX(new Carta[]{new Carta("S Carta")}, new SituacaoJogo());
    }

    /**
     * Method under test: {@link EstrategiaGasparotto#setGameLevel(int)}
     */
    @Test
    void testSetGameLevel() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EstrategiaGasparotto.C
        //     EstrategiaGasparotto.chatMsg
        //     EstrategiaGasparotto.gameLevel

        // Arrange and Act
        (new EstrategiaGasparotto()).setGameLevel(1);
    }
}
