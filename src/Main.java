public class Main {

    public static void main(String[] args) {
    // write your code here

    int result;

        MetodosCuadrados MC = new MetodosCuadrados();

        result = MC.GenerarMC(3708);
        System.out.println(result);

        for(int i = 0; i < 7; i++) {
            result = MC.GenerarMC(result);
             System.out.println(result);
        }
    }
}
