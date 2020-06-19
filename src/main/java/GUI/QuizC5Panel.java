package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import quizLogic.QuizC5Logic;
import quizLogic.QuizEntity;

/**
 *
 * @author francesco
 */
public class QuizC5Panel extends JPanel {

    public JTextArea questionLabel;
    public JTextArea questionProgress;
    public JButton trueButton;
    public JButton wrongButton;
    private QuizEntity currentQuiz = null;
    public int quizCounter;
    public QuizC5Logic quizC5Logic;
    private ArrayList<QuizEntity> quizList;
    private int numberOfQuestion;

    public QuizC5Panel() {
        setBackground(Color.decode("#FFFFFF"));
        setLayout(null);
        trueButton = new JButton();
        wrongButton = new JButton();

    }

    public void initQuizPanel(Dimension pDimension) {

        try {

            this.quizC5Logic = new QuizC5Logic(numberOfQuestion);
            this.quizCounter = 0;

            this.quizList = (ArrayList<QuizEntity>) quizC5Logic.generateQuiz();
            this.currentQuiz = this.quizList.get(0);

            createQuestionLabel(pDimension);
            createTrueButton(pDimension);
            createWrongButton(pDimension);
            createQuestionProgessLabel(pDimension);

            this.add(questionLabel);
            this.add(trueButton);
            this.add(wrongButton);
            this.add(questionProgress);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void createQuestionLabel(Dimension pDimension) {
        questionLabel = new JTextArea();
        questionLabel.setSize(pDimension.width / 24 * 6, pDimension.height / 2 / 6 * 2);
        questionLabel.setLocation(pDimension.width / 24, pDimension.height / 12);
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setFocusable(false);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setBackground(Color.decode("#5c6bc0"));
        questionLabel.setForeground(Color.decode("#FFFFFF"));
        questionLabel.setFont(new Font("Arial", Font.BOLD, 12));
        questionLabel.setText(this.currentQuiz.getQuestion());
    }

    private void createTrueButton(Dimension pDimension) {
        trueButton.setBackground(Color.decode("#43a047"));
        trueButton.setForeground(Color.decode("#FFFFFF"));
        trueButton.setSize(pDimension.width / 24 * 2, pDimension.height / 12);
        trueButton.setLocation(pDimension.width / 24, pDimension.height / 12 * 4);
        trueButton.setLabel("Vero");
    }

    private void createWrongButton(Dimension pDimension) {
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

    public void setNumberOfQuiz(int pNumberOfQuestion) {
        this.numberOfQuestion = pNumberOfQuestion;
    }
    
    public int getNumberOfQuiz(){
        return this.numberOfQuestion;
    }

    public void cleanQuiz() {
        this.currentQuiz = null;
        this.quizCounter = 0;
        this.quizList.clear();
    }

    public void setCurrentQuestion() {
        this.currentQuiz = this.quizList.get(0);
        this.questionLabel.setText(this.currentQuiz.getQuestion());
    }

}
