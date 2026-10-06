package se.iths.rami.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {
    Hangman hangman;


    @BeforeEach
    void setUp() {
        hangman = new Hangman();
    }


    // Initial start
    @Test
    @DisplayName("tries() equals 6 on start")
    void startSixTries() {
        assertEquals(6, hangman.tries());
    }

    @Test
    @DisplayName("gameOver() return false on start")
    void startGameOverFalse() {
        assertFalse(hangman.gameOver());
    }

    //After initialization
    @Test
    @DisplayName("gameOver() returns true")
    void gameOverTrue() {
        hangman.setTries(1);
        hangman.guess("z");
        assertTrue(hangman.gameOver());
    }

    @Test
    @DisplayName("result equals the right placement of character")
    void resultCorrectPlacement() {
        hangman.setSecretWord("katastrofal");
        assertEquals("_a_a_____a_", hangman.guess("a"));
    }

    @Test
    @DisplayName("gameOver set to true if correct guessed word")
    void gameOverTrueWhenCorrectWord() {
        hangman.setSecretWord("Orangutang");
        String[] guessWord = {"o", "r", "a", "N", "G", "u", "t"};

        for (String guess : guessWord) {
            hangman.guess(guess);
        }

        assertTrue(hangman.gameOver());
    }

    @Test
    @DisplayName("guess() doesnt consume try on right letter")
    void guessRightLetter() {
        hangman.setSecretWord("kanel");
        hangman.guess("k");
        assertEquals(6, hangman.tries());
    }

    @Test
    @DisplayName("guess() consume tries when wrong guess")
    void guessWrongLetter() {
        hangman.guess("z");
        assertEquals(5, hangman.tries());
    }

    @Test
    @DisplayName("guess() doesnt consume tries if same letter used")
    void guessSameLetter() {
        hangman.guess("z");
        hangman.guess("z");
        assertEquals(5, hangman.tries());
    }

    @Test
    @DisplayName("guess() throws exception when null")
    void guessNull() {
        assertThrows(IllegalArgumentException.class, () -> hangman.guess(null));
    }

    @Test
    @DisplayName("guess() throws exception when empty")
    void guessEmpty() {
        assertThrows(IllegalArgumentException.class, () -> hangman.guess(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "!", "aa", "abcd"})
    @DisplayName("guess() throws exception when not using only a single letter")
    void guessInvalidInput(String s) {
        assertThrows(IllegalArgumentException.class, () -> hangman.guess(s));
    }

}
