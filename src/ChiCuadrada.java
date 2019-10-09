import java.util.*;
import java.util.Collections;

public class ChiCuadrada {

    int n;
    float min, max, lambda, k, sum, median, interval;

    public void ChiTest(ArrayList<Float> values) {
        n = values.size();

        max = Collections.max(values);
        min = Collections.min(values);

        for(int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }

        median = sum / n;
        lambda = 1/median;
        interval = (max-min)/k;
    }
}
