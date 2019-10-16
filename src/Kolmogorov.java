import java.util.ArrayList;

public class Kolmogorov {

    public double KolmogorovSmirnoffTest(ArrayList<Double> values){
        int n = values.size();

        ArrayList<Double> iOverN = calculateIOverN(n); // i/n

        ArrayList<Double> iOverNMinusR = calculateIOverNMinusR(iOverN, values);// i/n - R(i)

        ArrayList<Double> iMinus1OverNMinusR = calculateIMinus1OverNMinusR(iOverN, values); // (i-1)/n - R(i)

        double Dplus = maxVal(iOverNMinusR);
        double Dminus = maxVal(iMinus1OverNMinusR);

        return Math.max(Dplus, Dminus);
    }

    private ArrayList<Double> calculateIOverN(int n){
        ArrayList<Double> array = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            double iOverN = (double)i / n;
            array.add(iOverN);
        }
        return array;
    }

    private ArrayList<Double> calculateIOverNMinusR(ArrayList<Double> iOverN, ArrayList<Double> R){
        ArrayList<Double> iOverNMinusR = new ArrayList<>();
        for (int i = 0; i < R.size(); i++){
            double subs = iOverN.get(i) - R.get(i);
            iOverNMinusR.add(Math.abs(subs));
        }
        return iOverNMinusR;
    }

    private ArrayList<Double> calculateIMinus1OverNMinusR(ArrayList<Double> iOverN, ArrayList<Double> R){
        ArrayList<Double> IMinus1OverNMinusR = new ArrayList<>();
        IMinus1OverNMinusR.add(0-R.get(0));
        for (int i = 1; i < R.size(); i++){
            double subs = iOverN.get(i-1) - R.get(i);
            IMinus1OverNMinusR.add(Math.abs(subs));
        }
        return IMinus1OverNMinusR;
    }

    private double maxVal(ArrayList<Double> list){
        double max = 0;
        for (Double aDouble : list) {
            if (aDouble > max) {
                max = aDouble;
            }
        }
        return max;
    }

    /*
    double KolmogorovSmirnovTable(){
        KolmogorovSmirnovTest kolmogorovSmirnovTest = new KolmogorovSmirnovTest();
    }
    */
}
