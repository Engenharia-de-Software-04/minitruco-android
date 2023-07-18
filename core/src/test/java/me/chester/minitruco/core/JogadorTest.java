package me.chester.minitruco.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JogadorTest {

    private static String sanitizaNome(String nome) {
        return Jogador.sanitizaNome(nome);
    }

    @Test
    void sanitizaNomePreservaAlfaNuméricosAcentuadosEUnderscore() {
        assertEquals("Carlos", sanitizaNome("Carlos"));
        assertEquals("Pixel_2_XL", sanitizaNome("Pixel 2 XL"));
        assertEquals("Kindle_Fire", sanitizaNome("Kindle Fire"));
        assertEquals("João_Da_Silva_123", sanitizaNome("João Da Silva_123"));
        assertEquals("éíóúãõ_ç_á_à_â_ê_ô_ü_ñ", sanitizaNome("éíóúãõ ç á à â ê ô ü ñ"));
        assertEquals("ÉÍÓÚÃÕ_Ç_Á_À_Â_Ê_Ô_Ü_Ñ", sanitizaNome("ÉÍÓÚÃÕ Ç Á À Â Ê Ô Ü Ñ"));
        assertEquals("Carlos_san", sanitizaNome("こんにちは, Carlos-san!"));
        assertEquals("Carlos", sanitizaNome("💩Carlos💩"));
        assertEquals("1_2_3_4", sanitizaNome("-1_2-3 4-"));
        assertEquals("sem_espaços", sanitizaNome("sem espaços"));
        assertEquals("sem_espaços", sanitizaNome("   sem    espaços    "));
        assertEquals("semtabs", sanitizaNome("sem\ttabs"));
        assertEquals("sempipes", sanitizaNome("sem|pipes"));
        assertEquals("semastericos", sanitizaNome("sem*astericos"));
        assertEquals("sem_quebras_de_linha", sanitizaNome("sem\nquebras\r\nde\rlinha\n\r!\n\n\n\n!\r\r\r\r!"));
        assertEquals("sem_repetir_fim", sanitizaNome("sem repetir: -----_____-----! fim."));
        assertEquals("odd_whitespace", sanitizaNome("odd whitespace:	              ​    　"));
        assertEquals("C0_control_chars", sanitizaNome("C0 control chars: \u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\u0008\u000B\u000C\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u001B\u001C\u001D\u001E\u001F"));
        assertEquals("C1_control_chars", sanitizaNome("C1 control chars: \u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u008B\u008C\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u009B\u009C\u009E\u009F"));
        assertEquals("alignment_and_direction", sanitizaNome("­؀؁؂؃؄؅؜۝܏᠎​‌‍‎‏‪‫‬‭‮⁠⁡⁢⁣⁤⁦alignment and direction: ⁧⁨⁩⁪⁫⁬⁭⁮⁯﻿￹￺￻𑂽𛲠𛲡𛲢𛲣𝅳𝅴𝅵𝅶𝅷𝅸𝅹𝅺󠀁󠀠󠀡󠀢󠀣󠀤󠀥󠀦󠀧󠀨󠀩󠀪󠀫󠀬󠀭󠀮󠀯󠀰󠀱󠀲󠀳󠀴󠀵󠀶󠀷󠀸󠀹󠀺󠀻󠀼󠀽󠀾󠀿󠁀󠁁󠁂󠁃󠁄󠁅󠁆󠁇󠁈󠁉󠁊󠁋󠁌󠁍󠁎󠁏󠁐󠁑󠁒󠁓󠁔󠁕󠁖󠁗󠁘󠁙󠁚󠁛󠁜󠁝󠁞󠁟󠁠󠁡󠁢󠁣󠁤󠁥󠁦󠁧󠁨󠁩󠁪󠁫󠁬󠁭󠁮󠁯󠁰󠁱󠁲󠁳󠁴󠁵󠁶󠁷󠁸󠁹󠁺󠁻󠁼󠁽󠁾󠁿"));
        assertEquals("crashy_on_iOS_Power_h_0", sanitizaNome("crashy on iOS: Powerلُلُصّبُلُلصّبُررً ॣ ॣh ॣ ॣ冗🏳0🌈️జ్ఞ‌ా\uDB40\uDC00 "));
    }

    @Test
    void sanitizaNomeUsaDefaultSeNãoTiverCaracteresVálidos() {
        assertEquals("Jogador(a)", sanitizaNome(null));
        assertEquals("Jogador(a)", sanitizaNome(""));
        assertEquals("Jogador(a)", sanitizaNome("_"));
        assertEquals("Jogador(a)", sanitizaNome("-"));
        assertEquals("Jogador(a)", sanitizaNome("___--__"));
        assertEquals("Jogador(a)", sanitizaNome("-------"));
        assertEquals("Jogador(a)", sanitizaNome("💩"));
        assertEquals("Jogador(a)", sanitizaNome("誰かの名前を日本語で"));
    }

    @Test
    void sanitizaNomeLimitaTamanhoEm25CaracteresValidos() {
        assertEquals("1234567890123456789012345",
            sanitizaNome("!!$$|1234567890123456789012345"));
        assertEquals("1234567890123456789012345",
            sanitizaNome("!!$$|1234567890123456789012345excesso"));
    }
}
