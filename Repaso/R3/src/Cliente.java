public class Cliente extends Thread{
    private Buzon buzon;

    public Cliente(Buzon buzon){
        super();
        this.buzon=buzon;
    }

    @Override
    public void run(){
        System.out.println("Leo");
        String msj = buzon.leer();
        System.out.println("Lei: "+msj);
    }
}
