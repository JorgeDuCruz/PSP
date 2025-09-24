import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args){
        empezar();
    }

    /**
     * Funcion para mostrar la interfaz para elegir el host al que hacer ping hasta que se decida por salir
     */
    public static void empezar(){
        String host;
        Scanner sc = new Scanner(System.in);
        while (true) { // bucle infinito que solo sale cuando se cumple la condicion dentro de el
            System.out.println("Intorduce el Host o IP (o \"salir\" para terminar):"); // Pregunta por la IP o el Host
            host = sc.nextLine(); //Recoje la direeccion IP o el host al que hacer ping
            if (host.equalsIgnoreCase("salir")){ // Si escribe salir cumple la condicion de salida del bucle
                break;
            }
            Lanzador.LanzarPing(host); // Lanza el comando ping con el host o IP preguntado antes
        }
    }
}