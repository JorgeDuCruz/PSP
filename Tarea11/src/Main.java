//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis(),tiempoFin,tiempoEjecucion;
        Thread hiloInicio = new HilosDomino(1,5);
        hiloInicio.start();
        while (hiloInicio.isAlive()){
            System.out.println("[Control Central] Vigilando a Hilo-1... sigue activo.");
            try {
                Thread.sleep(200);
            }catch (InterruptedException e ){
                System.out.println("Interrumpida espera de main "+e.getMessage());
            }
        }
        System.out.println("[Control Central] Hilo-1 ha terminado.");
        tiempoFin = System.currentTimeMillis();
        tiempoEjecucion = tiempoFin-tiempoInicio;
        System.out.println("Tiempo total de la caída: "+tiempoEjecucion+" ms");
    }
}