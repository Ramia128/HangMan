package se.iths.rami.hangman;

public class RunGame {
    private GameInterface game;

    public RunGame(GameInterface game) {
        this.game = game;
    }

    public void run() {
        do {
            IO.println("Lives left: " + game.tries());
            String guess = IO.readln("Gissa Bokstav: ");
            IO.println(game.guess(guess) + "\n");
        } while (!game.gameOver());
        if (game.gameOver() && game.tries() == 0) {
            IO.println("Game Over! no more tries left.");
        } else {
            IO.println(game.win());
        }
    }
}
