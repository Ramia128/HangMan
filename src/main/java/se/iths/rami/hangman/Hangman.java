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
        return "\nGissa det hemliga ordet en bokstav i taget. Du har 6 försök.\n" +
                "Det hemliga ordet har " + secretWord.length() + " bokstäver.\n";
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

        if (tries == 0 || !result.contains("_")) {
            gameOver = true;
        }

        return result;
    }

    private String guessChecker(String guess) {
        if (guess == null || guess.isEmpty()) {
            throw new IllegalArgumentException("Gissningen får inte vara tom");
        }
        if (!guess.matches("[a-zA-ZåäöÅÄÖ]")) {
            throw new IllegalArgumentException("Gissningen måste vara endast en bokstav");
        }
        return guess;
    }

    @Override
    public String inputPrompt() {
        return "Gissa Bokstav: ";
    }

    @Override
    public String triesInfo() {
        return "Antal försök kvar: " + tries() + "\n";
    }

    @Override
    public String win() {
        return "Vinnare! Du gissade rätt: " + secretWord;
    }

    @Override
    public String lose() {
        return "Game Over! du har inga fler försök kvar.\n" + "Hemliga ordet är: " + secretWord;
    }

    public int tries() {
        return tries;
    }

    @Override
    public boolean gameOver() {
        return gameOver;
    }


    void setTries(int tries) {
        this.tries = tries;
    }
}
