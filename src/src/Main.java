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



        // Loss Capturer is a function for modeling purposes
        ModelFunction modelFunction = new ModelFunction(FunctionType.QUADRATIC, 1, FunctionType.NO_FLIP);


        // first 2 kV and Cost then you can loop
        double lastTunerVar = 5, lastLoss = modelFunction.getLoss(lastTunerVar);

        //current tuner var is just our manually inputted next guess
        double currentTunerVar = 4, currentLoss = modelFunction.getLoss(currentTunerVar);

        GradientDescentTuner kV_Tuner = new GradientDescentTuner(0.02, modelFunction, 5, 4); //TODO have the gradient descent run get loss from these values tumer 1, 2
        for (int i = -10; i < 11; i++) {
            actualGraph.addDataToChart(i, modelFunction.getFunctionVal(i));
        }

        int i = 0;
        while(! scanner.nextLine().equals(" ") && (i < 32)){
            double nextTunerVar = kV_Tuner.getNextTunerVar(currentLoss, lastLoss,currentTunerVar, lastTunerVar);

            System.out.println("Current Iteration: " + (i++));
            System.out.println("Current Loss: " + currentLoss);
            System.out.println("Current Tuner Var: " + nextTunerVar);

            myChart.addDataToChart(currentTunerVar, currentLoss);
        }
        System.out.println("Current Iteration " + i + " | Final TunerVar " + currentTunerVar + " | Final Loss: " + currentLoss);
    }
}
