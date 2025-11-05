import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost",6666);

        try {
            Socket cliente = new Socket();
            cliente.connect(dir);

            System.out.println("Cliente conectado al servidor");

            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            escritor.println("Pregunta 1");
            escritor.println("Pregunta 2");
            escritor.println("Pregunta 3");

            System.out.println("Cliente ha mandado preguntas");

            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String mensaje1 = lector.readLine();
            String mensaje2 = lector.readLine();
            String mensaje3 = lector.readLine();
            System.out.println("Soy el cliente, mensajes recibidos: "+mensaje1+", "+mensaje2+", "+mensaje3);

            cliente.close();

        } catch (IOException e) {
            System.out.println("Error con el cliente: "+e.getMessage());
        }
    }
}
