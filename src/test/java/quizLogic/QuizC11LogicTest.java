/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author francesco
 */
public class QuizC11LogicTest {
    
    public QuizC11LogicTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
   

    /**
     * Test of getCurrentQuestion method, of class QuizC11Logic.
     */
    @org.junit.jupiter.api.Test
    public void testGetCurrentQuestion() {
        System.out.println("getCurrentQuestion");
        QuizC11Logic instance = null;
        QuizEntity expResult = null;
        QuizEntity result = instance.getCurrentQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreviousQuestion method, of class QuizC11Logic.
     */
    @org.junit.jupiter.api.Test
    public void testGetPreviousQuestion() {
        System.out.println("getPreviousQuestion");
        QuizC11Logic instance = null;
        QuizEntity expResult = null;
        QuizEntity result = instance.getPreviousQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextQuestion method, of class QuizC11Logic.
     */
    @org.junit.jupiter.api.Test
    public void testGetNextQuestion() {
        System.out.println("getNextQuestion");
        QuizC11Logic instance = null;
        QuizEntity expResult = null;
        QuizEntity result = instance.getNextQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of answerTheQuestion method, of class QuizC11Logic.
     */
    @org.junit.jupiter.api.Test
    public void testAnswerTheQuestion() {
        System.out.println("answerTheQuestion");
        int pQuestion = 0;
        String pAnswer = "";
        QuizC11Logic instance = null;
        instance.answerTheQuestion(pQuestion, pAnswer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class QuizC11Logic.
     */
    @org.junit.jupiter.api.Test
    public void testGetResult() {
        System.out.println("getResult");
        QuizC11Logic instance = null;
        ResultEntity expResult = null;
        ResultEntity result = instance.getResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
