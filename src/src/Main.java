import Graphics.ActualGraph;
import Graphics.LineChart;
import Utils.FunctionType;
import Utils.GradientDescentTuner;
import Utils.ModelFunction;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        // Graphics
        LineChart myChart = new LineChart();
        ActualGraph actualGraph = new ActualGraph();
        Scanner scanner = new Scanner(System.in);

        // Loss Recorder is a function for modeling purposes in Java only code
        ModelFunction modelFunction = new ModelFunction(FunctionType.QUADRATIC, 1, FunctionType.NO_FLIP);

        GradientDescentTuner kV_Tuner = new GradientDescentTuner(0.02, modelFunction, 5, 4); //TODO have the gradient descent run get loss from these values tumer 1, 2
        for (int i = -10; i < 11; i++) {
            actualGraph.addDataToChart(i, modelFunction.getFunctionVal(i));
        }

        int i = 2; // already 2 test done when initializing GradientDescentTuner
        while(! scanner.nextLine().equals(" ") && (i < 34)){
            kV_Tuner.printVals();
            System.out.println("Current Iteration: " + (i++));

            kV_Tuner.calculateNextTunerVar();
            kV_Tuner.update();

            myChart.addDataToChart(kV_Tuner.getCurrentTunerVar(), kV_Tuner.getCurrentCost());
        }

        scanner.close();
        System.out.println("Current Iteration " + i + " | Final TunerVar " + kV_Tuner.getCurrentTunerVar() + " | Final Loss: " + kV_Tuner.getCurrentCost());
    }
}
