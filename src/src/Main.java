import Graphics.LineChart;
import Utils.CostRecorders.CostRecorder;
import Utils.Math.FunctionType;
import Utils.GradientDescentTuner;
import Utils.CostRecorders.ModelFunction;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        // Graphics
        LineChart tuningGraph = new LineChart(
                "Tuning Graph using Gradient Descent",
                "kP Tuning using Gradient Descent with Qudratic Model Function",
                "kP (proportional constant)",
                "Tuning Variables",
                "Cost (Robot Distance from Destination)"
        );

        LineChart theoreticalFunction = new LineChart(
                "Theoretical Graph of Cost Function",
                "Theoretical Graph of Cost Function (Quadratic)",
                "kP (proportional constant)",
                "Tuning Variables",
                "Cost (Robot Distance from Destination)"
        );

        Scanner scanner = new Scanner(System.in);

        // Loss Recorder is a function for modeling purposes in Java only code
        CostRecorder modelFunction = new ModelFunction(FunctionType.QUADRATIC, 1, FunctionType.NO_FLIP);
        GradientDescentTuner kP_Tuner = new GradientDescentTuner(0.02, modelFunction, 5, 4);
        theoreticalFunction.plotTheoreticalFunction(modelFunction);

        tuningGraph.addData(kP_Tuner.getLastTunerVar(), kP_Tuner.getLastCost(), 2);
        tuningGraph.addData(kP_Tuner.getCurrentTunerVar(), kP_Tuner.getCurrentCost(), 2);
        int i = 2; // already 2 test done when initializing GradientDescentTuner
        while(! scanner.nextLine().equals(" ") && (i < 34)){
            kP_Tuner.printVals();
            System.out.println("Current Iteration: " + (i++));

            kP_Tuner.calculateNextTunerVar();
            kP_Tuner.update();

            tuningGraph.addData(kP_Tuner.getCurrentTunerVar(), kP_Tuner.getCurrentCost(), 2);
        }

        scanner.close();
        System.out.println("Current Iteration " + i + " | Final TunerVar " + kP_Tuner.getCurrentTunerVar() + " | Final Loss: " + kP_Tuner.getCurrentCost());
    }
}
