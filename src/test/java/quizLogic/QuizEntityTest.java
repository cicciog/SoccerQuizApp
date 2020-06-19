package quizLogic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class QuizEntityTest {

    public QuizEntityTest() {
    }

    /**
     * Test of getRule method, of class QuizEntity.
     */
    @Test
    public void testGetRule() {
        QuizEntity instance = new QuizEntity();
        String result = instance.getRule();
        assertEquals(null, result);
        String rule = "ASS";
        instance.setRule(rule);
        result = instance.getRule();
        assertEquals(rule, result);

    }

    /**
     * Test of setRule method, of class QuizEntity.
     */
    @Test
    public void testSetRule() {
        QuizEntity instance = new QuizEntity();
        String rule = "NOT";
        instance.setRule(rule);
        String result = instance.getRule();
        assertEquals(rule, result);
    }

    /**
     * Test of getQuestion method, of class QuizEntity.
     */
    @Test
    public void testGetQuestion() {
        QuizEntity instance = new QuizEntity();
        String result = instance.getQuestion();
        assertEquals(null, result);
        String question = "What time is it?";
        instance.setQuestion(question);
        result = instance.getQuestion();
        assertEquals(question, result);
    }

    /**
     * Test of setQuestion method, of class QuizEntity.
     */
    @Test
    public void testSetQuestion() {
        QuizEntity instance = new QuizEntity();
        String question = "How are you?";
        instance.setQuestion(question);
        String result = instance.getQuestion();
        assertEquals(question, result);
    }

    /**
     * Test of getAnswer method, of class QuizEntity.
     */
    @Test
    public void testGetAnswer() {
        QuizEntity instance = new QuizEntity();
        String result = instance.getAnswer();
        assertEquals(null, result);
        String answer = "VERO";
        instance.setAnswer(answer);
        result = instance.getAnswer();
        assertEquals(answer, result);
    }

    /**
     * Test of setAnswer method, of class QuizEntity.
     */
    @Test
    public void testSetAnswer() {
        QuizEntity instance = new QuizEntity();
        String answer = "FALSO";
        instance.setAnswer(answer);
        String result = instance.getAnswer();
        assertEquals(answer, result);
    }

    /**
     * Test of getUserAnswer method, of class QuizEntity.
     */
    @Test
    public void testGetUserAnswer() {
        QuizEntity instance = new QuizEntity();
        String result = instance.getAnswer();
        assertEquals(null, result);
        String userAnswer = "VERO";
        instance.setUserAnswer(userAnswer);
        result = instance.getUserAnswer();
        assertEquals(userAnswer,result);
    }

    /**
     * Test of setUserAnswer method, of class QuizEntity.
     */
    @Test
    public void testSetUserAnswer() {
        QuizEntity instance = new QuizEntity();
        String userAnswer = "FALSO";
        instance.setAnswer(userAnswer);
        String result = instance.getAnswer();
        assertEquals(userAnswer,result);
    }

    /**
     * Test of toString method, of class QuizEntity.
     */
    @Test
    public void testToString() {
        QuizEntity instance = new QuizEntity();
        String expected = "QuizC11Entity{rule=null, question=null, answer=null, userAnswer=null}";
        String result = instance.toString();
        assertEquals(expected,result);
        instance.setRule("R13");
        instance.setQuestion("How old are you?");
        instance.setAnswer("TRUE");
        instance.setUserAnswer("TRUE");
        expected = "QuizC11Entity{rule=R13, question=How old are you?, answer=TRUE, userAnswer=TRUE}";
        result = instance.toString();
        assertEquals(expected,result);
        
    }

}
