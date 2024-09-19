package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CartaDiffblueTest {
    /**
     * Method under test: {@link Carta#setLetra(char)}
     */
    @Test
    void testSetLetra() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setLetra('A');

        // Assert
        assertEquals('A', carta.getLetra());
    }

    /**
     * Method under test: {@link Carta#setLetra(char)}
     */
    @Test
    void testSetLetra2() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setLetra(Carta.LETRA_NENHUMA);

        // Assert
        assertEquals(Carta.LETRA_NENHUMA, carta.getLetra());
    }

    /**
     * Method under test: {@link Carta#setLetra(char)}
     */
    @Test
    void testSetLetra3() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setLetra('￿');

        // Assert that nothing has changed
        assertEquals(Carta.LETRA_NENHUMA, carta.getLetra());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(1);

        // Assert
        assertEquals(1, carta.getNaipe());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe2() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(0);

        // Assert
        assertEquals(0, carta.getNaipe());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe3() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(3);

        // Assert
        assertEquals(3, carta.getNaipe());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe4() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(2);

        // Assert
        assertEquals(2, carta.getNaipe());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe5() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(4);

        // Assert
        assertEquals(4, carta.getNaipe());
    }

    /**
     * Method under test: {@link Carta#setNaipe(int)}
     */
    @Test
    void testSetNaipe6() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setNaipe(-1);

        // Assert that nothing has changed
        assertEquals(4, carta.getNaipe());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Carta#equals(Object)}
     *   <li>{@link Carta#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        // Arrange
        Carta carta = new Carta("S Carta");
        Carta carta2 = new Carta("S Carta");

        // Act and Assert
        assertEquals(carta, carta2);
        int expectedHashCodeResult = carta.hashCode();
        assertEquals(expectedHashCodeResult, carta2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Carta#equals(Object)}
     *   <li>{@link Carta#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act and Assert
        assertEquals(carta, carta);
        int expectedHashCodeResult = carta.hashCode();
        assertEquals(expectedHashCodeResult, carta.hashCode());
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco() {
        // Arrange, Act and Assert
        assertEquals(0, (new Carta("S Carta")).getValorTruco('A'));
        assertEquals(0, (new Carta("A23456789JQK")).getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco2() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(1);
        carta.setFechada(false);
        carta.setLetra('7');

        // Act and Assert
        assertEquals(11, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco3() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(2);
        carta.setFechada(false);
        carta.setLetra('7');

        // Act and Assert
        assertEquals(4, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco4() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(0);
        carta.setFechada(false);
        carta.setLetra('7');

        // Act and Assert
        assertEquals(13, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco5() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(1);
        carta.setFechada(false);
        carta.setLetra('A');

        // Act and Assert
        assertEquals(8, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco6() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(2);
        carta.setFechada(false);
        carta.setLetra('A');

        // Act and Assert
        assertEquals(12, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco7() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(1);
        carta.setFechada(false);
        carta.setLetra('4');

        // Act and Assert
        assertEquals(1, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco8() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setNaipe(3);
        carta.setFechada(false);
        carta.setLetra('4');

        // Act and Assert
        assertEquals(14, carta.getValorTruco(Carta.LETRA_NENHUMA));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco9() {
        // Arrange
        Carta carta = new Carta("S Carta");
        carta.setFechada(true);

        // Act and Assert
        assertEquals(0, carta.getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco10() {
        // Arrange
        Carta carta = new Carta("A23456789JQK");
        carta.setNaipe(3);

        // Act and Assert
        assertEquals(14, carta.getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco11() {
        // Arrange
        Carta carta = new Carta("A23456789JQK");
        carta.setNaipe(1);

        // Act and Assert
        assertEquals(11, carta.getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco12() {
        // Arrange
        Carta carta = new Carta("A23456789JQK");
        carta.setNaipe(2);

        // Act and Assert
        assertEquals(12, carta.getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#getValorTruco(char)}
     */
    @Test
    void testGetValorTruco13() {
        // Arrange
        Carta carta = new Carta("A23456789JQK");
        carta.setNaipe(0);

        // Act and Assert
        assertEquals(13, carta.getValorTruco('A'));
    }

    /**
     * Method under test: {@link Carta#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        // Arrange
        Carta carta = new Carta("A23456789JQK");

        // Act and Assert
        assertNotEquals(carta, new Carta("S Carta"));
    }

    /**
     * Method under test: {@link Carta#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        // Arrange
        Carta carta = new Carta("coepx");

        // Act and Assert
        assertNotEquals(carta, new Carta("S Carta"));
    }

    /**
     * Method under test: {@link Carta#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        // Arrange, Act and Assert
        assertNotEquals(new Carta("S Carta"), null);
    }

    /**
     * Method under test: {@link Carta#equals(Object)}
     */
    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        // Arrange, Act and Assert
        assertNotEquals(new Carta("S Carta"), "Different type to Carta");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Carta#setFechada(boolean)}
     *   <li>{@link Carta#toString()}
     *   <li>{@link Carta#getLetra()}
     *   <li>{@link Carta#getNaipe()}
     *   <li>{@link Carta#isFechada()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Carta carta = new Carta("S Carta");

        // Act
        carta.setFechada(true);
        String actualToStringResult = carta.toString();
        char actualLetra = carta.getLetra();
        int actualNaipe = carta.getNaipe();

        // Assert that nothing has changed
        assertEquals("Xx", actualToStringResult);
        assertEquals(4, actualNaipe);
        assertTrue(carta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualLetra);
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta() {
        // Arrange and Act
        Carta actualCarta = new Carta('A', 1);

        // Assert
        assertEquals('A', actualCarta.getLetra());
        assertEquals(1, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta2() {
        // Arrange and Act
        Carta actualCarta = new Carta(Carta.LETRA_NENHUMA, 0);

        // Assert
        assertEquals(0, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta3() {
        // Arrange and Act
        Carta actualCarta = new Carta(Carta.LETRA_NENHUMA, 3);

        // Assert
        assertEquals(3, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta4() {
        // Arrange and Act
        Carta actualCarta = new Carta(Carta.LETRA_NENHUMA, 2);

        // Assert
        assertEquals(2, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta5() {
        // Arrange and Act
        Carta actualCarta = new Carta(Carta.LETRA_NENHUMA, 4);

        // Assert
        assertEquals(4, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta6() {
        // Arrange and Act
        Carta actualCarta = new Carta('\u0004', 1);

        // Assert
        assertEquals(1, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(char, int)}
     */
    @Test
    void testNewCarta7() {
        // Arrange and Act
        Carta actualCarta = new Carta('A', 88);

        // Assert
        assertEquals('A', actualCarta.getLetra());
        assertEquals(4, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
    }

    /**
     * Method under test: {@link Carta#Carta(String)}
     */
    @Test
    void testNewCarta8() {
        // Arrange and Act
        Carta actualCarta = new Carta("S Carta");

        // Assert
        assertEquals(4, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(String)}
     */
    @Test
    void testNewCarta9() {
        // Arrange and Act
        Carta actualCarta = new Carta("coepx");

        // Assert
        assertEquals(1, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }

    /**
     * Method under test: {@link Carta#Carta(String)}
     */
    @Test
    void testNewCarta10() {
        // Arrange and Act
        Carta actualCarta = new Carta("A23456789JQK");

        // Assert
        assertEquals('A', actualCarta.getLetra());
        assertEquals(4, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
    }

    /**
     * Method under test: {@link Carta#Carta(String)}
     */
    @Test
    void testNewCarta11() {
        // Arrange and Act
        Carta actualCarta = new Carta("me.chester.minitruco.core.Carta");

        // Assert
        assertEquals(2, actualCarta.getNaipe());
        assertFalse(actualCarta.isFechada());
        assertEquals(Carta.LETRA_NENHUMA, actualCarta.getLetra());
    }
}
