package me.chester.minitruco.core;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class JogadorBotGPTTest {

    @Mock
    private EstrategiaGasparotto estrategiaMock;

    @InjectMocks
    private JogadorBot jogadorBot;

    @Test
    public void testFazerJogadaComMock() {
        SituacaoJogo situacao = new SituacaoJogo();
        Carta cartaMock = new Carta(Naipe.OUROS, Valor.REI);

        // Simula o comportamento da estratégia
        when(estrategiaMock.calcularJogada(situacao)).thenReturn(cartaMock);

        Carta jogada = jogadorBot.fazerJogada(situacao);

        // Verifica se a jogada foi a esperada
        assertThat(jogada, is(cartaMock));
        verify(estrategiaMock).calcularJogada(situacao); // Verifica se o método foi chamado
    }
}
