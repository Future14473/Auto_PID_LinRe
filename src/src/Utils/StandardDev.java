package Utils;

public class StandardDev {
    public static double getStandardDev(double[] loss){
        double sum = 0;

        for (double val : loss){
            sum += Math.pow( val - 0 , 2.0);
        }
        return Math.sqrt(sum/(loss.length-1));
    }

    static double getAverageArray(double[] arr){
        double sum = 0;
        for (double val : arr){
            sum += val;
        }

        return sum/arr.length;
    }
}
