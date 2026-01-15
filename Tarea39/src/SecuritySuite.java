import Cesar.CifrarCesar;
import Cesar.UsarAPI;
import FuerzaBruta.Hilos;
import FuerzaBruta.Resultado;
import Hash.CompararHash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SecuritySuite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String encontrada;
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
                    encontrada = comprobarHash("4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8");
                    break;
                }
                case 2: {
                    encontrada = descifrarCesar("KRÑD OXPGR");
                    break;
                }
                case 3:{
                    encontrada = fuerzaBruta("4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8");
                    break;
                }
                default:{
                    opcion = 0;
                }
            }
        }while (opcion!=0);
    }

    public static String comprobarHash(String contrasena){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/diccionario.txt"));
            String linea = lector.readLine();
            while (linea != null){
                if (CompararHash.compara(contrasena,linea)){
                    System.out.println("¡CONTRASEÑA ENCONTRADA! La clave es: "+linea);
                    return linea;
                }
                linea = lector.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado. "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer la linea. "+e.getMessage());
        }
        System.out.println("Contraseña no encontrada en el diccionario.");
        return null;
    }

    public static String descifrarCesar(String frase){
        String[] palabras = frase.split(" ");
        String prueba,resultado;
        int clave;
        for (int i = 1;i<28;i++){
            prueba = CifrarCesar.cifrar(palabras[0],i);
            if (UsarAPI.buscarPalabra(prueba)){
                resultado = CifrarCesar.cifrar(frase,i);
                clave = 27-i;
                System.out.println("Mensaje Descifrado: "+resultado+" (Clave: "+clave+")");
                return resultado;
            }
        }
        System.out.println("Mensaje no descifrado");
        return null;
    }

    public static String fuerzaBruta(String hash){
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

            String contrasena = Resultado.contrasena.get();

            if (contrasena != null){
                System.out.println("Contraseña es "+contrasena);
            }
            else {
                System.out.println("Contraseña no encontrada");
            }
            return contrasena;

        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido. "+e.getMessage());
        }

        return null;
    }
}