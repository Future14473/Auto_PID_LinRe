package Utils;


public class GradientDescentTuner {
    double  nextTunerVar,
            lastCost, lastTunerVar,
            currentCost, currentTunerVar,
            learningRate;
    ModelFunction costRecorder; // TODO make this an interface

    // note costCapturer will be replaced with robot hardware later
    public GradientDescentTuner(double learningRate, ModelFunction costCapturer, double tuner1, double Cost1, double tuner2, double Cost2){
//TODO constructor should probably call update after calculating first vals of geNextCost,
// and then the calculate Next Tuner Var?
    }

    public void calculateNextTunerVar(){
        nextTunerVar = -getDerivCost() * learningRate;
    }

    public void update(){
        lastCost = currentCost;
        lastTunerVar = currentTunerVar;
        currentTunerVar = nextTunerVar;
        currentCost = costRecorder.getLoss(nextTunerVar); //TODO Get next loss
    }

    double getDerivCost(){
        return getDerivative(lastTunerVar, lastCost, currentTunerVar, currentCost);
    }
    double getDerivative(double x1, double y1, double x2, double y2){
        return (y1-y2)/ (x1-x2);
    }
}
