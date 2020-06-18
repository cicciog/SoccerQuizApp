package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import quizLogic.QuizC11Logic;
import quizLogic.QuizCSVmanager;
import quizLogic.QuizEntity;

/**
 *
 * @author francesco
 */
public class ApplicationFrame extends JFrame {

    //set screen size 
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension FRAME_SIZE = new Dimension(screenSize.width / 3, screenSize.height / 2);

    //panel declaration
    private StartPanel startPanel;
    private QuizC11Panel quizC11panel;
    private QuizC5Panel quizC5Panel;
    private PiePanel piePanel;
    private ArrayList<QuizEntity> fullC11QuizList;
    private QuizCSVmanager quizCSVManager;

    public ApplicationFrame(String pTitle) {

        this.setTitle(pTitle);
        this.setSize(screenSize.width / 3, screenSize.height / 2);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_SIZE);

        piePanel = new PiePanel();
        initPanel(piePanel, false);

        startPanel = new StartPanel();
        initPanel(startPanel, true);

        quizC11panel = new QuizC11Panel();
        quizC11panel.initQuizPanel(screenSize);
        initPanel(quizC11panel, false);

        startPanel.startQuizBtn.addActionListener((ActionEvent e) -> {
            if (startPanel.chooseType.getSelectedItem().equals("scegli quiz")) {
                // display the jdialog when type of quiz didn't selected
                JOptionPane.showMessageDialog(null, "Attenzione! Non hai scelto il tipo di quiz che desideri svolgere");
            } else if (startPanel.chooseType.getSelectedItem().equals("Calcio a 11")) {
                JOptionPane.showMessageDialog(null, "Desideri fare i quiz di calcio a 11");
                swapPanel(startPanel, quizC11panel);
                startPanel.invalidate();
                startPanel.removeAll();
                piePanel.validate();
            } else {
                JOptionPane.showMessageDialog(null, "Desideri fare i quiz di calcio a 5");
                swapPanel(startPanel, piePanel);
                startPanel.invalidate();
                startPanel.removeAll();
                piePanel.validate();
            }
        });

    }

    private void initPanel(JPanel pPanel, boolean pValue) {
        pPanel.setSize(FRAME_SIZE);
        pPanel.setVisible(pValue);
        this.add(pPanel);
    }

    private void swapPanel(JPanel pFrom, JPanel pTo) {
        pTo.setVisible(true);
        pFrom.setVisible(false);
    }

}
