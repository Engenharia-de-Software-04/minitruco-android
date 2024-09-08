package me.chester.minitruco.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SituacaoJogoTest {
    //Field resultadoRodada of type int[] - was not mocked since Mockito doesn't mock arrays
    //Field pontosEquipe of type int[] - was not mocked since Mockito doesn't mock arrays
    //Field cartasJogadas of type Carta[] - was not mocked since Mockito doesn't mock arrays
    //Field cartasJogador of type Carta[] - was not mocked since Mockito doesn't mock arrays
    SituacaoJogo situacaoJogo = new SituacaoJogo();

    @Test
    void testToString() {
        String result = situacaoJogo.toString();
        Assertions.assertEquals("pos:0,pontos:0,0,rodada:0,results:0,0,0,valMao:0", result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
