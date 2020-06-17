package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

    private JTextArea questionLabel;
    private JTextArea questionProgress;
    private JButton trueButton;
    private JButton wrongButton;
    private QuizEntity currentQuiz = null;
    private int quizCounter = 0;

    public QuizC5Panel(Dimension pDimension, QuizC5Logic pQuizC5Logic) {
        super();

        currentQuiz = pQuizC5Logic.getCurrentQuestion();
        System.out.println(currentQuiz.getQuestion());
        
        setSize(pDimension.width / 3, pDimension.height / 2);
        setBackground(Color.decode("#FFFFFF"));
        setLayout(null);
        setVisible(false);

        createQuestionLabel(pDimension);
        createTrueButton(pDimension, pQuizC5Logic);
        createWrongButton(pDimension, pQuizC5Logic);
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

    private void createTrueButton(Dimension pDimension, QuizC5Logic pQuizC5Logic) {
        trueButton = new JButton();
        trueButton.setBackground(Color.decode("#43a047"));
        trueButton.setForeground(Color.decode("#FFFFFF"));
        trueButton.setSize(pDimension.width / 24 * 2, pDimension.height / 12);
        trueButton.setLocation(pDimension.width / 24, pDimension.height / 12 * 4);
        trueButton.setLabel("Vero");
        trueButton.addActionListener((ActionEvent ae) -> {
            pQuizC5Logic.answerTheQuestion(quizCounter, "VERO");
            
            if (quizCounter + 1 < 10) {
                questionLabel.setText(pQuizC5Logic.getNextQuestion().getQuestion());
                quizCounter++;
                questionProgress.setText("Domanda n. "+(quizCounter+1));
            } else {
                System.out.println(pQuizC5Logic.getResult());
            }
        });
    }

    private void createWrongButton(Dimension pDimension, QuizC5Logic pQuizC5Logic) {
        wrongButton = new JButton();
        wrongButton.setBackground(Color.decode("#bf360c"));
        wrongButton.setForeground(Color.decode("#FFFFFF"));
        wrongButton.setSize(pDimension.width / 24 * 2, pDimension.height / 12);
        wrongButton.setLocation(pDimension.width / 24 * 5, pDimension.height / 12 * 4);
        wrongButton.setLabel("Falso");
        wrongButton.addActionListener((ActionEvent ae) -> {
            pQuizC5Logic.answerTheQuestion(quizCounter, "FALSO");
            
            if (quizCounter + 1 < 10) {
                questionLabel.setText(pQuizC5Logic.getNextQuestion().getQuestion());
                quizCounter++;
                questionProgress.setText("Domanda n. "+(quizCounter+1));
            } else {
                System.out.println(pQuizC5Logic.getResult());
            }
        });
    }

    private void createQuestionProgessLabel(Dimension pDimension) {
        questionProgress = new JTextArea();
        questionProgress.setBackground(Color.decode("#FFFFFF"));
        questionProgress.setForeground(Color.decode("#000000"));
        questionProgress.setSize((int) (pDimension.width / 24 * 2.5), pDimension.height / 12);
        questionProgress.setLocation(pDimension.width / 24 * 3,20);
        questionProgress.setText("Domanda n. "+(quizCounter+1));
        questionProgress.setFont(new Font("Arial", Font.BOLD, 14));
        
    }

}
