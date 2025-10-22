import java.util.Arrays;

public class Parking {
    private int[] plazas;

    public Parking(int nPlazas) {
        this.plazas = new int[nPlazas];
    }

    private int plazaLibre(){
        return buscarCoche(0); // Los coches no pueden tener el número 0 por lo que esto devuelve la primera plaza libre o -1 si no hay
    }

    private int buscarCoche(int coche) {
        for (int i = 0;i<plazas.length;i++){
            if (plazas[i] == coche){
                return i;
            }
        }
        return -1;
    }

    public synchronized void aparcar(int coche){
        while (plazaLibre() == -1){
            System.out.println("Coche "+coche+" en espera");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido al aparcar: "+e.getMessage());
            }
        }
        int plaza = plazaLibre();
        plazas[plaza] = coche;
        System.out.println("Entrada: Coche "+coche+" aparcando en "+plaza+"\n"+Arrays.toString(plazas));

    }

    public synchronized void salir(int coche){
        int plaza = buscarCoche(coche);
        if (plaza != -1){
            plazas[plaza] = 0;
            System.out.println("Salida: Coche "+coche+" saliendo de "+plaza+"\n"+Arrays.toString(plazas));
            notifyAll();
        }

    }



    public int[] getPlazas(){
        return plazas;
    }
}
