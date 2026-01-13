public class Hilos extends Thread{
    private Hilos[] hilos;
    private String hash;
    private char[] letras;

    public Hilos(String hash, char[] letras){
        super();
        this.hash = hash;
        this.letras = letras;
    }

    public void setHilos(Hilos[] hilos){
        this.hilos=hilos;
    }

    @Override
    public void run(){
        char letra = letras[0];
        while (true){
            letra = (char) (letra+1);

        }
    }
}
