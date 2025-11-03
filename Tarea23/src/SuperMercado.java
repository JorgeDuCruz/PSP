import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SuperMercado {
    private int N;
    private double Resultados;

    private Lock[] candado;

    public SuperMercado(int cajas){
        this.Resultados = 0;
        setN(cajas);
        setCajas(cajas);
    }
    private void setN(int N){
        if (N>0){
            this.N = N;
        }else this.N = 1;
    }
    private void setCajas(int N){
        this.candado = new ReentrantLock[N];
        for (int i = 0;i<N;i++){
            this.candado[i] = new ReentrantLock();
        }
    }

    public void pagar(int nCaja, double precio, String cliente){
        if (nCaja < N+1 && precio>0){
            this.candado[nCaja].lock();
            this.Resultados += precio;
            System.out.println("Cliente "+cliente+" Ha pagado en la caja "+nCaja);
            this.candado[nCaja].unlock();
        }
    }

    public double getResultados(){
        return Resultados;
    }
    public int getN(){
        return N;
    }
}
