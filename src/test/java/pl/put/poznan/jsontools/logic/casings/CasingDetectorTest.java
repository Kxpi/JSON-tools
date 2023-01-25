package pl.put.poznan.jsontools.logic.casings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasingDetectorTest {

    @Test
    void detectCasingScheme() {
        CasingDetector casingDetector = new CasingDetector();
        assertEquals(CasingScheme.CAMEL_CASE, casingDetector.detectCasingScheme("camelCase"));
        assertEquals(CasingScheme.SNAKE_CASE, casingDetector.detectCasingScheme("snake_case"));
        assertEquals(CasingScheme.UNKNOWN, casingDetector.detectCasingScheme("#######"));
    }
}