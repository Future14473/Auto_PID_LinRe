package Graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
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
        String chartTitle = "Programming Languages Trends";
        String categoryAxisLabel = "Interest over time";
        String valueAxisLabel = "Popularity";

        dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        return new ChartPanel(chart);
    }

    public DefaultCategoryDataset createDataset() {
        dataset = new DefaultCategoryDataset();
        String xAxis = "Tuning Variable";
//        dataset.addValue(5.0, xAxis, String.valueOf(1));
//        dataset.addValue(9.0, xAxis, String.valueOf(2));
//        dataset.addValue(3.0, xAxis, String.valueOf(3));
//        dataset.addValue(12.0, xAxis, String.valueOf(4));
//        dataset.addValue( 15 , "schools" , "1970" );
//        dataset.addValue( 30 , "schools" , "1980" );
//        dataset.addValue( 60 , "schools" ,  "1990" );
//        dataset.addValue( 120 , "schools" , "2000" );
//        dataset.addValue( 240 , "schools" , "2010" );
//        dataset.addValue( 300 , "schools" , "2014" );
        return dataset;
    }


    public void addDataToChart(double y, double x){
        dataset.addValue(y, "Tuning Variable", String.valueOf(x));
    }
}