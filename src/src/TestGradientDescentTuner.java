import Utils.CostRecorders.ModelFunction;
import Utils.GradientDescentTuner;
import Utils.Math.FunctionType;

public class TestGradientDescentTuner {
    public static void main(String[] args) {
        GradientDescentTuner tuner = new GradientDescentTuner(
                0.01,
                 new ModelFunction(FunctionType.QUADRATIC, 1, FunctionType.NO_FLIP),
                -5,
                -4
        );
        for (int i = 0; i < 100; i++) {
            tuner.calculateNextTunerVar();
            tuner.printDebug();
            tuner.update();
        }




//        tuner.printVals();
    }
}
