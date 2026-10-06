package se.iths.rami.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HighOrLowerTest {
    HigherOrLower hol;

    @BeforeEach
    void setUp() {
        hol = new HigherOrLower();
    }

    // On Start
    @Test
    @DisplayName("tries is set to 3 at start")
    void triesStart() {
        assertEquals(3, hol.tries());
    }

    @Test
    @DisplayName("gameOver is false at start")
    void gameOverStart() {
        assertFalse(hol.gameOver());
    }

    @Test
    @DisplayName("score is 0 at start")
    void startingScore() {
        assertEquals(0, hol.getScore());
    }

    //After Start
    @Test
    @DisplayName("gameOver is True when tries == 0 after guessing high")
    void gameOverHighTrue() {
        hol.setTries(1);
        hol.setRandomNumber(21);
        hol.guess("1");
        assertTrue(hol.gameOver());
    }

    @Test
    @DisplayName("gameOver is True when tries == 0 after guessing low")
    void gameOverLowTrue() {
        hol.setTries(1);
        hol.setRandomNumber(0);
        hol.guess("2");
        assertTrue(hol.gameOver());
    }

    @Test
    @DisplayName("adding to score when guessing correct on high")
    void scoreUpHigh() {
        hol.setRandomNumber(0);
        hol.guess("1");
        assertEquals(1, hol.getScore());
        for (int i = 0; i < 4; i++) {
            hol.setRandomNumber(0);
            hol.guess("1");
        }
        assertEquals(5, hol.getScore());
    }

    @Test
    @DisplayName("adding to score when guessing correct on low")
    void scoreUpLow() {
        hol.setRandomNumber(21);
        hol.guess("2");
        assertEquals(1, hol.getScore());
        for (int i = 0; i < 4; i++) {
            hol.setRandomNumber(21);
            hol.guess("2");
        }
        assertEquals(5, hol.getScore());
    }

    @Test
    @DisplayName("Correct guess doesnt lower tries")
    void rightGuessTries() {
        hol.setRandomNumber(21);
        hol.guess("2");
        assertEquals(3, hol.tries());
    }

    @Test
    @DisplayName("Wrong guess lower tries")
    void wrongGuessTries() {
        hol.setRandomNumber(0);
        hol.guess("2");
        assertEquals(2, hol.tries());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "0", "4", "!", " ", "aa"})
    @DisplayName("guess throws exception on wrong input")
    void guessWrongInput(String guess) {
        assertThrows(IllegalArgumentException.class, () -> hol.guess(guess));
    }

}
