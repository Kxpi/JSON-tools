package pl.put.poznan.jsontools.logic.casings;

public class CamelCaseCoder implements CaseCoder {
    @Override
    public String[] decode(String text) {
        String[] words = text.split("(?=\\p{Lu})");
        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toLowerCase(words[i].charAt(0)) + words[i].substring(1);
        }
        return words;
    }

    @Override
    public String encode(String[] words) {
        if (words.length == 0) return null;
        String camel = words[0];
        for (int i = 1; i < words.length; i++) {
            camel += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        return camel;
    }
}
