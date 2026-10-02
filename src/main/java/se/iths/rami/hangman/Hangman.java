package se.iths.rami.hangman;

import java.util.HashSet;

public class Hangman implements GameInterface {
    private boolean gameOver = false;
    private final String secretWord;
    private int tries = 6;
    private HashSet<Character> charHash = new HashSet<>();

    public Hangman() {
        String[] words = {"Kanel", "Cayenne", "Peppar", "Bil", "Apa",
                "Lejon", "Skruvmejsel", "Högskola", "Skåpbil", "Orangutang"};
        this.secretWord = words[(int) (Math.random() * words.length)].toLowerCase();
    }

    @Override
    public String gameInfo() {
        return "";
    }

    @Override
    public String guess(String guess) {

        String result = "";
        char guessChar = guessChecker(guess).charAt(0);
        if (charHash.contains(guessChar)) {
            IO.println("Du har redan gissat den bokstaven");
        } else {
            charHash.add(guessChar);

            if (secretWord.indexOf(guessChar) < 0) {
                tries--;
            }
        }

        for (int i = 0; i < secretWord.length(); i++) {
            char secretChar = Character.toLowerCase(secretWord.charAt(i));
            if (charHash.contains(secretChar)) {
                result += secretChar;
            } else {
                result += "_";
            }
        }

        if (tries == 0) {
            gameOver = true;
        }

        return result;
    }

    private String guessChecker(String guess) {
        if (guess == null) {
            throw new IllegalArgumentException("Det får inte vara null");
        }
        if (guess.isEmpty()) {
            throw new IllegalArgumentException("Gissningen får inte vara tom");
        }
        if (guess.length() > 1) {
            throw new IllegalArgumentException("Gissningen får inte vara mer än en bokstav");
        }
        return guess;
    }

    public int tries() {
        return tries;
    }

    @Override
    public boolean gameOver() {
        return gameOver;
    }
}
