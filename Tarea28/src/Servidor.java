import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket()){
            InetSocketAddress dir = new InetSocketAddress("localhost",6666);
            server.bind(dir);

            while (true){
                Socket cliente = server.accept();
                System.out.println("Cliente Conectado");
                HiloServidor h1 = new HiloServidor(cliente);
                h1.start();
            }
        } catch (IOException e) {
            System.out.println("Problema con el servidor: "+e.getMessage());
        }
    }
}