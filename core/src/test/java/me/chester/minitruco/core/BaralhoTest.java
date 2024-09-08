package me.chester.minitruco.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BaralhoTest {
    @Mock
    Random random;
    @Mock
    Vector<Carta> sorteadas;

    Baralho baralho;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        baralho = new Baralho(true);
    }

    @Test
    void testSorteiaCarta() {
        when(random.nextInt(anyInt())).thenReturn(0);
        when(sorteadas.contains(any(Object.class))).thenReturn(true);

        Carta result = baralho.sorteiaCarta();
        verify(sorteadas).addElement(any(Carta.class));
        Assertions.assertEquals(new Carta('a', 0), result);
    }

    @Test
    void testEmbaralha() {

        baralho.embaralha();
        try {
            Field field = Baralho.class.getDeclaredField("sorteadas");
            field.setAccessible(true);
            Vector<Carta> sorteadas = (Vector<Carta>) field.get(baralho);
            assertNotNull(sorteadas);
            assertTrue(sorteadas.isEmpty());
        } catch (Exception e) {
            fail("Não foi possível acessar o campo 'sorteadas': " + e.getMessage());
        }
        }

    @Test
    void testTiraDoBaralho() {
        baralho.tiraDoBaralho(new Carta('a', 0));
        verify(sorteadas).addElement(any(Carta.class));
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
