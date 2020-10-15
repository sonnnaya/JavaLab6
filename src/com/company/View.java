package com.company;

import java.util.Scanner;

public class View {
    public static final String ENTER_TEXT = "\nEnter text: ";
    public static final String ENTER_PAIR = "\nEnter word and its translation:";
    public static final String TRANSLATED = "\nTranslated text:";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message, String source) {
        System.out.println(message);
        System.out.println(source);
    }

    public static String getString(String message) {
        System.out.println(message);
        var inStream = new Scanner(System.in);
        return inStream.nextLine();
    }

}
