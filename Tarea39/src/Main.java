import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean encontrada;
        do {
            System.out.println("""
                    Elige una opción
                    1. Auditoría de Hash
                    2. Decodificador César
                    3. Fuerza Bruta Paralela
                    0. Salir""");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    encontrada = comprobarHash("Jueves");
                    break;
                }
                default:{
                    opcion = 0;
                }
            }
        }while (opcion!=0);
    }

    public static boolean comprobarHash(String contrasena){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/diccionario.txt"));
            String linea = lector.readLine();
            while (linea != null){
                if (linea.equals(contrasena)){
                    System.out.println("¡CONTRASEÑA ENCONTRADA! La clave es: "+linea);
                    return true;
                }
                linea = lector.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer la linea. "+e.getMessage());
        }
        return false;
    }

    public static boolean descifrarCesar(String frase){
        String[] palabras = frase.split(" ");
        char[] letras = palabras[0].toCharArray();
        for (int i = 1;i<28;i++){

        }
        return false;
    }

    public static boolean fuerzaBruta(String hash){
        Hilos h1 = new Hilos(hash, new char[]{'a', 'f'});
        Hilos h2 = new Hilos(hash, new char[]{'g', 'm'});
        Hilos h3 = new Hilos(hash, new char[]{'n', 't'});
        Hilos h4 = new Hilos(hash, new char[]{'o', 'z'});
        Hilos[] hilos = {h1,h2,h3,h4};
        for (Hilos h:hilos){
            h.setHilos(hilos);
            h.start();
        }
        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido. "+e.getMessage());
        }

        return false;
    }
}