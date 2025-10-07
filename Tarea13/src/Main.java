public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new HiloPrioridad("Hilo 1");
        hilo1.start();
        hilo1.setPriority(Thread.MIN_PRIORITY);

        Thread hilo2 = new HiloPrioridad("Hilo 2");
        hilo2.start();
        hilo2.setPriority(Thread.NORM_PRIORITY);

        Thread hilo3 = new HiloPrioridad("Hilo 3");
        hilo3.start();
        hilo3.setPriority(Thread.NORM_PRIORITY);

        Thread hilo4 = new HiloPrioridad("Hilo 4");
        hilo4.start();
        hilo4.setPriority(Thread.MAX_PRIORITY);

    }
}