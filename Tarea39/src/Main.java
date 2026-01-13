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
}