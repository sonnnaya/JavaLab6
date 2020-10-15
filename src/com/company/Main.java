package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            var translater = new UaEnTranslater();
            translater.addPair("Привіт", "Hi");
            translater.addPair("Сонце", "Sun");
            translater.addPair("Квіти", "Flowers");
            translater.addPair("Небо", "Sky");
            translater.addPair("бачу", "see");
            translater.addPair("Я", "I");

            View.printMessage(View.ENTER_PAIR);
            var source = View.getString("Enter " + Languages.UA.toString() + " word:");
            var translation = View.getString("Enter " + Languages.EN.toString() + " word:");
            translater.addPair(source, translation);

            var text = View.getString(View.ENTER_TEXT);
            View.printMessage(View.TRANSLATED, translater.translate(text));
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
