public class HiloExtraccion extends Thread{
    @Override
    public void run(){
        for (int i=0;i<3000;i++ ){
            System.out.println("Saldo actual: "+Caja.capital);
            System.out.println("Iteración del hilo E: "+i);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Hilo de ingresos interrumpido "+e.getMessage());
            }

            Caja.decrementar(10);
        }
    }
}
