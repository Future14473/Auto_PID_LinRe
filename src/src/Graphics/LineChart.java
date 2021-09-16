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
    String xAxisLabel, yAxisLabel,  chartTitle, tuningVarName;
    public LineChart(String windowTitle, String chartTitle, String tuningVarName, String xAxisTitle, String yAxisLabel) {
        super(windowTitle);
        this.xAxisLabel = xAxisTitle;
        this.chartTitle = chartTitle;
        this.yAxisLabel = yAxisLabel;
        this.tuningVarName = tuningVarName;

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel createChartPanel() {
        dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart(chartTitle, tuningVarName, yAxisLabel, dataset);
        return new ChartPanel(chart);
    }

    public void addDataToChart(double x, double y, int decimalPoints){
        dataset.addValue(y, "Tuning Variable", String.format("% ." + decimalPoints +"f", x));
    }
}