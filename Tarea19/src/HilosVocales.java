public class HilosVocales extends Thread{
    private char vocal;
    private String texto;
    public HilosVocales(char vocal, String texto) {
        super();
        this.vocal = vocal;
        this.texto = texto;
    }

    @Override
    public void run(){
        for (int i = 0;i<texto.length();i++){
            if (texto.charAt(i) == vocal){
                Contador.sumar();
            }
        }
    }
}
