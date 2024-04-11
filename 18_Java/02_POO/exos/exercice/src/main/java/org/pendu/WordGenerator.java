package org.pendu;

import java.util.Random;

public class WordGenerator {
    private static final String[] Words = {
            "limousin",
            "bailli",
            "comme",
            "fendu",
            "pelera",
            "jonc",
            "tripes",
            "chat",
            "chien",
            "maison",
            "voiture",
            "ordinateur",
            "montagne",
            "temps",
            "animaux",
            "clavier"
    };

    private static final Random random = new Random();

    public static String generateWord() {
        return Words[random.nextInt(Words.length)];
    }
}
