import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        int result;

        MetodosCuadrados MC = new MetodosCuadrados();
        GeneradorMultiplicativo GM = new GeneradorMultiplicativo();
        CongruencialMixto CM = new CongruencialMixto();

        result = MC.GenerarMC(3547);
        System.out.println("Iteración 0: "+result);

        for(int i = 1; i < 7; i++) {
            result = MC.GenerarMC(result);
             System.out.println("Iteración " + i + ": "+result);
        }

        ArrayList aux = CM.GenMix(37, 9, 29, 100, 10 );

        for (int i = 0; i<aux.size(); i++){
            System.out.println(aux.get(i));
        }

    }
}
