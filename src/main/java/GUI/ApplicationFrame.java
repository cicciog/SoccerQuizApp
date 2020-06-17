package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import quizLogic.QuizC11Logic;
import quizLogic.QuizC5Logic;
import quizLogic.QuizCSVmanager;
import quizLogic.QuizEntity;

/**
 *
 * @author francesco
 */
public class ApplicationFrame extends JFrame {
    // java - get screen size using the Toolkit class

    private Dimension screenSize;
    private StartPanel startPanel;
    private QuizC5Panel quizPanel;
    private Pie piePanel;

    public ApplicationFrame(String pTitle) throws IOException {
        // invoke the JFrame constructor
        super(pTitle);

        //frame size
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 3, screenSize.height / 2);

        //add start panel
        startPanel = new StartPanel(screenSize);
        
        
        QuizCSVmanager quizC11manager = new QuizCSVmanager();
        ArrayList<QuizEntity> quizList = new ArrayList<>();
        QuizC5Logic quizC5Logic = null;
        
        try {
            quizList = (ArrayList<QuizEntity>) quizC11manager.readAllC11Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
            quizC5Logic = new QuizC5Logic(quizList, 10);
        } catch (NullPointerException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        quizPanel = new QuizC5Panel(screenSize,quizC5Logic);
        //add(startPanel);
        //add(quizPanel);
        Dimension dimension = new Dimension(screenSize.width / 3, screenSize.height / 2);
        Pie pie = new Pie(dimension);
        add(pie);

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// add the label to the JFrame
    }

}
