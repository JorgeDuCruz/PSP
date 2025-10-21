public class Main {
    public static void main(String[] args) {
        HilosTorno h1 = new HilosTorno();
        HilosTorno h2 = new HilosTorno();
        HilosTorno h3 = new HilosTorno();
        HilosTorno h4 = new HilosTorno();

        System.out.println("Empezo");
        h1.start();
        h2.start();
        h3.start();
        h4.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException e) {
            System.out.println("Hilos interrumpidos "+e.getMessage());
        }
        System.out.println("Aforo: "+Aforo.leerAforo());
    }
}