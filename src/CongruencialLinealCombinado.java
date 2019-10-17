import java.util.ArrayList;

public class CongruencialLinealCombinado {
    public ArrayList<Float> semilla1 = new ArrayList<>();
    public ArrayList<Float> semilla2 = new ArrayList<>();
    public ArrayList<Float> randomNumber1 = new ArrayList<>();
    public ArrayList<Float> randomNumber2 = new ArrayList<>();
    public ArrayList<Float> generatedRandoms = new ArrayList<>();

    public void GenLinealComb(int X10, int X20, int a1, int a2, int m1, int m2, int m3, int n){

        float result1 = X10;
        float result2 = X20;

        for (int i = 0; i<n; i++){
            semilla1.add(result1);
            semilla2.add(result2);

            float res1 = (result1 * a1) % m1;
            float res2 = (result2 * a2) % m2;

            result1 = res1;
            result2 = res2;

            randomNumber1.add(res1);
            randomNumber2.add(res2);

            float sum = (res1 + res2) % m3;

            generatedRandoms.add(sum);
        }
    }
}
