package com.company;

import com.company.classes.EnUaTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EnUaTranslaterTest {
    EnUaTranslator translater;

    @BeforeEach
    void setUp() {
        translater = new EnUaTranslator();
        translater.addPair("Hi", "Привіт");
        translater.addPair("Today", "Сьогодні");
        translater.addPair("I", "Я");
        translater.addPair("see", "Бачу");
        translater.addPair("beautiful", "Гарну");
        translater.addPair("weather", "погоду");
        translater.addPair("mood", "Настрій");
        translater.addPair("is", "є");
        translater.addPair("great", "чудовим");
        translater.addPair("My", "Мій");
        translater.addPair("day", "дня");
        translater.addPair("Wish", "Бажаю");
        translater.addPair("good", "гарного");
        translater.addPair("a", "");
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
                Arguments.of("Hi", "Привіт"),
                Arguments.of("Today", "Сьогодні"),
                Arguments.of("I", "Я"),
                Arguments.of("See", "Бачу"),
                Arguments.of("Beautiful", "Гарну"),
                Arguments.of("weather", "погоду"),
                Arguments.of("Mood", "Настрій"),
                Arguments.of("Is", "Є"),
                Arguments.of("great", "чудовим"),
                Arguments.of("My", "Мій"),
                Arguments.of("Wish", "Бажаю"),
                Arguments.of("good", "гарного"),
                Arguments.of("day", "дня"),
                Arguments.of("Hi! Today, i see beautiful weather. My mood is great... Wish a good day!",
                        "Привіт! Сьогодні, я бачу гарну погоду. Мій настрій є чудовим... Бажаю  гарного дня!")
        );
    }
}