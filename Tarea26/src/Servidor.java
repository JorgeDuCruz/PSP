import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            InetSocketAddress dir = new InetSocketAddress("localhost",6666);
            ServerSocket server = new ServerSocket();
            server.bind(dir);
            Socket cliente = server.accept();

            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String mensaje1 = lector.readLine();
            String mensaje2 = lector.readLine();
            String mensaje3 = lector.readLine();
            System.out.println("Soy el servidor, mensajes recibidos: "+mensaje1+", "+mensaje2+", "+mensaje3);

            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            escritor.println("Respuesta 1");
            escritor.println("Respuesta 2");
            escritor.println("Respuesta 3");

            System.out.println("Servidor ha enviado la info");

            cliente.close();
            server.close();
        } catch (IOException e) {
            System.out.println("Problema con el servidor: "+e.getMessage());
        }
    }
}
