package quizLogic;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class QuizC5LogicTest {

    public QuizC5LogicTest() {
    }

    /**
     * Test of readAllQuizzes method, of class QuizC5Logic.
     */
    @Test
    public void testReadAllQuizzes() throws Exception {
        QuizC5Logic instance = new QuizC5Logic(10);
        assertNotNull(instance);
        ArrayList<QuizEntity> quizDataSet;
        quizDataSet = (ArrayList<QuizEntity>) instance.readAllQuizzes("./storage/quiz_c5.csv");
        assertTrue(quizDataSet.size() > 0);
    }

    /**
     * Test of generateQuiz method, of class QuizC5Logic.
     */
    @Test
    public void testGenerateQuiz() throws Exception {
        int numberOfQuestion = 10;
        QuizC5Logic instance = new QuizC5Logic(numberOfQuestion);
        assertNotNull(instance);
        ArrayList<QuizEntity> quizSession;
        quizSession = (ArrayList<QuizEntity>) instance.generateQuiz();
        assertTrue(quizSession.size() > 0);
        assertEquals(quizSession.size(),numberOfQuestion);
    }

    /**
     * Test of getCurrentQuestion method, of class QuizC5Logic.
     */
    @Test
    public void testGetCurrentQuestion() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        ArrayList<QuizEntity> quizSession;
        quizSession = (ArrayList<QuizEntity>) instance.generateQuiz();
        QuizEntity currentQuiz = quizSession.get(0);
        assertEquals(currentQuiz,instance.getCurrentQuestion());
        instance.getNextQuestion();
        assertNotEquals(instance.getCurrentQuestion(),currentQuiz);
    }

    /**
     * Test of getPreviousQuestion method, of class QuizC5Logic.
     */
    @Test
    public void testGetPreviousQuestion() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        ArrayList<QuizEntity> quizSession;
        quizSession = (ArrayList<QuizEntity>) instance.generateQuiz();
        QuizEntity currentQuiz = quizSession.get(0);
        assertEquals(currentQuiz,instance.getCurrentQuestion());
        instance.getNextQuestion();
        assertEquals(currentQuiz,instance.getPreviousQuestion());
    }

    /**
     * Test of getNextQuestion method, of class QuizC5Logic.
     */
    @Test
    public void testGetNextQuestion() {
    }

    /**
     * Test of answerTheQuestion method, of class QuizC5Logic.
     */
    @Test
    public void testAnswerTheQuestion() {
    }

    /**
     * Test of getResult method, of class QuizC5Logic.
     */
    @Test
    public void testGetResult() {
    }

    /**
     * Test of cleanQuizList method, of class QuizC5Logic.
     */
    @Test
    public void testCleanQuizList() {
    }

    /**
     * Test of getQuizListSize method, of class QuizC5Logic.
     */
    @Test
    public void testGetQuizListSize() {
    }

}
