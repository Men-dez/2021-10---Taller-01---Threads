import java.util.Scanner;

/**
 * @Pre: La entrada de datos pertenece a un número mayor que 0.
 */
public class Main {
    public static void main(String[] args) {
        int lim, time;
        System.out.println("Inicio del programa. Implementando la interfaz Runnable.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nLímite superior del rango de números pares e impares");
        lim = scanner.nextInt();
        System.out.println("\n\nTiempo de pausa entre cada número en milisegundos.");
        time = scanner.nextInt( );

        Number.changeTime(time);
        Thread even= new Thread(new Number(1, lim));
        even.start();
        Thread odd= new Thread(new Number(0, lim));
        odd.start();
    }
}
