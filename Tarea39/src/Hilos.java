import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

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
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz",pruebas,hp;
        char[] alf = alfabeto.toCharArray();
        for (char letra:letras){
            pruebas = ""+letra;
            for (char l:alf){
                pruebas = pruebas+l;
                for (char j:alf){
                    pruebas = pruebas+j;
                    for (char p:alf){
                        pruebas = pruebas+p;
                        hp = hashear(pruebas);
                        if (hash.equals(hp)){
                            System.out.println("Contraseña es "+pruebas);
                            for (Hilos h:hilos){
                                h.interrupt();
                            }
                        }
                        else pruebas = pruebas+"\b";
                    }
                    pruebas = pruebas+"\b";
                }
                pruebas = pruebas+"\b";
            }
        }
    }

    private String hashear(String texto){
        String has;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(texto.getBytes());
            has = HexFormat.of().formatHex(md.digest());
            return has;


        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro con el algoritmo de hashing "+e.getMessage());
        }
        return null;
    }
}
