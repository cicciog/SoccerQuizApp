package GUI;

import java.awt.Color;
import java.awt.Dimension;
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
public class Pie extends JPanel {

    private int correctAnswer;
    private int wrongAnswer;
    private JPanel chartPanel;
    private JPanel result;
    private JLabel score;
    private JLabel answerSummary;

    public Pie(Dimension pDimension) {
        super();
        
        setBackground(Color.WHITE);
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Corrette", 10);
        dataset.setValue("Errate", 5);
        dataset.setValue("Non date", 0);

        JFreeChart chart = ChartFactory.createPieChart3D("Quiz terminato!", dataset, true, true, true);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setForegroundAlpha(0.6f);
        plot.setCircular(true);

        chartPanel = new ChartPanel(chart, pDimension.width / 8 * 5, pDimension.height / 6 * 4, 100, 50, 400, 300, true, true, true, true, true, true);

        score = new JLabel("Punteggio: " + 20);
        answerSummary = new JLabel("RISPOSTE: corrette 10  errate 5  non date  0");

        result = new JPanel();
        result.setSize(pDimension.width, pDimension.height / 6 * 2);
        result.setBackground(Color.WHITE);
        result.add(score);
        result.add(answerSummary);

        add(chartPanel);
        add(result);
    }

}
