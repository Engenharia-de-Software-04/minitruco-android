package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModoManilhaVelhaDiffblueTest {
    /**
     * Method under test: {@link ModoManilhaVelha#isManilhaVelha()}
     */
    @Test
    void testIsManilhaVelha() {
        // Arrange, Act and Assert
        assertTrue((new ModoManilhaVelha()).isManilhaVelha());
    }
}
