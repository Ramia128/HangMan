package se.iths.rami.hangman;

public class Main {
    static void main() {
        GameInterface game = new Hangman();
        RunGame runGame = new RunGame(game);

        runGame.run();
    }
}
