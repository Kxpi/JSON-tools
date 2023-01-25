package pl.put.poznan.jsontools.logic.casings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CamelCaseCoderTest {

    static String camelCase = "testingCamelCase";
    static String[] words = new String[]{"testing", "camel", "case"};
    @Test
    void decode() {
        CamelCaseCoder camelCaseCoder = new CamelCaseCoder();
        assertArrayEquals(words, camelCaseCoder.decode(camelCase));
    }

    @Test
    void encode() {
        CamelCaseCoder camelCaseCoder = new CamelCaseCoder();
        assertEquals(camelCase, camelCaseCoder.encode(words));
    }
}