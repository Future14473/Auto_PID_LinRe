import Utils.GradientDescent;
import Utils.StandardDev;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
//        double[] ourLoss = {1,2,2,3,4};
//        System.out.println(StandardDev.getStandardDev(ourLoss));

        // rand initialized values
        double learningRate = 0.02;
        GradientDescent testGrad = new GradientDescent(learningRate);

        // first 2 kV and Cost then you can loop
        double lastTunerVar = -5, lastLoss = testFunc(lastTunerVar);

        //current tuner var is just our manually inputted next guess
        double currentTunerVar = -4, currentLoss = testFunc(currentTunerVar);

        int epochs = 30;
        for (int i = 0; i < epochs; i++) {
            double nextTunerVar = testGrad.getNextTunerVar(currentLoss, lastLoss,currentTunerVar, lastTunerVar);

            System.out.println("Current Iteration: " + (i + 1));
            System.out.println("Current Loss: " + currentLoss);
            System.out.println("Current Tuner Var: " + nextTunerVar);

            lastTunerVar = currentTunerVar;
            currentTunerVar = nextTunerVar;
            lastLoss = currentLoss;
            currentLoss = testFunc(currentTunerVar);
        }
    }
    // quadratic fn
    static double testFunc(double n){
//        return Math.pow(n, 10);
        return Math.pow(n, 3) + Math.pow(n, 2) + 7;
    }
}
