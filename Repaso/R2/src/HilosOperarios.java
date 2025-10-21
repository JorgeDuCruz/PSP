public class HilosOperarios extends Thread{
    private HilosOperarios hiloAnterior;
    private int tiempo;

    public HilosOperarios(HilosOperarios hiloAnterior, int tiempo){
        super();
        this.hiloAnterior = hiloAnterior;
        this.tiempo = tiempo;
    }
    @Override
    public void run(){
        if (hiloAnterior!=null){
            try {
                hiloAnterior.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: "+e.getMessage());
            }
        }
        try {
            System.out.println("Hilo trabajando: "+this.getName());
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: "+e.getMessage());
        }

    }
}
