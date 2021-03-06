/*
MIT License

Copyright (c) 2020 cicciog

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. 
*/
package quizLogic;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cicciog
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
    public void testGetNextQuestion() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        ArrayList<QuizEntity> quizSession;
        quizSession = (ArrayList<QuizEntity>) instance.generateQuiz();
        QuizEntity currentQuiz = quizSession.get(0);
        assertEquals(currentQuiz,instance.getCurrentQuestion());
        instance.getNextQuestion();
        assertNotEquals(currentQuiz,instance.getCurrentQuestion());
    }

    /**
     * Test of answerTheQuestion method, of class QuizC5Logic.
     */
    @Test
    public void testAnswerTheQuestion() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        instance.generateQuiz();
        String beforeAnswer = instance.getCurrentQuestion().getUserAnswer();
        assertEquals(beforeAnswer,null);
        String userAnswer = "VERO";
        instance.answerTheQuestion(0,userAnswer);
        String result = instance.getCurrentQuestion().getUserAnswer();
        assertEquals(userAnswer,result);
    }

    /**
     * Test of getResult method, of class QuizC5Logic.
     */
    @Test
    public void testGetResult() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        instance.generateQuiz();
        int expectedScore = 10;
        int expectedCorrect = 0;
        int expectedWrong = 0;
        int expectedNotAnswered = 10;
        ResultEntity result = instance.getResult();
        assertEquals(expectedScore,result.getScore());
        assertEquals(expectedCorrect,result.getCorrect());
        assertEquals(expectedWrong,result.getWrong());
        assertEquals(expectedNotAnswered,result.getNotAnswered());
    }

    /**
     * Test of cleanQuizList method, of class QuizC5Logic.
     */
    @Test
    public void testCleanQuizList() throws IOException {
        QuizC5Logic instance = new QuizC5Logic(10);
        instance.generateQuiz();
        assertTrue(instance.getQuizListSize() > 0);
        instance.cleanQuizList();
        assertTrue(instance.getQuizListSize() == 0); 
    }

    /**
     * Test of getQuizListSize method, of class QuizC5Logic.
     */
    @Test
    public void testGetQuizListSize() throws IOException {
        int numberOfquestion = 10;
        QuizC5Logic instance = new QuizC5Logic(numberOfquestion);
        int expectedSize = 0;
        assertEquals(expectedSize,instance.getQuizListSize());
        instance.generateQuiz();
        int size = instance.getQuizListSize();
        assertEquals(numberOfquestion,size);
        
    }

}
