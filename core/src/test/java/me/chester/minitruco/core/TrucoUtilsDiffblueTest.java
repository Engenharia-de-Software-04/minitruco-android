package me.chester.minitruco.core;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TrucoUtilsDiffblueTest {
    /**
     * Method under test:
     * {@link TrucoUtils#montaNotificacaoI(Object[], String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMontaNotificacaoI() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
        //       at me.chester.minitruco.core.TrucoUtils.montaNotificacaoI(TrucoUtils.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        TrucoUtils.montaNotificacaoI(new Object[]{"Nomes"}, "Modo", "Sala");
    }

    /**
     * Method under test: {@link TrucoUtils#nomeHtmlParaDisplay(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNomeHtmlParaDisplay() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 2
        //       at me.chester.minitruco.core.TrucoUtils.nomeHtmlParaDisplay(TrucoUtils.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        TrucoUtils.nomeHtmlParaDisplay("Notificacao I", 1);
    }
}
