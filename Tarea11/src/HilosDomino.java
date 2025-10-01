public class HilosDomino extends Thread {
    private int iteracion;
    private int nHilo;
    private Thread hiloHijo;
    private int limiteCadena;

     public HilosDomino(int nHilo,int limiteCadena){
         super();
         this.nHilo = nHilo;
         this.iteracion=1;
         setLimiteCadena(limiteCadena);
     }

    public void setLimiteCadena(int limiteCadena) {
        if (limiteCadena>=1){
            this.limiteCadena = limiteCadena;
        }
        else {
            this.limiteCadena = 5;
        }
    }

    @Override
    public void run(){
         if (nHilo<limiteCadena){
             hiloHijo = new HilosDomino(nHilo+1,limiteCadena);
             hiloHijo.start();
         }
         while (iteracion<=5){
             int dormir = (int)(Math.random()*500+100);
             try {
                 Thread.sleep(dormir);
             } catch (InterruptedException e) {
                 System.out.println("Interrumpido el sleep en el hilo "+nHilo+" "+e.getMessage());
             }
             System.out.println("Soy [hilo-"+nHilo+"] iteracion: "+iteracion);
             iteracion++;
         }
         try {
             if (hiloHijo!=null){
                 hiloHijo.join();
             }
             System.out.println("Acabo hilo-"+nHilo);
         } catch (InterruptedException e) {
             System.out.println("Interrumpido el join en el hilo "+nHilo+" "+e.getMessage());
         }

     }
}
