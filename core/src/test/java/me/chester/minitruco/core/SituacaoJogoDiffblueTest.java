package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SituacaoJogoDiffblueTest {
    /**
     * Method under test: {@link SituacaoJogo#toString()}
     */
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals("pos:0,pontos:0,0,rodada:0,results:0,0,0,valMao:0", (new SituacaoJogo()).toString());
    }
}
