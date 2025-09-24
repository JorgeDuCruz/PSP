import java.io.*;

public class Lanzador {

    public static void LanzarPing(String host){
        ProcessBuilder Ping = new ProcessBuilder("ping",host,"-c","4");
        InputStream consola;
        String extra;

        try {
            Process pPing = Ping.start();
            int exi = pPing.waitFor();


            if (exi==0){
                consola = pPing.getInputStream();
                extra = "[OK]";
            }
            else {
                consola = pPing.getErrorStream();
                extra = "[ERROR]";
            }
            BufferedReader lectura = new BufferedReader(new InputStreamReader(consola));

            while (true) {
                String linea = lectura.readLine();
                if (linea==null){
                    break;
                }
                System.out.println(extra+linea);
            }

            System.out.println("Opercaion Completada. Codigo de salida: "+exi);


        }catch (IOException e){
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrumpido proceso: "+e.getMessage());
        }
    }
}
