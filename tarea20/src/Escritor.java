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

    }
}
