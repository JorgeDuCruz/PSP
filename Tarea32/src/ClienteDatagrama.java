import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDatagrama {

    public static void main(String[] args) {

        int puerto_servidor = 6666;
        byte[] buffer = new byte[1024];
        String[] palabrasLargas = {
                "anticonstitucionalmente",
                "esternocleidomastoideo",
                "hipopotomonstrosesquipedaliofobia",
                "supercalifragilisticexpialidocious",
                "electroencefalografista"
        };


        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            // Se crea el DatagramSocket sin especificar un puerto, lo que hace que el sistema asigne un puerto aleatorio.
            // Esto es suficiente para recibir datagramas, ya que el servidor enviará los datos al puerto en el que el cliente está escuchando.
            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);


            String msj = Arrays.toString(palabrasLargas);
            buffer = msj.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto_servidor);
            datagramSocket.send(pregunta);
            System.out.println("Enviado el mensaje al servidor");

            // Se crea un DatagramPacket con el tamaño de buffer especificado.
            // Este paquete se utilizará para recibir los datos enviados por el cliente.

            // Al ejecutar este método, el buffer se llena con el mensaje enviado por el cliente.
            // Este método BLOQUEA la ejecución del código hasta que se reciba el paquete completo.
            // Si el mensaje enviado es más grande que el tamaño del buffer, el mensaje se truncará.
            datagramSocket.receive(peticion);

            System.out.println("Recibo msj del servidor");

            // Convierte el contenido del buffer recibido en un String para poder procesarlo.
            String msjServidor = new String(peticion.getData(),0, peticion.getLength());
            System.out.println("Respuesta del servidor = " + msjServidor);

        } catch (SocketException ex) {
            System.out.println("Error con el socket(cliente): "+ ex.getMessage());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
