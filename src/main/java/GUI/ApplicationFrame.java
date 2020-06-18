package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private QuizC5Panel quizC5panel;
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
        
        quizC5panel = new QuizC5Panel();
        quizC5panel.initQuizPanel(screenSize);
        initPanel(quizC5panel, false);
        
        startPanel.startQuizBtn.addActionListener((ActionEvent e) -> {
            if (startPanel.chooseType.getSelectedItem().equals("scegli quiz")) {
                // display the jdialog when type of quiz didn't selected
                JOptionPane.showMessageDialog(null, "Attenzione! Non hai scelto il tipo di quiz che desideri svolgere");
            } else if (startPanel.chooseType.getSelectedItem().equals("Calcio a 11")) {
                //show quiz c11 panel and start quiz
                swapPanel(startPanel, quizC11panel);
                startPanel.invalidate();
                startPanel.removeAll();
                piePanel.validate();
            } else {
                //show quiz c5 panel and start quiz
                swapPanel(startPanel, quizC5panel);
                startPanel.invalidate();
                startPanel.removeAll();
                piePanel.validate();
            }
        });
        
        quizC11panel.trueButton.addActionListener((ActionEvent e) -> {
            quizC11panel.quizC11Logic.answerTheQuestion(quizC11panel.quizCounter, "VERO");
            
            if (quizC11panel.quizCounter + 1 < 10) {
                quizC11panel.questionLabel.setText(quizC11panel.quizC11Logic.getNextQuestion().getQuestion());
                quizC11panel.quizCounter++;
                quizC11panel.questionProgress.setText("Domanda n. " + (quizC11panel.quizCounter + 1));
            } else {
                quizC11panel.trueButton.setEnabled(false);
                quizC11panel.wrongButton.setEnabled(false);
                swapPanel(quizC11panel, piePanel);
                
                System.out.println(quizC11panel.quizC11Logic.getResult());
            }
        });
        
        quizC11panel.wrongButton.addActionListener((ActionEvent e) -> {
            quizC11panel.quizC11Logic.answerTheQuestion(quizC11panel.quizCounter, "VERO");
            
            if (quizC11panel.quizCounter + 1 < 10) {
                quizC11panel.questionLabel.setText(quizC11panel.quizC11Logic.getNextQuestion().getQuestion());
                quizC11panel.quizCounter++;
                quizC11panel.questionProgress.setText("Domanda n. " + (quizC11panel.quizCounter + 1));
            } else {
                quizC11panel.trueButton.setEnabled(false);
                quizC11panel.wrongButton.setEnabled(false);
                swapPanel(quizC11panel, piePanel);
                
                System.out.println(quizC11panel.quizC11Logic.getResult());
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
