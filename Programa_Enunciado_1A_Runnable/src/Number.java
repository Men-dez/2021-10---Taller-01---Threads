public class Number implements Runnable{

    /**
     * ID de los números que mostrará la instancia.
     * 1 si la instancia muestra números pares.
     * 0 si la instancia muestra números impares.
     */
    private int ID;

    /**
     * Tiempo en milisegundos de la instancia en mostrar los números par/impar.
     */
    private static int time;

    /**
     * Límite superior de los números a mostrar.
     */
    private int lim;

    /**
     * Constructor de  la instancia
     * @param ID ID de los números que mostrará la instancia.
     */
    public Number(int ID, int lim){
        this.ID = ID;
        this.lim = lim;
    }

    /**
     * Establece el tiempo de pausa entre cada número en función del hilo.
     * @param t Tiempo en milisengundos.
     */
    public static void changeTime( int t ){
        time = t;
    }

    /**
     * Se encarga de calcular los números impares en un rango dado.
     * @param lim1 Límite inferior para mostrar los números (pares/impares) en pantalla.
     * @param lim2  Límite superior para mostrar los números (pares/impares) en pantalla.
     */
    public void oddProcess(int lim1, int lim2){
        try {
            if (lim1 % 2 != 0 && lim2 >= lim1) {
                System.out.println("Thread 2: " + lim1);
                Thread.sleep(time);
                oddProcess(lim1+1, lim2);
            } else if (lim2 >= lim1) {
                oddProcess(lim1+1, lim2);
            }
        }
        catch(Exception e){};
    }

    /**
     * Se encarga de calcular los números pares en un rango dado.
     * @param lim1 Límite inferior para mostrar los números (pares/impares) en pantalla.
     * @param lim2  Límite superior para mostrar los números (pares/impares) en pantalla.
     */
    public void evenProcess(int lim1, int lim2){
        try {
            if (lim1 % 2 == 0 && lim2 >= lim1) {
                System.out.println("Thread 1: " + lim1);
                Thread.sleep(time);
                evenProcess(lim1+1, lim2);
            } else if (lim2 >= lim1) {
                evenProcess(lim1+1, lim2);
            }
        }
        catch(Exception e){};
    }

    /**
     * Ejecuta los métodos de mostrar número par/impar según el ID de la instancia.
     */
    @Override
    public void run() {
        if(ID==1) evenProcess(1, lim);
        else oddProcess(1, lim);
    }

}
