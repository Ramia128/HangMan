package se.iths.rami.hangman;

public class GameMenu {

    public void startMenu() {
        boolean menuRun = true;

        while (menuRun) {
            IO.println("""
                    Choose a game you want to play or exit.
                    
                    1. Hangman
                    2. Exit
                    """);

            String menuChoice = IO.readln("Enter your choice: ");
            switch (menuChoice) {
                case "1" -> {
                    GameInterface game = new Hangman();
                    RunGame runGame = new RunGame(game);
                    runGame.run();
                }
                case "2" -> menuRun = false;

                default -> IO.println("Invalid choice.");
            }
        }
    }
}
