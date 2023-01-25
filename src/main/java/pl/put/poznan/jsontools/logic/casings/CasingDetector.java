package pl.put.poznan.jsontools.logic.casings;

/**
 * Utility class providing casing scheme detector.
 */
public class CasingDetector {

    /**
     * Decides what casing scheme has been used to write
     * the string `text`.
     * 
     * @param text The string to analyze
     * @return One of casing schemes or unknown if the scheme
     *         cannot be determined
     */
    public CasingScheme detectCasingScheme(String text) {
        // Note: this is an optimistic approach :P
        if (text.contains("_")) {
            return CasingScheme.SNAKE_CASE;
        }
        if (text.matches("[a-z]+[A-Z][a-z]+")) {
            return CasingScheme.CAMEL_CASE;
        }
        return CasingScheme.UNKNOWN;
    }
}
