import java.io.*;

public class Main {
    public static void main(String[] args) {
        String texto="";
        String linea;
        try {
            BufferedReader leer = new BufferedReader(new FileReader("texto.txt"));
            while (true){
                linea = leer.readLine();
                if (linea==null){
                    break;
                }
                texto =texto+linea;
            }
            //Convierte el texto a un formato más simple para la comparación de los hilos
            texto = texto.toLowerCase();
            texto = texto.replace("í","i");
            texto = texto.replace("é","e");
            texto = texto.replace("á","a");
            texto = texto.replace("ó","o");
            texto = texto.replace("ú","u");


        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero "+e.getMessage());
        }

        HilosVocales a = new HilosVocales('a', texto);
        HilosVocales e = new HilosVocales('e', texto);
        HilosVocales i = new HilosVocales('i', texto);
        HilosVocales o = new HilosVocales('o', texto);
        HilosVocales u = new HilosVocales('u', texto);
        a.start();
        e.start();
        i.start();
        o.start();
        u.start();
        try {
            a.join();
            e.join();
            i.join();
            u.join();
            o.join();
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido "+ ex.getMessage());
        }

        System.out.println("Vocales contadas = "+Contador.leer());
    }
}