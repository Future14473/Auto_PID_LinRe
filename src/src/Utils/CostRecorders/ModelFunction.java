package Utils.CostRecorders;

public class ModelFunction implements CostRecorder {
    int functionType;
    double xOffset;
    int flip;

    public ModelFunction(int functionType, double xOffset, int flip){
        this.functionType = functionType;
        this.xOffset = xOffset;
        this.flip = flip;
    }

    @Override
    public double getCost(double x){
        return Math.abs(
                Math.pow(x-xOffset, functionType) // just a parent function with translations
        );
    }

    public double getFunctionVal(double x){
        return Math.pow(x-xOffset, functionType) * flip;
    }
}
