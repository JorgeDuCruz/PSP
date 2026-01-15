import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
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
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz",contra;
        char[] alf = alfabeto.toCharArray(),pruebas = new char[4];
        for (char letra:letras){
            pruebas[0] = letra;
            for (char l:alf){
                pruebas[1] = l;
                for (char j:alf){
                    pruebas[2] = j;
                    for (char p:alf){
                        pruebas[3] = p;
                        contra = new String(pruebas);
                        if (CompararHash.compara(hash,contra)){
                            for (Hilos h:hilos){
                                if (h != this) h.interrupt();
                            }
                            System.out.println("Contraseña es "+contra);
                            interrupt();
                        }
                        System.out.println("Probe: "+contra+" Soy el hilo: "+getName());
                    }
                }
            }
        }
    }

}
