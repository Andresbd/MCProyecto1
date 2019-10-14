public class MetodosCuadrados {

    public int GenerarMC (int semilla) {

        int semCua;
        String generado;
        String semStr;
        int longNum;
        int longSem;

        semCua = (int) Math.pow(semilla, 2);
        generado = Integer.toString(semCua);
        semStr = Integer.toString(semilla);
        longNum = generado.length();
        longSem = semStr.length();

        if(longNum != 4) {
            int fixed;
            StringBuilder sb = new StringBuilder(generado);
            if(longNum < 4){
                for(double i = longNum; i < 4; i++){
                    sb.insert(0, '0');
                }
                generado = sb.toString();
                fixed = Integer.parseInt(generado);
                return fixed;
            }else {
                //En caso de tener un numero mayor a 4 digitos, procedemos a recortar valores
                String newNumber;
                double size = longNum - 4;
                double remove = Math.ceil(size/2);
                int crop = longNum - (int) remove;
                newNumber = sb.substring(crop-4, crop);

                fixed = Integer.parseInt(newNumber);
                return fixed;
            }
        }else {
            return semCua;
        }
    }
}
