package Utils;

public class ModelFunction {
    static double getVal(double x, double functionType, double xOffset){
        return Math.abs(
                Math.pow(x, functionType) + xOffset
        );
    }

}
