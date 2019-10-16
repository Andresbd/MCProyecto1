import java.util.*;

public class CongruencialLineal {

    public ArrayList CLAleatorio = new ArrayList<>();
    public ArrayList<Float> CLRandomRi = new ArrayList<Float>();
    public ArrayList<Float> CLSeed = new ArrayList<Float>();

    public void CongLineal(float sem, float mult, float inc, float modul, float iterations) {

        float seed = sem;
        float random;
        float randomMod;
        float ri;

        for(int i = 0; i < iterations; i++) {
            CLSeed.add(seed);
            random = (mult * seed) + inc;
            randomMod = random % modul;
            seed = randomMod;
            ri = randomMod / modul;

            CLAleatorio.add(randomMod);
            CLRandomRi.add(ri);
        }
    }
}
