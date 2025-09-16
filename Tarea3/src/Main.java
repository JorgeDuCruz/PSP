import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fichero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del fichero que quieras abrir/crea o su ruta completa (Añadir extension del archivo tambien)");
        fichero = sc.nextLine();
        while (!fichero.contains(".")){
            System.out.println("Necesita añadir la extension del archivo");
            fichero = sc.next();
        }

        ProcessBuilder blocNotas = new ProcessBuilder("gnome-text-editor", fichero);
        try {
            Process p1BlocNotas = blocNotas.start();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}