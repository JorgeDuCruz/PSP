public class HiloPrioridad extends Thread{

    public HiloPrioridad(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        long duracion;
        for (int i = 1; i < 11 ;i++){
            System.out.println("Iteración: "+i+" Nombre del hilo: "+getName()+ " Prioridad: "+getPriority());
            duracion = (long) (Math.random()*9000+1000);
            try {
                Thread.sleep(duracion);
            } catch (InterruptedException e) {
                System.out.println("Error de interrupción "+e.getMessage());
            }
        }
    }
}
