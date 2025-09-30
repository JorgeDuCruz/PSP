public class HilosProfesor  extends Thread{
    private int paciencia;
    public HilosProfesor(String nombre, int paciencia){
        super(nombre);
        this.paciencia=paciencia;
    }

    @Override
    public void run(){
        for (int i = 0;i<paciencia;i++){
            System.out.println("["+getName()+"] Cabreo nivel: "+i);
        }
        System.out.println("["+getName()+"] Cabreo nivel: "+paciencia+"... ¡He llegado a mi límite!");
    }
}
