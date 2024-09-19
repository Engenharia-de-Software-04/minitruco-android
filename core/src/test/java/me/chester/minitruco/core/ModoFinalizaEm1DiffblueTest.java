package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ModoFinalizaEm1DiffblueTest {
    /**
     * Method under test: {@link ModoFinalizaEm1#pontuacaoParaMaoDeX()}
     */
    @Test
    void testPontuacaoParaMaoDeX() {
        // Arrange, Act and Assert
        assertEquals(0, (new ModoFinalizaEm1()).pontuacaoParaMaoDeX());
    }
}
