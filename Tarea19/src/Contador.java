public class Contador {
    private static int contador;
    public synchronized static void sumar(){
        contador++;
    }
    public static int leer(){
        return contador;
    }
}
