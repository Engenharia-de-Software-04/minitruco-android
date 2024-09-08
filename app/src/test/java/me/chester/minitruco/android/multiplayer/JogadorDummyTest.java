package me.chester.minitruco.android.multiplayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import me.chester.minitruco.core.Carta;
import me.chester.minitruco.core.JogadorBot;
import me.chester.minitruco.core.Partida;
import me.chester.minitruco.core.PartidaLocal;

import static org.mockito.Mockito.*;

class JogadorDummyTest {
    @Mock
    Random random;
    //Field cartas of type Carta[] - was not mocked since Mockito doesn't mock arrays
    @Mock
    Partida partida;
    @InjectMocks
    JogadorDummy jogadorDummy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAceitouAumentoAposta() {
        jogadorDummy.aceitouAumentoAposta(new JogadorBot(), 0, 0);
    }

    @Test
    void testCartaJogada() {
        jogadorDummy.cartaJogada(new JogadorBot(), new Carta('a', 0));
    }

    @Test
    void testDecidiuMaoDeX() {
        jogadorDummy.decidiuMaoDeX(new JogadorBot(), true, 0);
    }

    @Test
    void testInformaMaoDeX() {
        jogadorDummy.informaMaoDeX(new Carta[]{new Carta('a', 0)});
    }

    @Test
    void testInicioMao() {
        jogadorDummy.inicioMao(new JogadorBot());
    }

    @Test
    void testInicioPartida() {
        jogadorDummy.inicioPartida(0, 0);
    }

    @Test
    void testJogoAbortado() {
        jogadorDummy.jogoAbortado(0, 0);
    }

    @Test
    void testJogoFechado() {
        jogadorDummy.jogoFechado(0, 0);
    }

    @Test
    void testMaoFechada() {
        jogadorDummy.maoFechada(new int[]{0});
    }

    @Test
    void testPediuAumentoAposta() {
        jogadorDummy.pediuAumentoAposta(new JogadorBot(), 0, 0);
    }

    @Test
    void testRecusouAumentoAposta() {
        jogadorDummy.recusouAumentoAposta(new JogadorBot(), 0);
    }

    @Test
    void testRodadaFechada() {
        jogadorDummy.rodadaFechada(0, 0, new JogadorBot());
    }

    @Test
    void testVez() {
        jogadorDummy.vez(new JogadorBot(), true);
    }


    @Test
    void testEntrouNoJogo() {
        jogadorDummy.entrouNoJogo(new JogadorBot(), new PartidaLocal(true, true, "P"));
    }

    @Test
    void testGetEquipe() {
        int result = jogadorDummy.getEquipe();
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGetParceiro() {
        int result = jogadorDummy.getParceiro();
        Assertions.assertEquals(2, result);
    }

    @Test
    void testGetEquipeAdversaria() {
        int result = jogadorDummy.getEquipeAdversaria();
        Assertions.assertEquals(1, result);
    }

}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
