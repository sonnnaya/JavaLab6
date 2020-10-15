package com.company;

import java.util.HashMap;
import java.util.regex.Pattern;

public class UaEnTranslater implements Translater {
    private HashMap<String, String> dictionary;

    public UaEnTranslater() {
        this.dictionary = new HashMap<>();
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String translate(String text) {
        if (text == null)
            throw new IllegalArgumentException();

        var pattern = Pattern.compile("[а-яА-ЯіІїЇєЄ]+");
        var matcher = pattern.matcher(text);

        while (matcher.find()) {
            var source = matcher.group();
            var translation = dictionary.get(source.toLowerCase());
            translation = toCapitalCase(source, translation);
            text = text.replaceFirst("[а-яА-ЯіІїЇєЄҐґ]+", translation);
        }

        return text;
    }

    @Override
    public void addPair(String source, String translation) {
        if (source == null || translation == null)
            throw new IllegalArgumentException();
        dictionary.put(source.toLowerCase(), translation.toLowerCase());
    }

    private static String toCapitalCase(String source, String translation) {
        if (translation != null) {
            if (isCapitalCase(source))
                translation = translation.substring(0, 1).toUpperCase() + translation.substring(1);
        }
        return translation;
    }

    private static boolean isCapitalCase(String source) {
        return source.substring(0, 1).matches("[A-ЯЇЄІҐ]");
    }
}
