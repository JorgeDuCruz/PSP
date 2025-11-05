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
            String mensaje, respuesta;
            ServerSocket server = new ServerSocket();
            server.bind(dir);
            Socket cliente = server.accept();

            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);

            while (true){
                mensaje = lector.readLine();
                respuesta = "ECO: "+mensaje;
                escritor.println(respuesta);
                if (mensaje == null || mensaje.equalsIgnoreCase("adios")) break;
            }

            System.out.println("Servidor ha enviado la info");

            cliente.close();
            server.close();
        } catch (IOException e) {
            System.out.println("Problema con el servidor: "+e.getMessage());
        }
    }
}