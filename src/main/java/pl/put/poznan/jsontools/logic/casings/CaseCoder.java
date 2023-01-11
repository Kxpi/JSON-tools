package pl.put.poznan.jsontools.logic.casings;

/**
 * A specification of operations that ought to be provided
 * by casing scheme decoders/encoders
 */
public interface CaseCoder {

    /**
     * Splits the input text into words
     * @param text The input text
     * @return An array of individual words
     */
    String[] decode(String text);

    /**
     * Combines the array of words into a single string
     * @param words The input array of words
     * @return A string combining the input words
     */
    String encode(String[] words);
}
