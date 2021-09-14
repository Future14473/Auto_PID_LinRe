import Graphics.ActualGraph;
import Graphics.LineChart;
import Utils.FunctionType;
import Utils.GradientDescent;
import Utils.ModelFunction;
import Utils.StandardDev;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        // Graphics
        LineChart myChart = new LineChart();
        ActualGraph actualGraph = new ActualGraph();
        Scanner scanner = new Scanner(System.in);

        // rand initialized values
        double learningRate = 0.02;
        GradientDescent testGrad = new GradientDescent(learningRate);

        // Test Function
        ModelFunction modelFunction = new ModelFunction(FunctionType.QUADRATIC, 1, FunctionType.NO_FLIP);

        // first 2 kV and Cost then you can loop
        double lastTunerVar = 5, lastLoss = modelFunction.getLoss(lastTunerVar);

        //current tuner var is just our manually inputted next guess
        double currentTunerVar = 4, currentLoss = modelFunction.getLoss(currentTunerVar);

        for (int i = -10; i < 11; i++) {
            actualGraph.addDataToChart(i, modelFunction.getFunctionVal(i));
        }

        int i = 0;
        while(! scanner.nextLine().equals(" ") && (i < 32)){
            double nextTunerVar = testGrad.getNextTunerVar(currentLoss, lastLoss,currentTunerVar, lastTunerVar);
A
            System.out.println("Current Iteration: " + (i++));
            System.out.println("Current Loss: " + currentLoss);
            System.out.println("Current Tuner Var: " + nextTunerVar);

            lastTunerVar = currentTunerVar;
            currentTunerVar = nextTunerVar;
            lastLoss = currentLoss;
            currentLoss = modelFunction.getLoss(currentTunerVar);
            myChart.addDataToChart(currentTunerVar, currentLoss);
        }
        System.out.println("Current Iteration " + i + " | Final TunerVar " + currentTunerVar + " | Final Loss: " + currentLoss);
    }
}
