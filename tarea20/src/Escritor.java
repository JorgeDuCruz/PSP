public class Escritor extends Thread{
    private String mensaje;
    private Buzon buzon;
    public Escritor(String msj, Buzon b) {
        super();
        mensaje = msj;
        buzon = b;
    }

    @Override
    public void run(){
        for (int i=0;i<5;i++){

            try {
                Thread.sleep(100);
                buzon.escribirMensaje(mensaje);

            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido "+e.getMessage());
            }catch (Exception e){
                System.out.println("Fallo en el Escritor "+e.getMessage());
            }
        }
    }
}
