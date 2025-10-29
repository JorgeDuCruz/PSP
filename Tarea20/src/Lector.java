public class Lector extends Thread{
    private Buzon buzon;
    public Lector(Buzon b) {
        super();
        buzon = b;
    }

    @Override
    public void run(){
        String mensaje;
        for (int i=0;i<5;i++){

            try {
                mensaje = buzon.leerMensaje();
                System.out.println(mensaje+" Soy el lector "+getName());
                Thread.sleep(100);

            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido "+e.getMessage());
            } catch (Exception e) {
                System.out.println("Fallo raro en el Lector"+e.getMessage());
            }

        }
    }
}
