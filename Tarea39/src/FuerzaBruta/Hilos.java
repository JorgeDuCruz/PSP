package FuerzaBruta;

import Hash.CompararHash;

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
        char letra = letras[0];
        while (letra <= letras[1]){
            pruebas[0] = letra;
            for (char l:alf){
                pruebas[1] = l;
                for (char j:alf){
                    pruebas[2] = j;
                    for (char p:alf){
                        if (Thread.currentThread().isInterrupted()) return;
                        pruebas[3] = p;
                        contra = new String(pruebas);
                        if (CompararHash.compara(hash,contra)){
                            for (Hilos h:hilos){
                                if (h != this) h.interrupt();
                            }
                            Resultado.contrasena.compareAndSet(null,contra);
                            return;
                        }
                    }
                }
            }
            letra = (char) (letra+1);
        }
    }

}
