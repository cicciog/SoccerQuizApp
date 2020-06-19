package quizLogic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class ResultEntityTest {
    
    public ResultEntityTest() {
    }

    /**
     * Test of getScore method, of class ResultEntity.
     */
    @Test
    public void testGetScore() {
        ResultEntity instance = new ResultEntity();
        int expected = 10;
        instance.setScore(expected);
        int result = instance.getScore();
        assertEquals(expected,result);
    }

    /**
     * Test of setScore method, of class ResultEntity.
     */
    @Test
    public void testSetScore() {
        ResultEntity instance = new ResultEntity();
        int pScore = 30;
        instance.setScore(pScore);
        int result = instance.getScore();
        assertEquals(pScore,result);
    }

    /**
     * Test of getCorrect method, of class ResultEntity.
     */
    @Test
    public void testGetCorrect() {
        ResultEntity instance = new ResultEntity();
        int expected = 7;
        instance.setCorrect(expected);
        int result = instance.getCorrect();
        assertEquals(expected,result);
    }

    /**
     * Test of setCorrect method, of class ResultEntity.
     */
    @Test
    public void testSetCorrect() {
        ResultEntity instance = new ResultEntity();
        assertEquals(instance.getCorrect(),0);
        int correctAnswer = 5;
        instance.setCorrect(correctAnswer);
        int result = instance.getCorrect();
        assertEquals(result,correctAnswer);
        
    }

    /**
     * Test of getWrong method, of class ResultEntity.
     */
    @Test
    public void testGetWrong() {
        ResultEntity instance = new ResultEntity();
        int expected = 0;
        int result = instance.getWrong();
        assertEquals(expected,result);
    }

    /**
     * Test of setWrong method, of class ResultEntity.
     */
    @Test
    public void testSetWrong() {
        ResultEntity instance = new ResultEntity();
        int wrongAnswer = 5;
        instance.setWrong(wrongAnswer);
        int result = instance.getWrong();
        assertEquals(wrongAnswer,result);
    }

    /**
     * Test of getNotAnswered method, of class ResultEntity.
     */
    @Test
    public void testGetNotAnswered() {
        ResultEntity instance = new ResultEntity();
        int expected = 0;
        int result = instance.getNotAnswered();
        assertEquals(expected,result);
    }

    /**
     * Test of setNotAnswered method, of class ResultEntity.
     */
    @Test
    public void testSetNotAnswered() {
        ResultEntity instance = new ResultEntity();
        int notAnsweredQuestion = 3;
        instance.setNotAnswered(notAnsweredQuestion);
        int result = instance.getNotAnswered();
        assertEquals(notAnsweredQuestion,result);
    }

    /**
     * Test of toString method, of class ResultEntity.
     */
    @Test
    public void testToString() {
        ResultEntity instance = new ResultEntity();
        String expected = "ResultEntity{score=0, correct=0, wrong=0, notAnswered=0}";
        String result = instance.toString();
        assertEquals(expected,result);
        instance.setCorrect(8);
        instance.setWrong(1);
        instance.setNotAnswered(1);
        instance.setScore(23);
        String expected1 = "ResultEntity{score=23, correct=8, wrong=1, notAnswered=1}";
        String result1 = instance.toString();
        assertEquals(expected,result);
    }
    
}
