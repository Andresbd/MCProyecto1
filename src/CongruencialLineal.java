import java.util.ArrayList;

public class CongruencialLineal {

    public ArrayList CLAleatorio = new ArrayList<>();
    public ArrayList CLRandomRi = new ArrayList<>();

    public void CongLineal(float sem, float mult, float inc, float modul, float iterations) {

        float seed = sem;
        float random;
        float randomMod;
        float ri;

        for(int i = 0; i < iterations; i++) {
            random = (mult * seed) + inc;
            randomMod = random % modul;
            seed = randomMod;
            ri = randomMod / modul;

            CLAleatorio.add(randomMod);
            CLRandomRi.add(ri);
        }
    }
}
