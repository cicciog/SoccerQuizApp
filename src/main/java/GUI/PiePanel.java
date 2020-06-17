package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author francesco
 */
public class PiePanel extends JPanel {

    private int score;
    private int correctAnswer;
    private int wrongAnswer;
    private int notAnsweredQuestion;
    private JPanel chartPanel;
    private JPanel resultPanel;
    private JPanel buttonsPanel;
    private JLabel scoreLabel;
    private JLabel answerSummaryLabel;
    private JButton retryBtn;
    private JButton closeBtn;


    public PiePanel() {
        this.score = 20;
        this.correctAnswer = 10;
        this.wrongAnswer = 5;
        this.notAnsweredQuestion = 3;

        //set background color white
        this.setBackground(Color.WHITE);

        //create chart panel
        this.chartPanel = createPieDiagram(this.getSize(),correctAnswer,wrongAnswer,notAnsweredQuestion);

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

        this.retryBtn = new JButton("riprova");
        this.closeBtn = new JButton("chiudi");

        btnsPanel = new JPanel();
        btnsPanel.setSize(pDimension.width, pDimension.height / 6);

        this.retryBtn.setLocation(pDimension.width / 8 * 2, pDimension.height / 6 * 5);
        this.closeBtn.setLocation(pDimension.width / 8 * 4, pDimension.height / 6 * 5);
        this.retryBtn.setSize(pDimension.width / 8 * 2 - 5, pDimension.height / 12);
        this.closeBtn.setSize(pDimension.width / 8 * 2 - 5, pDimension.height / 12);

        this.retryBtn.addActionListener((ActionEvent ae) -> {
            System.out.println("Riprova!");
        });
        
         this.closeBtn.addActionListener((ActionEvent ae) -> {
             System.exit(0);
        });

        btnsPanel.add(this.retryBtn);
        btnsPanel.add(this.closeBtn);

        return btnsPanel;
    }

}