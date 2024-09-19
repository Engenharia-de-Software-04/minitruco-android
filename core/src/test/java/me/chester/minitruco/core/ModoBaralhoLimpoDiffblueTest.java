package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModoBaralhoLimpoDiffblueTest {
    /**
     * Method under test: {@link ModoBaralhoLimpo#isBaralhoLimpo()}
     */
    @Test
    void testIsBaralhoLimpo() {
        // Arrange, Act and Assert
        assertTrue((new ModoBaralhoLimpo()).isBaralhoLimpo());
    }
}
