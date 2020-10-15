package com.company.classes;

public class StringCase {
    public static boolean isCapitalCase(String source) {
        var index = firstAlphabeticCharIndex(source);
        if (-1 == index) return false;

        var checkableChar = source.charAt(index);
        return Character.isUpperCase(checkableChar);
    }

    public static String toCapitalCase(String source) {
        var index = firstAlphabeticCharIndex(source);
        if (-1 == index) return source;

        var letter = source.substring(index, index + 1);
        var capitalLetter = letter.toUpperCase();

        var builder = new StringBuilder(source.toLowerCase());
        builder.replace(index, index + 1, capitalLetter);

        return builder.toString();
    }

    private static int firstAlphabeticCharIndex(String source) {
        var index = source.chars()
                .takeWhile(c -> !Character.isAlphabetic(c))
                .count();

        return index != source.length() ? (int)index : -1;
    }
}
