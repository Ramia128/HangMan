package se.iths.rami.hangman;

public interface GameInterface {
    String gameInfo();

    String lose();

    String win();

    String inputPrompt();

    String triesInfo();

    String guess(String guess);

    int tries();

    boolean gameOver();
}
