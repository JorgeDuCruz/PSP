public class HilosTorno extends Thread{

    @Override
    public void run(){
        int aforo=0;
        try {
            for (int i = 0;i<1000;i++) {
                System.out.println("haciendo algo");
                long tiempo = Math.round(Math.random() * 100);
                Thread.sleep(tiempo);
                aforo++;
            }
            Aforo.contar(aforo);
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido "+e.getMessage());
        }
    }
}
