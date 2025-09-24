import java.io.*;

public class Lanzador {

    /**
     * Funcion que lanza el comando Ping a un host recibido con 4 paquetes
     * @param host IP o nombre del Host al que hacer ping
     */
    public static void LanzarPing(String host){
        ProcessBuilder Ping = new ProcessBuilder("ping",host,"-c","4"); // Prepara el proceso de ejecutar el ping con el host o IP reciibidos
        Ping.redirectOutput(new File("ping_output.log")); // Redirige la salida del ping a un fichero
        Ping.redirectError(new File("ping_Error.log")); // Redirige la salida de errores a un fichero

        try {
            Process pPing = Ping.start(); // Inicia el proceso de Ping
            int exi = pPing.waitFor(); // Espera a que termine y recoje su codigo de salida

            System.out.println("Opercaion Completada. Codigo de salida: "+exi); // Muestra su codigo de salida


        }catch (IOException e){ // Tratamiento de excepciones
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrumpido proceso: "+e.getMessage());
        }
    }
}
