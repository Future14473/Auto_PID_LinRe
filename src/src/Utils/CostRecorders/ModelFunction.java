package Utils.CostRecorders;

public class ModelFunction implements CostRecorder {
    int functionType;
    double yOffset;
    int flip;

    public ModelFunction(int functionType, double yOffset, int flip){
        this.functionType = functionType;
        this.yOffset = yOffset;
        this.flip = flip;
    }

    @Override
    public double getCost(double x){
        return Math.abs(
                Math.pow(x, functionType) + yOffset // just a parent function with translations
        );
    }

    public double getFunctionVal(double x){
        return (Math.pow(x, functionType) + yOffset) * flip;
    }
}
