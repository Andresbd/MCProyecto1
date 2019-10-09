public class Main {

    public static void main(String[] args) {
    // write your code here

        MetodosCuadrados MC = new MetodosCuadrados();
        GeneradorMultiplicativo GM = new GeneradorMultiplicativo();
        CongruencialMixto CM = new CongruencialMixto();
        CongruencialLineal CL = new CongruencialLineal();
        ChiCuadrada CH = new ChiCuadrada();

        MC.GenerarMC(3708, 8);
        
        for(int x = 0; x < MC.MCAleatorio.size(); x++) {
            System.out.println("Aleatorio: "+MC.MCAleatorio.get(x));
            System.out.println("RI: "+MC.MCRandomRi.get(x));
        }

        int[] aux = CM.GenMix(4, 5, 7, 8, 7);

        for (int i = 0; i<aux.length; i++){
            System.out.println(aux[i]);
        }

        CL.CongLineal(4, 5, 7, 8, 5);
        
        for(int y = 0; y < CL.CLAleatorio.size(); y++) {
            System.out.println("Aleatorio: "+CL.CLAleatorio.get(y));
            System.out.println("RI: "+CL.CLRandomRi.get(y));
        }

        CH.ChiTest(MC.MCRandomRi);
    }
}
