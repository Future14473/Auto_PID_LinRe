package Graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how to draw line chart with CategoryDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class ActualGraph extends JFrame {
    DefaultCategoryDataset dataset;
    String xAxis = "Example Tuning Variable";
    public ActualGraph() {
        super("Line Chart Example with JFreechart");

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createChartPanel() {
        String chartTitle = "Actual Loss Function";
        String categoryAxisLabel = "X";
        String valueAxisLabel = "Y";

        dataset = new DefaultCategoryDataset();

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);
        return new ChartPanel(chart);
    }

    public void addDataToChart(double x, double y){
        dataset.addValue(y, "X", String.format("% .0f", x));
    }
}