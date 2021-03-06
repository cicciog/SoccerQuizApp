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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cicciog
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
