package pl.put.poznan.jsontools.logic.casings;

public class SnakeCaseCoder implements CaseCoder{
    @Override
    public String[] decode(String text) {
        String[] words = text.split("_");
        return words;
    }

    @Override
    public String encode(String[] words) {
        return String.join("_", words);
    }
}
