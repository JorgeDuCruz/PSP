public class Contador {
    private static int contador = 0;
    public synchronized static void sumar(){
        contador++;
    }
    public static int leer(){
        return contador;
    }
}
