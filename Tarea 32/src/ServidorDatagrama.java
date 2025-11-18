import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ServidorDatagrama {

    public static void main(String[] args) {
        int puerto = 6666;
        byte[] buffer = new byte[1024];

        try (DatagramSocket datagramSocket = new DatagramSocket(puerto)){
            System.out.println("Servidor arrancando");

            // El constructor crea un DatagramSocket y lo asocia (o "vincula") al puerto especificado.


            // Se crea un DatagramPacket con el tamaño de buffer especificado.
            // Este paquete se utilizará para recibir los datos enviados por el cliente.
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            // Al ejecutar este método, el buffer se llena con el mensaje enviado por el cliente.
            // Este método BLOQUEA la ejecución del código hasta que se reciba el paquete completo.
            // Si el mensaje enviado es más grande que el tamaño del buffer, el mensaje se truncará.

            datagramSocket.receive(peticion);
            System.out.println("Recibida peticion");

            // Convierte el contenido del buffer recibido en un String para poder procesarlo.
            String msj = new String(peticion.getData(), 0, peticion.getLength());
            System.out.println("listado de palabras = " + msj);

            msj=msj.replace("[","");
            msj=msj.replace("]","");
            String[] palabras = msj.split(",");
            String palabraLarga = palabras[0];
            for (String palabra:palabras){
                if (palabraLarga.length()<palabra.length()) palabraLarga = palabra;
            }

            // La información del cliente (dirección IP y puerto) está contenida en el DatagramPacket,
            // por lo que extraemos estos datos para poder enviarle una respuesta.
            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();


            // Envio la respuesta al cliente utilizando su dirección IP y puerto extraidos previamente.
            String msjServidor = palabraLarga;
            buffer = msjServidor.getBytes();
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
            datagramSocket.send(respuesta);
            System.out.println("Envié respuesta al cliente");

        } catch (SocketException ex) {
            System.out.println("Error con el socket(servidor): "+ ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error IO(servidor): "+ ex.getMessage());
        }
    }
}
