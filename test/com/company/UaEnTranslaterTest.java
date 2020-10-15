package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UaEnTranslaterTest {
    UaEnTranslater translater;

    @BeforeEach
    void setUp() {
        translater = new UaEnTranslater();
        translater.addPair("Привіт", "Hi");
        translater.addPair("Сьогодні", "Today");
        translater.addPair("Я", "I");
        translater.addPair("Бачу", "see");
        translater.addPair("Гарну", "beautiful");
        translater.addPair("погоду", "weather");
        translater.addPair("Настрій", "mood");
        translater.addPair("є", "is");
        translater.addPair("чудовим", "great");
        translater.addPair("Мій", "My");
        translater.addPair("дня", "day");
        translater.addPair("Бажаю", "Wish");
        translater.addPair("гарного", "a good");
    }

    @ParameterizedTest
    @MethodSource("sourceAndTranslationProvider")
    void testTranslateWithExistWords(String source, String translation) {
        var actual = translater.translate(source);
        var expected = translation;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sourceAndTranslationProvider")
    void testTranslateWithNotExistWords(String source, String translation) {
        var actual = translater.translate(translation);
        String expected = translation;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sourceAndTranslationProvider")
    void testAddPairWithCorrect(String source, String translation) {
        assertDoesNotThrow(() -> translater.addPair(source, translation));
    }

    @ParameterizedTest
    @MethodSource("sourceAndTranslationProvider")
    void testAddPairWithIncorrect(String source, String translation) {
        assertThrows(IllegalArgumentException.class, () -> translater.addPair(null, translation));
        assertThrows(IllegalArgumentException.class, () -> translater.addPair(source, null));
        assertThrows(IllegalArgumentException.class, () -> translater.addPair(null, null));
    }

    static Stream<Arguments> sourceAndTranslationProvider() {
        return Stream.of(
                Arguments.of("Привіт", "Hi"),
                Arguments.of("Сьогодні", "Today"),
                Arguments.of("Я", "I"),
                Arguments.of("Бачу", "See"),
                Arguments.of("Гарну", "Beautiful"),
                Arguments.of("погоду", "weather"),
                Arguments.of("Настрій", "Mood"),
                Arguments.of("є", "is"),
                Arguments.of("чудовим", "great"),
                Arguments.of("Мій", "My"),
                Arguments.of("Бажаю", "Wish"),
                Arguments.of("гарного", "a good"),
                Arguments.of("дня", "day"),
                Arguments.of("Привіт! Сьогодні, я бачу гарну погоду. Мій настрій є чудовим... Бажаю гарного дня!",
                        "Hi! Today, i see beautiful weather. My mood is great... Wish a good day!")
        );
    }
}