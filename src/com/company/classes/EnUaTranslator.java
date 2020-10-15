package com.company.classes;

import com.company.interfaces.Translater;

import java.util.HashMap;
import java.util.regex.Pattern;

public class EnUaTranslator implements Translater {
    private final HashMap<String, String> dictionary = new HashMap<>();

    @Override
    public void addPair(String source, String translation) {
        if (source == null || translation == null)
            throw new IllegalArgumentException();

        var key = source.toLowerCase();
        var value = translation.toLowerCase();

        dictionary.put(key, value);
    }

    @Override
    public String translate(String text) {
        if (text == null)
            throw new IllegalArgumentException();

        var pattern = Pattern.compile("[a-zA-Z]+");
        var matcher = pattern.matcher(text);

        while (matcher.find()) {
            var word = matcher.group();
            var translation = translateWord(word);
            text = text.replaceFirst(word, translation);
        }

        return text;
    }

    public String translateWord(String source) {
        var translation = dictionary.get(source.toLowerCase());
        if (null == translation) return source;

        return StringCase.isCapitalCase(source)
                ? StringCase.toCapitalCase(translation)
                : translation;
    }
}
