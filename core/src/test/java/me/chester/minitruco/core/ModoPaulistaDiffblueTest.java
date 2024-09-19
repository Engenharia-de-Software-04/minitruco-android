package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ModoPaulistaDiffblueTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ModoPaulista#isBaralhoLimpo()}
     *   <li>{@link ModoPaulista#isManilhaVelha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        ModoPaulista modoPaulista = new ModoPaulista();

        // Act
        boolean actualIsBaralhoLimpoResult = modoPaulista.isBaralhoLimpo();

        // Assert
        assertFalse(actualIsBaralhoLimpoResult);
        assertFalse(modoPaulista.isManilhaVelha());
    }

    /**
     * Method under test: {@link ModoPaulista#pontuacaoParaMaoDeX()}
     */
    @Test
    void testPontuacaoParaMaoDeX() {
        // Arrange, Act and Assert
        assertEquals(11, (new ModoPaulista()).pontuacaoParaMaoDeX());
    }

    /**
     * Method under test: {@link ModoPaulista#valorInicialDaMao()}
     */
    @Test
    void testValorInicialDaMao() {
        // Arrange, Act and Assert
        assertEquals(1, (new ModoPaulista()).valorInicialDaMao());
    }

    /**
     * Method under test: {@link ModoPaulista#valorDaMaoDeX()}
     */
    @Test
    void testValorDaMaoDeX() {
        // Arrange, Act and Assert
        assertEquals(3, (new ModoPaulista()).valorDaMaoDeX());
    }

    /**
     * Method under test: {@link ModoPaulista#valorSeHouverAumento(int)}
     */
    @Test
    void testValorSeHouverAumento() {
        // Arrange, Act and Assert
        assertEquals(0, (new ModoPaulista()).valorSeHouverAumento(42));
        assertEquals(3, (new ModoPaulista()).valorSeHouverAumento(1));
        assertEquals(6, (new ModoPaulista()).valorSeHouverAumento(3));
        assertEquals(9, (new ModoPaulista()).valorSeHouverAumento(6));
        assertEquals(12, (new ModoPaulista()).valorSeHouverAumento(9));
    }
}
