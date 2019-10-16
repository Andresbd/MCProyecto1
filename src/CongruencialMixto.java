/*
To use this class you can create an arrayList of the generated randoms called GenMix() and the
HullDobell checker to see if it passes the tests
 */

import java.util.ArrayList;

class CongruencialMixto {
    public ArrayList<Double> GenMix(int seed, int a, int c, int m, int n){
        double[] aux = new double[n];
        ArrayList<Double> list = new ArrayList<>();

        double result = seed;
        for (int i = 0; i < n; i++){
            aux[i] = GenMix(result, a, c, m);
            result = aux[i];

            list.add(aux[i]);
        }

        return list;
    }

    private double GenMix(double X0, int a, int c, int m){
        double result = ((a * X0) + c) % m;
        return result/m;
    }

    //if conditions are true, it returns true
    private boolean HullDobell(int a, int c, int m){

        if (first(c, m) && second(m, a) && third(m, a)){
            return true;
        }
        return false;
    }

    private boolean first(int c, int m){
        if(mcd(c, m) == 1){
            return true;
        }
        return false;
    }

    //checar este
    private boolean second(int m, int a){
        ArrayList<Integer> primes = primeFactors(m);
        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i< primes.size(); i++){
            aux.add((a-1)%(int)primes.get(i));
            if((int)aux.get(i) == 0){
                return true;
            }
        }

        return false;
    }

    private boolean third(int m, int a){
        if(m%4 == 0 && (a-1)%4 == 0){
            return true;
        }
        return false;
    }

    private int mcm(int num1, int num2){
        int mcm = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        mcm = (a/mcd(a,b))*b;
        return mcm;
    }

    private int mcd(int num1, int num2){
        int mcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        do {
            mcd = b;
            b = a%b;
            a = mcd;
        } while(b!=0);
        return mcd;
    }

    private ArrayList<Integer> primeFactors(int n){
        int i = 2;
        ArrayList<Integer> factors = new ArrayList<>();

        while(i*i <= n){
            if(n%i == 1){
                i ++;
            }
            else {
                n/=i;
                factors.add(i);
            }
        }
        if (n>1){
            factors.add(n);
        }
        return factors;
    }
}
