package me.chester.minitruco.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SituacaoJogoGPTTest {

    private SituacaoJogo situacaoJogo;

    @BeforeEach
    public void setUp() {
        situacaoJogo = new SituacaoJogo();
    }

    @Test
    public void testAdicionarCartaMesa() {
        Carta carta = new Carta(Naipe.OUROS, Valor.AS);
        situacaoJogo.adicionarCartaMesa(carta);

        // Verifica se a carta foi adicionada corretamente
        assertThat(situacaoJogo.getCartasNaMesa(), hasSize(1));
        assertThat(situacaoJogo.getCartasNaMesa().get(0), is(equalTo(carta)));
    }
}
