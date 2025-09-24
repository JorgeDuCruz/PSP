import java.io.IOException;

public class Lanzador {
    public static void LanzarPing(String host){
        ProcessBuilder Ping = new ProcessBuilder("ping",host,"-c","4");

        try {
            Ping.inheritIO();

            Process pPing = Ping.start();
            Thread.sleep(3500);
            int exi = pPing.exitValue();
            System.out.println("Opercaion Completada: "+exi);
        }catch (IOException e){
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrumpido proceso: "+e.getMessage());
        }
    }
}
