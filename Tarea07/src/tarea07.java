import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tarea07 {

    public static void main(String[] args) {
        try {
            Process proceso = new ProcessBuilder("python3", "src/Tarea7B.py").start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            proceso.waitFor();
            int exitStatus = proceso.exitValue();
            System.out.println("Retorno:" + br.readLine());
            System.out.println("Valor de la salida:" + exitStatus);
        } catch (IOException | InterruptedException e) {
            System.out.println("Algo fallo "+e.getMessage());
        }
    }
}
