import java.util.Scanner;

public class GeneradorMultiplicativo{

    public static void GenMult(){

        int semilla;
        int valorA;
        int modulo;
        int valorUno;
        double valorR; // para transformarlos en invervalos de 0's y 1's

        Scanner scan = new Scanner(System.in);
        System.out.println("--- Generador Multiplicativo ---");
        System.out.println("Ingresa el valor semilla:");
        semilla = scan.nextInt();
        System.out.println("Ingresa el valor 'a':");
        valorA = scan.nextInt();
        System.out.println("Ingresa el módulo");
        modulo = scan.nextInt();

        System.out.println("(" + valorA + "*" + semilla + ")mod" + modulo);
        for (int i = 0; i <= 10; i++) {
            valorUno = (valorA * semilla) % modulo;
            System.out.println("Valor X" + i + ":" + valorUno);
            valorR = (double) valorUno / (double) (modulo - 1); // para transformarlos en invervalos de 0's y 1's
            System.out.println("Valor R" + i + ":" + valorR);
            semilla = valorUno;
        }
    }

}