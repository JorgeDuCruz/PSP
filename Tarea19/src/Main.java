import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String texto = "Prueba de cUantas vocales deteCTA";
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el texto para contar sus vocales");
        texto = sc.nextLine();
        sc.close();


        HilosVocales a = new HilosVocales('a',texto);
        HilosVocales e = new HilosVocales('e',texto);
        HilosVocales i = new HilosVocales('i',texto);
        HilosVocales o = new HilosVocales('o',texto);
        HilosVocales u = new HilosVocales('u',texto);
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