package GUI;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author francesco
 */
public class Pie extends JPanel {

    private int correctAnswer;
    private int wrongAnswer;

    public Pie(Dimension pDimension) {
        super();
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Corrette", 10);
        dataset.setValue("Errate", 5);
        dataset.setValue("Non date", 0);

        JFreeChart chart = ChartFactory.createPieChart3D("Quiz terminato!", dataset, false, false, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setForegroundAlpha(0.6f);
        plot.setCircular(true);
        JPanel chartPanel = new ChartPanel(chart,400,300, 100,50, 400,300, true, true, true, true, true, true);
        add(chartPanel);
    }

}
