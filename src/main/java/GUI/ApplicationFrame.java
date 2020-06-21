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
import quizLogic.ResultEntity;

/**
 *
 * @author cicciog
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
    private ResultEntity resultEntity;

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
        quizC11panel.setNumberOfQuiz(startPanel.numberOfQuestion.getValue());
        initPanel(quizC11panel, false);

        quizC5panel = new QuizC5Panel();
        quizC5panel.setNumberOfQuiz(startPanel.numberOfQuestion.getValue());
        initPanel(quizC5panel, false);

        startPanel.startQuizBtn.addActionListener((ActionEvent e) -> {
            if (startPanel.chooseType.getSelectedItem().equals("scegli quiz")) {
                // display the jdialog when type of quiz didn't selected
                JOptionPane.showMessageDialog(null, "Attenzione! Non hai scelto il tipo di quiz che desideri svolgere");
            } else if (startPanel.chooseType.getSelectedItem().equals("Calcio a 11")) {
                //show quiz c5 panel and start quiz
                quizC11panel.setNumberOfQuiz(startPanel.numberOfQuestion.getValue());
                quizC11panel.initQuizPanel(screenSize);
                swapPanel(startPanel, quizC11panel);
            } else {
                //show quiz c5 panel and start quiz
                quizC5panel.setNumberOfQuiz(startPanel.numberOfQuestion.getValue());
                quizC5panel.initQuizPanel(screenSize);
                swapPanel(startPanel, quizC5panel);
            }
        });

        piePanel.retryBtn.addActionListener((ActionEvent e) -> {
            swapPanel(piePanel, startPanel);
            piePanel.invalidate();
            piePanel.removeAll();
            startPanel.validate();
        });

        quizC11panel.trueButton.addActionListener((ActionEvent e) -> {
            quizC11panel.quizC11Logic.answerTheQuestion(quizC11panel.quizCounter, "VERO");

            if (quizC11panel.quizCounter + 1 < quizC11panel.getNumberOfQuiz()) {
                quizC11panel.questionLabel.setText(quizC11panel.quizC11Logic.getNextQuestion().getQuestion());
                quizC11panel.quizCounter++;
                quizC11panel.questionProgress.setText("Domanda n. " + (quizC11panel.quizCounter + 1));
            } else {
                resultEntity = quizC11panel.quizC11Logic.getResult();
                quizC11panel.cleanQuiz();
                quizC11panel.invalidate();
                quizC11panel.removeAll();
                piePanel.setCorrectAnswer(resultEntity.getCorrect());
                piePanel.setWrongAnswer(resultEntity.getWrong());
                piePanel.setNotAnsweredQuestion(resultEntity.getNotAnswered());
                piePanel.setScore(resultEntity.getScore());
                piePanel.drawChart();
                System.out.println(resultEntity.toString());
                swapPanel(quizC11panel, piePanel);
                quizC11panel.cleanQuiz();

            }
        });

        quizC11panel.wrongButton.addActionListener((ActionEvent e) -> {
            quizC11panel.quizC11Logic.answerTheQuestion(quizC11panel.quizCounter, "FALSO");

            if (quizC11panel.quizCounter + 1 < quizC11panel.getNumberOfQuiz()) {
                quizC11panel.questionLabel.setText(quizC11panel.quizC11Logic.getNextQuestion().getQuestion());
                quizC11panel.quizCounter++;
                quizC11panel.questionProgress.setText("Domanda n. " + (quizC11panel.quizCounter + 1));
            } else {
                resultEntity = quizC11panel.quizC11Logic.getResult();
                quizC11panel.cleanQuiz();
                quizC11panel.invalidate();
                quizC11panel.removeAll();

                piePanel.setCorrectAnswer(resultEntity.getCorrect());
                piePanel.setWrongAnswer(resultEntity.getWrong());
                piePanel.setNotAnsweredQuestion(resultEntity.getNotAnswered());
                piePanel.setScore(resultEntity.getScore());
                piePanel.drawChart();
                System.out.println(resultEntity.toString());
                swapPanel(quizC11panel, piePanel);
                quizC11panel.cleanQuiz();

            }
        });

        quizC5panel.trueButton.addActionListener((ActionEvent e) -> {
            quizC5panel.quizC5Logic.answerTheQuestion(quizC5panel.quizCounter, "VERO");

            if (quizC5panel.quizCounter + 1 < quizC5panel.getNumberOfQuiz()) {
                quizC5panel.questionLabel.setText(quizC5panel.quizC5Logic.getNextQuestion().getQuestion());
                quizC5panel.quizCounter++;
                quizC5panel.questionProgress.setText("Domanda n. " + (quizC5panel.quizCounter + 1));
            } else {
                resultEntity = quizC5panel.quizC5Logic.getResult();
                quizC5panel.cleanQuiz();
                quizC5panel.invalidate();
                quizC5panel.removeAll();
                piePanel.setCorrectAnswer(resultEntity.getCorrect());
                piePanel.setWrongAnswer(resultEntity.getWrong());
                piePanel.setNotAnsweredQuestion(resultEntity.getNotAnswered());
                piePanel.setScore(resultEntity.getScore());
                piePanel.drawChart();
                //System.out.println(resultEntity.toString());
                swapPanel(quizC5panel, piePanel);
                quizC5panel.cleanQuiz();
            }
        });

        quizC5panel.wrongButton.addActionListener((ActionEvent e) -> {
            quizC5panel.quizC5Logic.answerTheQuestion(quizC5panel.quizCounter, "FALSO");

            if (quizC5panel.quizCounter + 1 < quizC5panel.getNumberOfQuiz()) {
                quizC5panel.questionLabel.setText(quizC5panel.quizC5Logic.getNextQuestion().getQuestion());
                quizC5panel.quizCounter++;
                quizC5panel.questionProgress.setText("Domanda n. " + (quizC5panel.quizCounter + 1));
            } else {
                resultEntity = quizC5panel.quizC5Logic.getResult();
                quizC5panel.cleanQuiz();
                quizC5panel.invalidate();
                quizC5panel.removeAll();
                piePanel.setCorrectAnswer(resultEntity.getCorrect());
                piePanel.setWrongAnswer(resultEntity.getWrong());
                piePanel.setNotAnsweredQuestion(resultEntity.getNotAnswered());
                piePanel.setScore(resultEntity.getScore());
                piePanel.drawChart();
                //System.out.println(resultEntity.toString());
                swapPanel(quizC5panel, piePanel);
                quizC5panel.cleanQuiz();
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
