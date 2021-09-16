package Utils.CostRecorders;

public interface CostRecorder {

    /*Runs the Robot hardware to collect loss data for given tunerVar*/
    double getCost(double tunerVar);
}
