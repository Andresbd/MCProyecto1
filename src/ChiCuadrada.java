import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;

import java.util.*;

public class ChiCuadrada {

    int n;
    double min, max, lambda, k, sum, median, interval, acumulated;
    double FA[];
    double FR[];
    double FE[];
    double PD[];

    ArrayList<Double> intervales = new ArrayList<Double>();

    public void ChiTest(ArrayList<Float> values) {

        acumulated = 0;

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

        FE = new double[FA.length];
        PD = new double[FA.length];
        Integration(intervales);

        Product();
    }

    void GenerateIntervals() {
        double base = interval;

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

    void Integration(ArrayList<Double> values) {
        UnivariateIntegrator integrator = new SimpsonIntegrator();

        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return lambda * Math.exp(-lambda*x);
            }
        };

        double start = 0;
        double end = values.get(0);

        for(int i = 0; i < values.size(); i++) {
            FE[i] = integrator.integrate(100,f, start, end);
            start = values.get(i);
            if(i < 4) {
                end = values.get(i+1);
            }
        }
    }

    void Product() {
        double power;
        double subs;
        for (int j = 0; j < FA.length; j++) {
            subs = (FR[j]-FE[j]);
            power = Math.pow(subs,2);
            PD[j] = power / FE[j];
            acumulated += PD[j];
        }
    }
}
