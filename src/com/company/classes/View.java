package com.company.classes;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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

    public static HashMap<String, String> getData(String name) throws IOException, CsvException {
        var data = new HashMap<String, String>();
        try (var reader = new CSVReader(new FileReader(name))) {
            String[] record = null;
            while ((record = reader.readNext()) != null)
                data.put(record[0], record[1]);
        }
        return data;
    }

}
