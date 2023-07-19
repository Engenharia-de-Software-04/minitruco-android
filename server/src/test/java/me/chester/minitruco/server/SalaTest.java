package me.chester.minitruco.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static java.lang.Thread.sleep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaTest {

    JogadorConectado j1, j2, j3, j4, j5, j6, j7, j8, j9, j10;

    @BeforeEach
    void setUp() {
        Sala.limpaSalas();

        j1 = new JogadorConectado(null);
        j2 = new JogadorConectado(null);
        j3 = new JogadorConectado(null);
        j4 = new JogadorConectado(null);
        j5 = new JogadorConectado(null);
        j6 = new JogadorConectado(null);
        j7 = new JogadorConectado(null);
        j8 = new JogadorConectado(null);
        j9 = new JogadorConectado(null);
        j10 = new JogadorConectado(null);
    }

    @Test
    void testColocaEmSalaPublicaRetornaSalaDeDestino() {
        Sala s = Sala.colocaEmSalaPublica(j1, "P");
        assertEquals(s, j1.getSala());
    }

    @Test
    void testColocaEmSalaPublicaEncaixaJogadores() {
        // Jogadores que pedem o mesmo modo devem ir para a mesma sala
        Sala s1 = Sala.colocaEmSalaPublica(j1, "P");
        Sala.colocaEmSalaPublica(j2, "P");
        Sala.colocaEmSalaPublica(j3, "P");
        Sala.colocaEmSalaPublica(j4, "P");
        assertEquals(s1, j1.getSala());
        assertEquals(s1, j2.getSala());
        assertEquals(s1, j3.getSala());
        assertEquals(s1, j4.getSala());

        // Se não houver mais sala disponível, cria-se uma nova
        Sala s2 = Sala.colocaEmSalaPublica(j5, "P");
        Sala.colocaEmSalaPublica(j6, "P");
        assertNotEquals(s1, s2);
        assertEquals(s2, j5.getSala());
        assertEquals(s2, j6.getSala());

        // Se abrir uma vaga, a sala original é reaproveitada, ou seja
        // uma nova sala só é criada quando esgotarem as vagas em todas
        // as salas existentes daquele modo
        s1.remove(j4);
        // Vão ser distribuídos entre s1 e s2
        Sala.colocaEmSalaPublica(j7, "P");
        Sala.colocaEmSalaPublica(j8, "P");
        Sala.colocaEmSalaPublica(j9, "P");
        // Vai numa nova sala
        Sala.colocaEmSalaPublica(j10, "P");

        assertTrue(j7.getSala() == s1 || j7.getSala() == s2);
        assertTrue(j8.getSala() == s1 || j8.getSala() == s2);
        assertTrue(j9.getSala() == s1 || j9.getSala() == s2);
        assertFalse(j10.getSala() == s1 || j10.getSala() == s2);
    }

    @Test
    void testColocaEmSalaPublicaSeparaPorModo() {
        Sala.colocaEmSalaPublica(j1, "P");
        Sala.colocaEmSalaPublica(j2, "M");
        Sala.colocaEmSalaPublica(j3, "L");
        Sala.colocaEmSalaPublica(j4, "P");

        assertEquals(j1.getSala(), j4.getSala());
        assertNotEquals(j1.getSala(), j2.getSala());
        assertNotEquals(j1.getSala(), j3.getSala());
    }

    @Test
    void testGetInfo() {
        j1.setNome("john");
        j2.setNome("paul");
        j3.setNome("george");
        Sala s = new Sala(true, "P");
        s.adiciona(j1);
        s.adiciona(j2);
        s.adiciona(j3);
        assertEquals("I john|paul|george|bot $POSICAO P FFFT 1", s.getInfo());
        s.remove(j1);
        j2.querJogar = true;
        assertEquals("I bot|paul|george|bot $POSICAO P TTFT 2", s.getInfo());
    }

    @Test
    void testGerente() throws InterruptedException {
        // Os sleeps garantem timestamps diferentes para fins de teste
        // (precisão de java.util.Date é de 1ms); IRL, se houver um
        // empate (bem improvável), o que a classe decidir está bom.
        Sala s = new Sala(true, "P");
        s.adiciona(j1); sleep(1);
        assertEquals(j1, s.getGerente());
        s.adiciona(j2); sleep(1);
        s.adiciona(j3); sleep(1);
        assertEquals(j1, s.getGerente());
        s.remove(j1); sleep(1);
        assertEquals(j2, s.getGerente());
        s.adiciona(j1); sleep(1);
        assertEquals(j2, s.getGerente());
        s.remove(j2); sleep(1);
        assertEquals(j3, s.getGerente());
        s.remove(j1); sleep(1);
        s.remove(j3); sleep(1);
        assertNull(s.getGerente());
    }
}
