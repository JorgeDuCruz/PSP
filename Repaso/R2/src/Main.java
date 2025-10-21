public class Main {
    public static void main(String[] args) {
        HilosOperarios operario1 = new HilosOperarios(null,2000);
        HilosOperarios operario2 = new HilosOperarios(operario1,1000);
        HilosOperarios operario3 = new HilosOperarios(operario2,1000);

        operario1.start();
        operario2.start();
        operario3.start();

        try {
            operario3.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: "+e.getMessage());
        }
        System.out.println("Pieza lista para envío");

    }
}
