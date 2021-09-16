package Utils;


public class GradientDescentTuner {
    double  nextTunerVar,
            lastCost, lastTunerVar,
            currentCost, currentTunerVar,
            learningRate;
    ModelFunction costRecorder; // TODO make this an interface

    // note costCapturer will be replaced with robot hardware later
    public GradientDescentTuner(double learningRate, ModelFunction costRecorder, double tuner1, double tuner2){
        this.learningRate = learningRate;
        this.costRecorder = costRecorder;
        this.lastTunerVar = tuner1;
        this.currentTunerVar = tuner2;
        this.lastCost = costRecorder.getLoss(lastTunerVar);
        this.currentCost = costRecorder.getLoss(currentTunerVar);
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

    public void printVals(){

        System.out.println("Current Loss: " + currentCost);
        System.out.println("Current Tuner Var: " + nextTunerVar);
    }

    double getDerivCost(){
        return getDerivative(lastTunerVar, lastCost, currentTunerVar, currentCost);
    }
    double getDerivative(double x1, double y1, double x2, double y2){
        return (y1-y2)/ (x1-x2);
    }

    public double getCurrentTunerVar() {
        return currentTunerVar;
    }
    public double getCurrentCost() {
        return currentCost;
    }
}
