public class HilosDomino extends Thread {
    private int iteracion;
    private int nHilo;
    private Thread hiloHijo;

     public HilosDomino(int nHilo){
         super();
         this.nHilo = nHilo;
         this.iteracion=1;
     }

     @Override
    public void run(){
         if (nHilo<5){
             hiloHijo = new HilosDomino(nHilo+1);
             hiloHijo.start();
         }
         while (iteracion<=5){
             System.out.println("Soy el hilo-"+nHilo+" iteracion: "+iteracion);
             iteracion++;
         }
         try {
             if (hiloHijo!=null){
                 hiloHijo.join();
             }
             System.out.println("Acabo hilo-"+nHilo);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

     }
}
