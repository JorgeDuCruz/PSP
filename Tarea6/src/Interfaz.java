import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args){
        String host;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Intorduce el Host o IP (o \"salir\" para terminar):");
            host = sc.nextLine();
            if (host.equalsIgnoreCase("salir")){
                break;
            }
            Lanzador.LanzarPing(host);
        }
    }
}