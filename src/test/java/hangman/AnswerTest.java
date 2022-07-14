package hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    @Test
    public void shouldConvertItselfToAString() {
        Answer answer = new Answer("tree");                                                             // <1>
        assertEquals("tree", answer.toString());                                                        // <2>
    }

    @Test
    public void checkEquality() {
        Answer a = new Answer("cat");
        Answer b = new Answer("cat");
        assertTrue(a.equals(b));                                                                        //<1>
    }

    @Test
    public void giveAHint() {
        Answer solution = new Answer("test");                                                           // <1>
        Answer lastAnswer = new Answer("t__t");                                                         // <2>
        Answer hint = solution.getHint(lastAnswer, 'e');                                                // <3>
        assertEquals(new Answer("te_t"), hint);
    }

    @Test
    public void hasLetter() {
        Answer answer = new Answer("test");
        assertTrue(answer.hasLetter('t'));
        assertFalse(answer.hasLetter('x'));
    }

    @Test
    public void generateRandomHint() {
        Answer wordToGuess = new Answer("test");
        Answer hint = wordToGuess.generateRandomHint();                                                 //<1>

        for (int i = 0; i < hint.toString().length(); i++) {                                            //<2>
            char hintLetter = hint.toString().charAt(i);
            char expectedLetter = wordToGuess.toString().charAt(i);
            if (hintLetter != '_') {
                assertEquals(expectedLetter, hintLetter);
            }
        }
    }
    @Test
    public void checkGuess() {
        Answer wordToGuess = new Answer("test");
        Answer currentAnswer = new Answer("t__t");
        assertTrue(currentAnswer.isGoodGuess(wordToGuess,'e'));                                         //<1>
        assertFalse(currentAnswer.isGoodGuess(wordToGuess,'x'));                                        //<2>
        assertFalse(currentAnswer.isGoodGuess(wordToGuess,'t'));                                        //<3>
    }

}
