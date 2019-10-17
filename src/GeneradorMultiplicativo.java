import java.util.*;

public class GeneradorMultiplicativo{

    public ArrayList<Float> GenMulSeed = new ArrayList<Float>();
    public ArrayList<Float> GenMulValueA = new ArrayList<Float>();
    public ArrayList<Float> GenMulMod = new ArrayList<Float>();
    public ArrayList<Float> GenMulItera = new ArrayList<Float>();
    public ArrayList<Float> GenMulValueX = new ArrayList<Float>();
    public ArrayList<Float> GenMulValueR = new ArrayList<Float>();
    public ArrayList<Float> GenMulRandomRi = new ArrayList<Float>();


    public  void GenerarGenMult(float semilla, float modulo, float valueA, float iteraciones){

        float valorUno = 0;
        float valorR = 0;

        for(int i = 0; i < iteraciones; i++){
            GenMulSeed.add(semilla);
            GenMulMod.add(modulo);
            GenMulValueA.add(valueA);

            valorUno = (valueA * semilla) % modulo;
            valorR = (float) valorUno / (float) (modulo - 1);
            semilla = valorUno;

            System.out.println("Valor X" + i + ":" + valorUno);
            System.out.println("Valor R" + i + ":" + valorR);

            GenMulValueX.add(valorUno);
            GenMulValueR.add(valorR);
            GenMulRandomRi.add(valorUno/modulo);


        }

    }

}