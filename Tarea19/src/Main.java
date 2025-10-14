import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder texto = new StringBuilder();
        String linea;
        try {
            BufferedReader leer = new BufferedReader(new FileReader("texto.txt"));
            while (true){
                linea = leer.readLine();
                if (linea==null){
                    break;
                }
                texto.append(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero "+e.getMessage());
        }

        HilosVocales a = new HilosVocales('a', texto.toString());
        HilosVocales e = new HilosVocales('e', texto.toString());
        HilosVocales i = new HilosVocales('i', texto.toString());
        HilosVocales o = new HilosVocales('o', texto.toString());
        HilosVocales u = new HilosVocales('u', texto.toString());
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