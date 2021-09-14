package Utils;


import java.util.ArrayList;

public class GradientDescent {
    double  nextTunerVar,
            lastCost, lastTunerVar,
            currentCost, currentTunerVar,
            learningRate;

    // note costCapturer will be replaced with robot hardware later
    public GradientDescent(double learningRate, ModelFunction costCapturer, double tuner1, double Cost1, double tuner2, double Cost2){

    }

    public void calculateNextTunerVar(){
        nextTunerVar = -getDerivCost() * learningRate;
    }

    double getDerivCost(){
        return getDerivative(lastTunerVar, lastCost, currentTunerVar, currentCost);
    }
    double getDerivative(double x1, double y1, double x2, double y2){
        return (y1-y2)/ (x1-x2);
    }
}
