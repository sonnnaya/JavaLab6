package com.company;

import com.company.classes.EnUaTranslator;
import com.company.classes.View;
import com.company.enums.Languages;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            var translator = new EnUaTranslator();

            var data = View.getData("./resources/data.csv");
            for (var entry : data.entrySet())
                translator.addPair(entry.getKey(), entry.getValue());

//          Blue sky is above my head! Birds sing their songs ^_^, bright sun shines with its warm rays... but then .. autumn came :(

            View.printMessage(View.ENTER_PAIR);
            var source = View.getString("Enter " + Languages.EN.toString() + " word:");
            var translation = View.getString("Enter " + Languages.UA.toString() + " word:");
            translator.addPair(source, translation);

            var text = View.getString(View.ENTER_TEXT);
            View.printMessage(View.TRANSLATED, translator.translate(text));

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }
}
