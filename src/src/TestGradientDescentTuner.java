import Utils.CostRecorders.CostRecorder;
import Utils.CostRecorders.ModelFunction;
import Utils.GradientDescentTuner;
import Utils.Math.FunctionType;

public class TestGradientDescentTuner {
    public static void main(String[] args) {
        GradientDescentTuner tuner = new GradientDescentTuner(
                0.01,
                 new ModelFunction(FunctionType.QUADRATIC, 0, FunctionType.NO_FLIP),
                5,
                4
        );
        System.out.println("hi");
//        tuner.calculateNextTunerVar();
    }
}
