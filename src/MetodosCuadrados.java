import java.util.*;

public class MetodosCuadrados {

    public ArrayList MCAleatorio = new ArrayList<>();
    public ArrayList<Float> MCRandomRi = new ArrayList<Float>();

    public void GenerarMC (int semilla, int iterations) {

        int semCua;
        String generado;
        String semStr;
        int longNum;
        int longSem;
        int fixed;

        for(int i = 0; i < iterations; i++) {

            semCua = (int) Math.pow(semilla, 2);
            generado = Integer.toString(semCua);
            semStr = Integer.toString(semilla);
            longNum = generado.length();
            longSem = semStr.length();

            if(longNum != 4) {
                
                StringBuilder sb = new StringBuilder(generado);

                if(longNum < 4){
                    for(double j = longNum; j < 4; j++){
                        sb.insert(0, '0');
                    }
                    generado = sb.toString();
                    fixed = Integer.parseInt(generado);
                    semilla = fixed;
                    MCAleatorio.add(fixed);
                    ConvertRI(generado);
                }else {
                    //En caso de tener un numero mayor a 4 digitos, procedemos a recortar valores
                    String newNumber;
                    double size = longNum - longSem;
                    double remove = Math.ceil(size/2);
                    int crop = longNum - (int) remove;
                    newNumber = sb.substring(crop-4, crop);

                    fixed = Integer.parseInt(newNumber);
                    semilla = fixed;
                    MCAleatorio.add(fixed);
                    ConvertRI(newNumber);
                }
            }else {
                semilla = semCua;
                MCAleatorio.add(semCua);
                ConvertRI(generado);
            }

        }
    }

    void ConvertRI(String num) {
        StringBuilder sb2 = new StringBuilder(num);
        sb2.insert(0, '0');
        sb2.insert(1, '.');

        String ri = sb2.toString();
        float genRi = Float.parseFloat(ri);

        MCRandomRi.add(genRi);

    }
}
