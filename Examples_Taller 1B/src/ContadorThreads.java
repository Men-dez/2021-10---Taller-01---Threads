//Esta clase extiende de la clase Thread
public class ContadorThreads extends Thread{
    //Variable de la clase. Todos los objetos de esta clase ven esta variables.
    private static int contador = 0;

    //Este método se ejecuta al llamar el método Start().
    //Cada thread incrementa 10 mil veces el valor del contador.

    @Override
    public void run() {
        for(int i=0; i<10000; i++){
            contador++;
        }
    }

    public static void main(String[] args) {
        //Se crea un array mil de threads
        ContadorThreads[] t = new ContadorThreads[1000];

        //Se crea e incian los mil threads del array.
        for(int i = 0; i <t.length; i++){
            t[i] = new ContadorThreads();
            t[i].start();
        }

        System.out.println(contador);
    }
}
