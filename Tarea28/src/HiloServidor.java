import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
    private Socket cliente;
    public HiloServidor(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run(){
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true)
        ){
            String mensaje, respuesta;

            while (true) {
                mensaje = lector.readLine();
                if (mensaje == null || mensaje.equalsIgnoreCase("adios")) break;
                respuesta = "ECO: " + mensaje;
                escritor.println(respuesta);

            }

        } catch(IOException e){
            System.out.println("Error de conexión con el cliente "+cliente.getInetAddress()+": "+e.getMessage());
        }
        finally {
            try {
                cliente.close();
            } catch (IOException e) {
                System.out.println("Error con el cliente "+cliente.getInetAddress()+": "+e.getMessage());
            }
        }
    }
}
