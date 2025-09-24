import java.io.*;

public class Lanzador {

    public static void LanzarPing(String host){
        ProcessBuilder Ping = new ProcessBuilder("ping",host,"-c","4");
        Ping.redirectOutput(new File("ping_output.log"));
        Ping.redirectError(new File("ping_Error.log"));

        try {
            Process pPing = Ping.start();
            int exi = pPing.waitFor();

            System.out.println("Opercaion Completada. Codigo de salida: "+exi);


        }catch (IOException e){
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrumpido proceso: "+e.getMessage());
        }
    }
}
