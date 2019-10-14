import java.util.*;

public class ChiCuadrada {

    int n;
    double min, max, lambda, k, sum, median, interval;
    double FA[];
    double FR[];
    ArrayList<Double> intervales = new ArrayList<Double>();

    public void ChiTest(ArrayList<Float> values) {

        n = values.size();
        k = 1 + 3.222 * Math.log10(n);

        max = Collections.max(values);
        min = Collections.min(values);

        for(int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }

        median = sum / n;
        lambda = 1/median;
        interval = (max-min)/k;

        GenerateIntervals();

        AbsoluteRelative(values, intervales);
        
    }

    void GenerateIntervals() {
        double base = interval;

        intervales.add(interval);
        while (interval < 1) {
            intervales.add(interval);
            interval += base;
        }

        interval += base;
        intervales.add(interval);
    }

    void AbsoluteRelative(ArrayList<Float> data, ArrayList<Double> seccions) {
        FA = new double[seccions.size()];

        for (int x = 0; x < seccions.size(); x++) {
            int cont = 0;
            for(int y = 0; y < data.size(); y++) {
                if(data.get(y) < seccions.get(x)) {
                    data.remove(y);
                    cont++;
                }
            }
            FA[x] = cont;
        }

        FR = new double[seccions.size()];

        for(int z = 0; z < seccions.size(); z++){
            FR[z] = FA[z] / n;
        }
    }
}
