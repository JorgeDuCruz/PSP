public class Aforo {
    private static int aforo;

    static synchronized void contar(int suma){
        aforo += suma;
    }
    static int leerAforo(){
        return aforo;
    }
}
