public class Buzon {
    private  String mensaje;

    public synchronized  void escribirMensaje(String msj){
        while (mensaje!=null){
            System.out.println("buzón lleno esperando");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido "+e.getMessage());
            }
        }
        mensaje = msj;
        System.out.println("Escritor escribio: "+msj);
        notifyAll();
    }

    public  String leerMensaje(){
        while (mensaje == null){
            System.out.println("Buzón vacio esperando");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpida lectura "+e.getMessage());
            }
        }
        String msj = mensaje;
        mensaje = null;
        return msj;
    }
}
