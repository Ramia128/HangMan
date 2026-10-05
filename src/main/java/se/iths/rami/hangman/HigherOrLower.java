package se.iths.rami.hangman;

public class HigherOrLower implements GameInterface {
    private boolean gameOver = false;
    private int tries = 3;
    private int randomNumber = (int) (Math.random() * 20) + 1;
    private int score;


    @Override
    public String gameInfo() {
        return "Simple higher or lower game\nStarting number: " + randomNumber + "\n";
    }

    @Override
    public String guess(String guess) {
        int num = randomNumber;
        randomGen();

        if (guess.equals("1")) {
            if (randomNumber > num) {
                score++;
                IO.println(win());
            } else {
                tries--;
                IO.println("Wrong!");
            }
        } else if (guess.equals("2")) {
            if (randomNumber < num) {
                score++;
                IO.println(win());
            } else {
                tries--;
                IO.println("Wrong!");
            }
        } else {
            throw new IllegalArgumentException("Input 1 or 2 only.");
        }


        if (tries == 0) {
            gameOver = true;
        }

        return "\nCurrent number: " + randomNumber;
    }

    private void randomGen() {
        randomNumber = (int) (Math.random() * 20 + 1);
    }


    @Override
    public String lose() {
        return "You lost.. you had " + score + " total points!";
    }

    @Override
    public String win() {
        return "\nCorrect!\nScore: " + score;
    }

    @Override
    public String inputPrompt() {
        return "1. Higher - 2. Lower: ";
    }

    @Override
    public String triesInfo() {
        return "Total lives: " + tries;
    }


    @Override
    public int tries() {
        return tries;
    }

    @Override
    public boolean gameOver() {
        return gameOver;
    }
}
