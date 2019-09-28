public class MetodosCuadrados {

    int semilla;
    String generado;
    String semStr;

    public int GenerarMC (int semilla) {
        int semCua;
        int longNum;
        int longSem;

        semCua = semilla * semilla;
        generado = Integer.toString(semCua);
        semStr = Integer.toString(semilla);
        longNum = generado.length();
        longSem = semStr.length();

        if(longNum != 4) {
            int fixed;
            StringBuilder sb = new StringBuilder(generado);
            if(longNum < 4){
                for(int i = longNum; i < 4; i++){
                    sb.insert(0, '0');
                }
                generado = sb.toString();
                fixed = Integer.parseInt(generado);
                return fixed;
            }else {
                //En caso de tener un numero mayor a 4 digitos, procedemos a recortar valores
                int size = longNum - longSem;
                int half = size/2;
                sb.delete(0, half);

                int newSize = sb.length();
                
                //En caso de tener 5 digitos, quitamos el primero y conservamos los siguientes 4
                if(newSize > 4) {
                    
                    sb.delete(newSize-half-1, newSize);
                }

                generado = sb.toString();
                fixed = Integer.parseInt(generado);
                return fixed;
            }
        }else {
            return semCua;
        }
    }
}
