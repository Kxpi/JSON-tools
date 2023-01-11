package pl.put.poznan.jsontools.logic.casings;

/**
 * A fallback casing coder. No magic happens here
 */
public class UnknownCaseCoder implements CaseCoder {
    @Override
    public String[] decode(String text) {
        // Treat the input as a single word
        return new String[]{text};
    }

    @Override
    public String encode(String[] words) {
        // Just concatenate the words
        return String.join("", words);
    }
}
