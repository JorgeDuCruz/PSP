import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String direccion;

        System.out.println("Escribe un nombre de dominio");
        direccion = sc.nextLine();

        try {
            InetAddress ip = InetAddress.getByName(direccion);
            System.out.println(ip.getHostName()+" - "+ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Host no encontrado: "+e.getLocalizedMessage());
        }

        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Local: "+local.getHostName()+" - "+local.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Host local no encontrado: "+e.getLocalizedMessage());
        }



    }
}