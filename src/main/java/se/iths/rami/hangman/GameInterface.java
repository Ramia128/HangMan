package se.iths.rami.hangman;

public interface GameInterface {
    String gameInfo();

    String lose();

    String win();

    int tries();

    String guess(String guess);

    boolean gameOver();
}
