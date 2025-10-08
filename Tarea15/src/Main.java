public class Main {
    public static void main(String[] args) {
        HilosIteracion hilo1 = new HilosIteracion();
        HilosIteracion hilo2 = new HilosIteracion();
        HilosIteracion hilo3 = new HilosIteracion();

        hilo1.setHiloPadre(hilo2);
        hilo2.setHiloPadre(hilo3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo "+hilo1.getName()+" interrumpido "+e.getMessage());
        }
        System.out.println("Programa principal terminado.");

    }
}