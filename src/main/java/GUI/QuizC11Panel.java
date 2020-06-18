package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import quizLogic.QuizC11Logic;
import quizLogic.QuizCSVmanager;
import quizLogic.QuizEntity;

/**
 *
 * @author francesco
 */
public class QuizC11Panel extends JPanel {

    JTextArea questionLabel;
    JTextArea questionProgress;
    public JButton trueButton;
    public JButton wrongButton;
    private QuizEntity currentQuiz = null;
    int quizCounter = 0;
    QuizC11Logic quizC11Logic;
    private ArrayList<QuizEntity> fullC11QuizList;
    private QuizCSVmanager quizCSVmanager;

    public QuizC11Panel() {
        setBackground(Color.decode("#FFFFFF"));
        setLayout(null);

        quizCSVmanager = new QuizCSVmanager();
        try {
            fullC11QuizList = (ArrayList<QuizEntity>) quizCSVmanager.readAllC11Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        quizC11Logic = new QuizC11Logic(fullC11QuizList, 10);
        System.out.println(quizC11Logic.getCurrentQuestion().getQuestion());
        this.currentQuiz = quizC11Logic.getCurrentQuestion();
    }

    public void initQuizPanel(Dimension pDimension) {
        createQuestionLabel(pDimension);
        createTrueButton(pDimension);
        createWrongButton(pDimension);
        createQuestionProgessLabel(pDimension);

        this.add(questionLabel);
        this.add(trueButton);
        this.add(wrongButton);
        this.add(questionProgress);
    }

    private void createQuestionLabel(Dimension pDimension) {
        questionLabel = new JTextArea();
        questionLabel.setSize(pDimension.width / 24 * 6, pDimension.height / 2 / 6 * 2);
        questionLabel.setLocation(pDimension.width / 24, pDimension.height / 12);
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setBackground(Color.decode("#5c6bc0"));
        questionLabel.setForeground(Color.decode("#FFFFFF"));
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        questionLabel.setText(currentQuiz.getQuestion());
    }

    private void createTrueButton(Dimension pDimension) {
        trueButton = new JButton();
        trueButton.setBackground(Color.decode("#43a047"));
        trueButton.setForeground(Color.decode("#FFFFFF"));
        trueButton.setSize(pDimension.width / 24 * 2, pDimension.height / 12);
        trueButton.setLocation(pDimension.width / 24, pDimension.height / 12 * 4);
        trueButton.setLabel("Vero");
    }

    private void createWrongButton(Dimension pDimension) {
        wrongButton = new JButton();
        wrongButton.setBackground(Color.decode("#bf360c"));
        wrongButton.setForeground(Color.decode("#FFFFFF"));
        wrongButton.setSize(pDimension.width / 24 * 2, pDimension.height / 12);
        wrongButton.setLocation(pDimension.width / 24 * 5, pDimension.height / 12 * 4);
        wrongButton.setLabel("Falso");
    }

    private void createQuestionProgessLabel(Dimension pDimension) {
        questionProgress = new JTextArea();
        questionProgress.setBackground(Color.decode("#FFFFFF"));
        questionProgress.setForeground(Color.decode("#000000"));
        questionProgress.setSize((int) (pDimension.width / 24 * 2.5), pDimension.height / 12);
        questionProgress.setLocation(pDimension.width / 24 * 3, 20);
        questionProgress.setText("Domanda n. " + (quizCounter + 1));
        questionProgress.setFont(new Font("Arial", Font.BOLD, 14));

    }

}
