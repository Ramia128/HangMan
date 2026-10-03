package se.iths.rami.hangman;

public class RunGame {
    private GameInterface game;

    public RunGame(GameInterface game) {
        this.game = game;
    }

    public void run() {
        IO.println(game.gameInfo());
        do {
            IO.println(game.triesInfo());
            String guess = IO.readln(game.inputPrompt());
            try {
                IO.println(game.guess(guess) + "\n");
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        } while (!game.gameOver());
        if (game.gameOver() && game.tries() == 0) {
            IO.println(game.lose());
        } else {
            IO.println(game.win());
        }
    }
}
