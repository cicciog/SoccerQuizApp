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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author cicciog
 */
public class PiePanel extends JPanel {

    private int score = 0;
    private int correctAnswer = 0;
    private int wrongAnswer = 0;
    private int notAnsweredQuestion = 0;
    private JPanel chartPanel;
    private JPanel resultPanel;
    private JPanel buttonsPanel;
    private JLabel scoreLabel;
    private JLabel answerSummaryLabel;
    public JButton retryBtn = new JButton("riprova");
    private JButton closeBtn = new JButton("chiudi");

    public PiePanel() {
        //set background color white
        this.setBackground(Color.WHITE);
    }

    public void drawChart() {
        //create chart panel
        this.chartPanel = createPieDiagram(this.getSize(), correctAnswer, wrongAnswer, notAnsweredQuestion);

        //create result panel
        this.resultPanel = createResultPanel(this.getSize(), score, correctAnswer, wrongAnswer, notAnsweredQuestion);

        this.buttonsPanel = createButtonsPanel(this.getSize());

        //add panel to frame
        add(chartPanel);
        add(resultPanel);
        add(buttonsPanel);
    }

    private JPanel createPieDiagram(Dimension pDimension, int pCorrect, int pWrong, int pNotAnswered) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Corrette", pCorrect);
        dataset.setValue("Errate", pWrong);
        dataset.setValue("Non date", pNotAnswered);

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Quiz terminato!",
                dataset,
                true,
                true,
                true);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setForegroundAlpha(0.6f);
        plot.setCircular(true);

        return new ChartPanel(chart,
                380,
                270,
                100, 50, 400, 300,
                true, true, true, true, true, true);
    }

    private JPanel createResultPanel(Dimension pDimension, int pScore, int pCorrect, int pWrong, int pNotAnswered) {
        JPanel result;

        this.scoreLabel = new JLabel("Punteggio: " + pScore);
        this.answerSummaryLabel = new JLabel("RISPOSTE: corrette " + pCorrect + "  errate " + pWrong + "  non date  " + pNotAnswered);

        result = new JPanel();
        result.setSize(pDimension.width, pDimension.height / 6);
        result.setBackground(Color.WHITE);
        result.add(this.scoreLabel);
        result.add(this.answerSummaryLabel);

        return result;
    }

    private JPanel createButtonsPanel(Dimension pDimension) {
        JPanel btnsPanel;

        btnsPanel = new JPanel();
        btnsPanel.setSize(pDimension.width, pDimension.height / 6);

        this.retryBtn.setLocation(pDimension.width / 8 * 2, pDimension.height / 6 * 5);
        this.closeBtn.setLocation(pDimension.width / 8 * 4, pDimension.height / 6 * 5);
        this.retryBtn.setSize(pDimension.width / 8 * 2 - 5, pDimension.height / 12);
        this.closeBtn.setSize(pDimension.width / 8 * 2 - 5, pDimension.height / 12);

        //this.retryBtn.addActionListener((ActionEvent ae) -> {
        //    System.out.println("Riprova!");
        //});
        this.closeBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        btnsPanel.add(this.retryBtn);
        btnsPanel.add(this.closeBtn);

        return btnsPanel;
    }

    public void setScore(int pScore) {
        this.score = pScore;
    }

    public void setCorrectAnswer(int pCorrectAnswer) {
        this.correctAnswer = pCorrectAnswer;
    }

    public void setWrongAnswer(int pWrongAnswer) {
        this.wrongAnswer = pWrongAnswer;
    }

    public void setNotAnsweredQuestion(int pNotAnsweredQuestion) {
        this.notAnsweredQuestion = pNotAnsweredQuestion;
    }

}
