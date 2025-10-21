public class Buzon {
    private String mensaje;
    public synchronized void escribir(String msj){
        while (mensaje!=null){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("hilo interrumpido: "+e.getMessage());
            }
        }
        mensaje = msj;
        notifyAll();
    }

    public synchronized String leer(){
        while (mensaje==null){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: "+e.getMessage());
            }
        }
        String msj = mensaje;
        mensaje = null;
        notifyAll();
        return msj;
    }
}
