package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class BaralhoDiffblueTest {
    /**
     * Method under test: {@link Baralho#sorteiaCarta()}
     */
    @Test
    void testSorteiaCarta() {
        // Arrange, Act and Assert
        assertFalse((new Baralho(true)).sorteiaCarta().isFechada());
        assertFalse((new Baralho(false)).sorteiaCarta().isFechada());
    }

    /**
     * Method under test: {@link Baralho#embaralha()}
     */
    @Test
    void testEmbaralha() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        (new Baralho(true)).embaralha();
    }

    /**
     * Method under test: {@link Baralho#tiraDoBaralho(Carta)}
     */
    @Test
    void testTiraDoBaralho() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Baralho.limpo
        //     Baralho.random
        //     Baralho.sorteadas

        // Arrange
        Baralho baralho = new Baralho(true);

        // Act
        baralho.tiraDoBaralho(new Carta("S Carta"));
    }

    /**
     * Method under test: {@link Baralho#Baralho(boolean)}
     */
    @Test
    void testNewBaralho() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Baralho.limpo
        //     Baralho.random
        //     Baralho.sorteadas

        // Arrange and Act
        new Baralho(true);
    }
}
