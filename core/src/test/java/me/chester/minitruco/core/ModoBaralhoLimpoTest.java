package me.chester.minitruco.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModoBaralhoLimpoTest {
    ModoBaralhoLimpo modoBaralhoLimpo = new ModoBaralhoLimpo();

    @Test
    void testIsBaralhoLimpo() {
        boolean result = modoBaralhoLimpo.isBaralhoLimpo();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testPontuacaoParaMaoDeX() {
        int result = modoBaralhoLimpo.pontuacaoParaMaoDeX();
        Assertions.assertEquals(11, result);  //ajustado de acordo com ModoPaulista
    }

    @Test
    void testValorInicialDaMao() {
        int result = modoBaralhoLimpo.valorInicialDaMao();
        Assertions.assertEquals(1, result); //ajustado de acordo com ModoPaulista
    }

    @Test
    void testValorDaMaoDeX() {
        int result = modoBaralhoLimpo.valorDaMaoDeX();
        Assertions.assertEquals(3, result); //ajustado de acordo com ModoPaulista
    }

    @Test
    void testValorSeHouverAumento() {
        int result = modoBaralhoLimpo.valorSeHouverAumento(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testIsManilhaVelha() {
        Modo modoBaralhoLimpo = Modo.fromString("L");
        boolean result = modoBaralhoLimpo.isManilhaVelha();
        Assertions.assertEquals(false, result);
    }

    @Test
    void testFromString() {
        Modo expected = new ModoPaulista();
        Modo result = Modo.fromString("P");

        Assertions.assertEquals(expected.pontuacaoParaMaoDeX(), result.pontuacaoParaMaoDeX());
        Assertions.assertEquals(expected.valorInicialDaMao(), result.valorInicialDaMao());
        Assertions.assertEquals(expected.valorDaMaoDeX(), result.valorDaMaoDeX());
        Assertions.assertEquals(expected.valorSeHouverAumento(0), result.valorSeHouverAumento(0));
        Assertions.assertEquals(expected.isBaralhoLimpo(), result.isBaralhoLimpo());
        Assertions.assertEquals(expected.isManilhaVelha(), result.isManilhaVelha());
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
