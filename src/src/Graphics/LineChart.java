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
public class LineChart extends JFrame {
    DefaultCategoryDataset dataset;
    String xAxis = "Example Tuning Variable";
    public LineChart() {
        super("Line Chart Example with JFreechart");

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createChartPanel() {
        String chartTitle = "Desired Tuning Value Derived from Gradient Descent";
        String categoryAxisLabel = "Tuning Variable";
        String valueAxisLabel = "Loss";

        dataset = new DefaultCategoryDataset();

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);
        return new ChartPanel(chart);
    }

    public void addDataToChart(double x, double y){
        dataset.addValue(y, "Tuning Variable", String.format("% .2f", x));
    }
}