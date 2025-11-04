import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion,puerto;
        String ip;
        ArrayList<String> resumen = new ArrayList<>();
       while (true) {
           System.out.println("Indica la IP a conectar");
           ip = sc.next();
           System.out.println("Elige un puerto: 1:21, 2:22, 3:80, 4:443, 5:Personalizado, 6:salir");
           opcion = sc.nextInt();
           switch (opcion) {
               case 1 -> puerto = 21;
               case 2 -> puerto = 22;
               case 3 -> puerto = 80;
               case 4 -> puerto = 443;
               case 5 -> puerto = pedirPuerto(sc);
               default -> puerto = -1;
           }
           if (puerto<0) break;
           try {
               Socket socket = new Socket(ip, puerto);
               resumen.add("IP:"+ip+" Puerto:"+puerto+" Abierto");
               socket.close();
           }catch (UnknownHostException e) {
               System.out.println("Host desconocido: "+e.getMessage());
           }
           catch (IOException e) {
               resumen.add("IP:"+ip+" Puerto:"+puerto+" cerrado");
           }
       }

        System.out.println(resumen);
    }

    private static int pedirPuerto(Scanner sc){
        System.out.println("Elige puerto a conectar");
        int puerto;
        puerto = sc.nextInt();
        return puerto;
    }
}