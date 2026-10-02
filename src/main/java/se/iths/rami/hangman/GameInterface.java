package se.iths.rami.hangman;

public interface GameInterface {
    String gameInfo();

    int tries();

    String guess(String guess);

    boolean gameOver();
}
