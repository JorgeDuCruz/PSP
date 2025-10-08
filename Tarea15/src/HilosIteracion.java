public class HilosIteracion extends Thread{
    Thread hiloPadre;
    public HilosIteracion(){
        super();
    }

    public void setHiloPadre(Thread padre){
        this.hiloPadre = padre;
    }

    @Override
    public void run(){
        if (hiloPadre != null){
            try {
                hiloPadre.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo hijo del hilo: "+getName()+" interrumpido. "+e.getMessage());
            }
        }
        for (int i = 1;i<9;i++){
            System.out.println("Soy el "+getName()+" - iteración: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Hilo "+getName()+" interrumpido");
            }
        }
    }
}
