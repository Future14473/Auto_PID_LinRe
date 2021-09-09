package Utils;


import java.util.ArrayList;

public class GradientDescent {
    double learningRate, currentTunerVar, lastCostVal, currentCostVal, lastTunerVar;
    /*
     * Gradient descent is the process of optimizing the next guess for kP
     * Iterative optimizing algorithm for finding a local minimum of a differential function
     */

    // 1) get Loss data from robot (AS)
    // 2) Get Cost = std Loss
    //          guess and error(in coding train video) is actually our Cost function because it tells us how off we are
    // 3) Update tuning constant kTunerVar += Cost(kTunerVar Current) * learning rate

    public GradientDescent(double startLearningRate , double startTunerVar){
        learningRate = startLearningRate;
        currentTunerVar = startTunerVar;
        // run
        // calc cost
        // set last tuner var to current tuner var; set current tuner var to arbitrary number
    }

    /**
     * Uses Gradient descent to get next tuner variable
     */

    /*possibly add Gradient Descent with momentum in the future*/
    public double getNextTunerVar(double currentCostVal, double lastCostVal, double currentTunerVar, double lastTunerVar){
//    public void getNextTunerVar(ArrayList<Double> loss){


        double dCost = (currentCostVal - lastCostVal) / (currentTunerVar - lastTunerVar); // derivative of cost fn at current point in time
        currentTunerVar -= dCost * learningRate; //negative because opposite direction of derivative (going downhill(-) increase tunerVar(+))

        return currentTunerVar;
    }

//    private ArrayList<Double> converToDoubleArray(ArrayList<Pose2d> list){
//        ArrayList<Double> dblList = new ArrayList<>();
//        for (Pose2d pos:
//             list) {
//            dblList.add(pos.getHe)
//        }
//    }

    public double getCost(ArrayList<Double> loss){
        return StandardDev.getStandardDev(loss);
    }

    public void setCurrentCostVal(double currentCostVal) {
        this.currentCostVal = currentCostVal;
    }


    public void setLastCostVal(double lastCostVal) {
        this.lastCostVal = lastCostVal;
    }

    public void setCurrentTunerVar(double currentTunerVar) {
        this.currentTunerVar = currentTunerVar;
    }

    public void setLastTunerVar(double lastTunerVar) {
        this.lastTunerVar = lastTunerVar;
    }


    public double getCurrentTunerVar() {
        return currentTunerVar;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getLearningRate() {
        return learningRate;
    }
}
