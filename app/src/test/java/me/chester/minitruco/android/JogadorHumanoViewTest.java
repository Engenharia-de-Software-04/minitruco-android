package me.chester.minitruco.android;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class JogadorHumanoViewTest {

    JogadorHumanoView jogadorHumanoView;
    private MesaView mockMesaView;

    @BeforeEach
    void setUp() {
        mockMesaView = mock(MesaView.class);
        jogadorHumanoView = spy(new JogadorHumanoView(mock(TrucoActivity.class), mockMesaView));
    }

    @Test
    void dizFraseDeVitoriaOuDerrotaNoFimDoJogo() {
        doReturn(1).when(jogadorHumanoView).getEquipe();
        jogadorHumanoView.jogoFechado(1, 0);
        jogadorHumanoView.jogoFechado(2, 0);

        doReturn(2).when(jogadorHumanoView).getEquipe();
        jogadorHumanoView.jogoFechado(1, 0);
        jogadorHumanoView.jogoFechado(2, 0);

        InOrder inOrder = inOrder(mockMesaView);

        inOrder.verify(mockMesaView).diz(eq("vitoria"), eq(1), anyInt(), eq(0));
        inOrder.verify(mockMesaView).diz(eq("derrota"), eq(1), anyInt(), eq(0));
        inOrder.verify(mockMesaView).diz(eq("derrota"), eq(1), anyInt(), eq(0));
        inOrder.verify(mockMesaView).diz(eq("vitoria"), eq(1), anyInt(), eq(0));
    }
}
