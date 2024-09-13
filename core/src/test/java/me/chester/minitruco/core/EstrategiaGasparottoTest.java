package me.chester.minitruco.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class EstrategiaGasparottoTest {

    private EstrategiaGasparotto estrategia;
    private Jogador jogadorMock;
    private SituacaoJogo situacaoMock;

    @BeforeEach
    public void setUp() {
        estrategia = new EstrategiaGasparotto();
        jogadorMock = mock(Jogador.class);
        situacaoMock = mock(SituacaoJogo.class);
    }

    @Test
    public void testCalcularJogada() {
        // Simula as cartas do jogador
        when(jogadorMock.getCartas()).thenReturn(new Carta[]{
            new Carta(Naipe.OUROS, Valor.AS),
            new Carta(Naipe.ESPADAS, Valor.DOIS),
            new Carta(Naipe.COPAS, Valor.REI)
        });

        // Configura a situação do jogo
        when(situacaoMock.getCartasNaMesa()).thenReturn(new Carta[]{});
        when(situacaoMock.isTrucado()).thenReturn(false);

        // Chama o método a ser testado
        Carta jogada = estrategia.decidirJogada(jogadorMock, situacaoMock);

        // Verifica se a jogada não é nula
        assertThat(jogada, is(notNullValue()));

        // Verifica se a jogada está entre as cartas do jogador
        assertThat(jogadorMock.getCartas(), hasItemInArray(jogada));
    }

    @Test
    public void testTrucoSituacao() {
        // Verifica se a estratégia considera a situação de truco
        when(situacaoMock.isTrucado()).thenReturn(true);

        Carta jogada = estrategia.decidirJogada(jogadorMock, situacaoMock);

        // Verifica se, em caso de truco, a jogada é feita corretamente
        assertThat(jogada, is(notNullValue()));
        verify(situacaoMock).isTrucado();
    }
}
