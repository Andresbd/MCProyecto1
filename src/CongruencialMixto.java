import java.util.ArrayList;

class CongruencialMixto {
    public ArrayList GenMix(int X0, int a, int c, int m, int n){
        float[] aux = new float[n];
        ArrayList list = new ArrayList();

        float result = X0;
        for (int i = 0; i < n; i++){
            aux[i] = GenMix(result, a, c, m);
            result = aux[i];

            list.add(aux[i]);
        }

        return list;
    }

    public float GenMix(float X0, int a, int c, int m){
        //if we meet the conditions we do the whole process, else we return -1
        if(checkConditions(a, c, m)){
            float result = ((a * X0) + c) % m;
            return result/m;
        }
        return -1.0f;
    }

    //if conditions are true, it returns true
    private boolean checkConditions(int a, int c, int m){

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
        ArrayList primes = primeFactors(m);
        ArrayList aux = new ArrayList();

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

    private ArrayList primeFactors(int n){
        int i = 2;
        ArrayList factors = new ArrayList();

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
