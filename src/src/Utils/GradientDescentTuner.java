package Utils;


import Utils.CostRecorders.CostRecorder;

public class GradientDescentTuner {
    double  nextTunerVar,
            lastCost, lastTunerVar,
            currentCost, currentTunerVar,
            learningRate;
    CostRecorder costRecorder;

    // note costCapturer will be replaced with robot hardware later
    public GradientDescentTuner(double learningRate, CostRecorder costRecorder, double tuner1, double tuner2){
        this.learningRate = learningRate;
        this.costRecorder = costRecorder;
        this.lastTunerVar = tuner1;
        this.currentTunerVar = tuner2;
        this.lastCost = costRecorder.getCost(lastTunerVar);
        this.currentCost = costRecorder.getCost(currentTunerVar);
    }

    public void calculateNextTunerVar(){
        nextTunerVar = -getDerivCost() * learningRate;
    }

    public void update(){
        lastCost = currentCost;
        lastTunerVar = currentTunerVar;
        currentTunerVar = nextTunerVar;
        currentCost = costRecorder.getCost(nextTunerVar); //TODO Get next loss
    }

    public void printVals(){
        System.out.println("Current Loss: " + currentCost);
        System.out.println("Current Tuner Var: " + currentTunerVar);
    }

    public void printDebug(){
        System.out.println("Last Tuner Var: " + lastTunerVar);
        System.out.println("Last Loss: " + lastCost);
        System.out.println("Current Tuner Var: " + currentTunerVar);
        System.out.println("Current Loss: " + currentCost);
        System.out.println("Derivative of Cost: " + getDerivCost());
        System.out.println("Next Tuner Var: " + nextTunerVar);
        System.out.println();
    }

    double getDerivCost(){
        return getDerivative(lastTunerVar, lastCost, currentTunerVar, currentCost);
    }
    double getDerivative(double x1, double y1, double x2, double y2){
        return (y1-y2) / (x1-x2);
    }

    public double getCurrentTunerVar() {
        return currentTunerVar;
    }
    public double getCurrentCost() {
        return currentCost;
    }
}
