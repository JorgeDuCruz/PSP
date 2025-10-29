import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Crea un programa en Java que esté en bucle realizando lo siguiente:

1. Pide por consola al usuario un comando y sus parámetros a ejecutar (si fuese necesario) (Por ejemplo, ls, gnome-text-editor, open...)
2. Lanza el proceso y obtén el código de finalización del mismo.
3. Muestra el nombre del programa y el código de finalización del mismo.

El programa finaliza cuando un usuario introduce “salir” y devolverá un código de salida = 0. Prueba a introducir comandos y/o parámetros inexistentes y observa el código de finalización.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comando,parametros;
        boolean seguir = true;
        while (seguir){
            System.out.println("Comando a ejecutar:");
            comando = sc.nextLine();
            System.out.println("Agregar Parametros?[s/n]");
            parametros= sc.nextLine();
            if (parametros.equalsIgnoreCase("s")){
                System.out.println("Parametros");
                parametros = sc.nextLine();
                crearProceso(comando,parametros);
            } else if (parametros.equalsIgnoreCase("n")) {
                crearProceso(comando);
            }else {
                System.out.println("respuesta no reconocida");
            }
            System.out.println("Terminar?[s/n]");
            comando = sc.nextLine();
            if (comando.equalsIgnoreCase("s")){
                seguir=false;
            }
        }

    }

    public static void mostrarDatosProceso(String comando,int exitCode){
        System.out.println("Comando lanzado: "+comando);
        System.out.println("Codigo de salida: "+exitCode);
    }

    public static void crearProceso(String comando, String parametros){
        ProcessBuilder pP = new ProcessBuilder(comando,parametros);
        pP.redirectOutput(new File("muestraComandos"));
        try {
            Process ppP = pP.start();
            int exitCode = ppP.waitFor();
            mostrarDatosProceso(comando,exitCode);
        }catch (IOException e){
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        }catch (InterruptedException e) {
            System.out.println("Error de interrupcion: "+e.getMessage());
        }
    }

    public static void crearProceso(String comando){
        ProcessBuilder pP = new ProcessBuilder(comando);
        pP.redirectOutput(new File("muestraComandos"));
        try {
            Process ppP = pP.start();
            int exitCode = ppP.waitFor();
            mostrarDatosProceso(comando,exitCode);
        }catch (IOException e){
            System.out.println("Error al iniciar proceso: "+e.getMessage());
        }catch (InterruptedException e) {
            System.out.println("Error de interrupcion: "+e.getMessage());
        }
    }
}