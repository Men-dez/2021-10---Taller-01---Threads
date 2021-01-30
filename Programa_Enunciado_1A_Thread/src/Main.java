import java.util.Scanner;

/**
 * @Pre: La entrada de datos pertenece a un número mayor que 0.
 */
public class Main {
    public static void main(String[] args) {
        int lim, time;
        System.out.println("Inicio del programa. Extendiendo la clase Thread");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nLímite superior del rango de números pares e impares");
        lim = scanner.nextInt();
        System.out.println("\n\nTiempo de pausa entre cada número en milisegundos.");
        time = scanner.nextInt( );

        Number.changeTime(time);
        Number even= new Number(1, lim);
        even.start();
        Number odd= new Number(0, lim);
        odd.start();
    }
}