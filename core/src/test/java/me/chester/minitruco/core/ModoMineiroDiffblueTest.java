package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModoMineiroDiffblueTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ModoMineiro#isBaralhoLimpo()}
     *   <li>{@link ModoMineiro#isManilhaVelha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        ModoMineiro modoMineiro = new ModoMineiro();

        // Act
        boolean actualIsBaralhoLimpoResult = modoMineiro.isBaralhoLimpo();

        // Assert
        assertFalse(actualIsBaralhoLimpoResult);
        assertTrue(modoMineiro.isManilhaVelha());
    }

    /**
     * Method under test: {@link ModoMineiro#pontuacaoParaMaoDeX()}
     */
    @Test
    void testPontuacaoParaMaoDeX() {
        // Arrange, Act and Assert
        assertEquals(10, (new ModoMineiro()).pontuacaoParaMaoDeX());
    }

    /**
     * Method under test: {@link ModoMineiro#valorInicialDaMao()}
     */
    @Test
    void testValorInicialDaMao() {
        // Arrange, Act and Assert
        assertEquals(2, (new ModoMineiro()).valorInicialDaMao());
    }

    /**
     * Method under test: {@link ModoMineiro#valorDaMaoDeX()}
     */
    @Test
    void testValorDaMaoDeX() {
        // Arrange, Act and Assert
        assertEquals(4, (new ModoMineiro()).valorDaMaoDeX());
    }

    /**
     * Method under test: {@link ModoMineiro#valorSeHouverAumento(int)}
     */
    @Test
    void testValorSeHouverAumento() {
        // Arrange, Act and Assert
        assertEquals(0, (new ModoMineiro()).valorSeHouverAumento(42));
        assertEquals(4, (new ModoMineiro()).valorSeHouverAumento(2));
        assertEquals(6, (new ModoMineiro()).valorSeHouverAumento(4));
        assertEquals(10, (new ModoMineiro()).valorSeHouverAumento(6));
        assertEquals(12, (new ModoMineiro()).valorSeHouverAumento(10));
    }
}
