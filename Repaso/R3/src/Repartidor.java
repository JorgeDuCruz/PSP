public class Repartidor extends Thread{
    private Buzon buzon;
    private String msj;

    public Repartidor(Buzon buzon,String msj){
        super();
        this.buzon=buzon;
        this.msj=msj;
    }
    @Override
    public void run(){
        buzon.escribir(msj);
        System.out.println("Mensaje escrito");
    }
}
