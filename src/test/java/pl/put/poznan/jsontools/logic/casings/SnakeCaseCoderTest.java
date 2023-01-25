package pl.put.poznan.jsontools.logic.casings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeCaseCoderTest {
    static String snakeCase = "testing_snake_case";
    static String[] words = new String[]{"testing", "snake", "case"};

    @Test
    void decode() {
        SnakeCaseCoder snakeCaseCoder = new SnakeCaseCoder();
        assertArrayEquals(words, snakeCaseCoder.decode(snakeCase));
    }

    @Test
    void encode() {
        SnakeCaseCoder snakeCaseCoder = new SnakeCaseCoder();
        assertEquals(snakeCase, snakeCaseCoder.encode(words));
    }
}