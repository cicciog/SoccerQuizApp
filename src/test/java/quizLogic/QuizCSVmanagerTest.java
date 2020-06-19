package quizLogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesco
 */
public class QuizCSVmanagerTest {

    public QuizCSVmanagerTest() {
    }

    /**
     * Test of readAllC11Quizzes method, of class QuizCSVmanager.
     */
    @Test
    public void testReadAllC11Quizzes() throws Exception {
        ArrayList<QuizEntity> quizList = null;
        QuizCSVmanager instance = new QuizCSVmanager();
        assertNotNull(instance);
        quizList = (ArrayList<QuizEntity>) instance.readAllC11Quizzes("./storage/quiz_c11.csv");
        assertTrue(quizList.size() > 0);
    }

    /**
     * Test of readAllC5Quizzes method, of class QuizCSVmanager.
     */
    @Test
    public void testReadAllC5Quizzes() throws Exception {
        ArrayList<QuizEntity> quizList = null;
        QuizCSVmanager instance = new QuizCSVmanager();
        assertNotNull(instance);
        quizList = (ArrayList<QuizEntity>) instance.readAllC11Quizzes("./storage/quiz_c5.csv");
        assertTrue(quizList.size() > 0);
    }

}
