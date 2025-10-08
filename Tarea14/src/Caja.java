public class Caja {
    public static double capital = 1000.0;

    public synchronized static void incrementar(int precio){
        capital += precio;
    }

    public synchronized static void decrementar(int precio){
        capital -= precio;
    }
}
