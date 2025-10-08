public class Main {
    public static void main(String[] args) {
        Thread hiloI = new HiloIngresos();
        hiloI.start();
        Thread hiloE = new HiloExtraccion();
        hiloE.start();
        try {
            hiloI.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo de ingresos interrumpido "+e.getMessage());
        }
        try {
            hiloE.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo de Extracciones interrumpido "+e.getMessage());
        }
        System.out.println("Capital final = "+Caja.capital);
    }
}