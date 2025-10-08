public class HiloIngresos extends Thread{

    public HiloIngresos(){
        super();
    }

    @Override
    public void run(){
        for (int i=0;i<5000;i++ ){
            System.out.println("Saldo actual: "+Caja.capital);
            System.out.println("Iteración del hilo I: "+i);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Hilo de ingresos interrumpido "+e.getMessage());
            }
            Caja.incrementar(10);
        }
    }
}
