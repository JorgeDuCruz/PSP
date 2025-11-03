import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SuperMercado {
    private int N;
    private double Resultados;

    private Lock[] candado;
    private Condition[] cajas;
    private double[] cajaAux;

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
        this.cajas = new Condition[N];
        this.cajaAux = new double[N];
        for (int i = 0;i<N;i++){
            this.candado[i] = new ReentrantLock();
            this.cajas[i] = this.candado[i].newCondition();
            this.cajaAux[i] = 0;
        }
    }

    public void pagar(int nCaja, double precio, String cliente){
        if (nCaja < N+1 && precio>0){
            this.candado[nCaja].lock();
            try {
                while (this.cajaAux[nCaja] != 0){
                    System.out.println("Esperando en la caja "+nCaja+" Cliente "+cliente);
                    this.cajas[nCaja].await();
                }
                this.cajaAux[nCaja] = precio;
                System.out.println("Cliente "+cliente+" Ha pagado en la caja "+nCaja);
                recojerPago(nCaja);
                this.cajas[nCaja].signal();
            } catch (InterruptedException e) {
                System.out.println("Error al pagar en la caja "+nCaja+": "+e.getMessage());
            }
            finally {
                this.candado[nCaja].unlock();
            }
        }
    }
    private void recojerPago(int nCaja){
        this.Resultados += this.cajaAux[nCaja];
        this.cajaAux[nCaja]=0;
    }

    public double getResultados(){
        return Resultados;
    }
    public int getN(){
        return N;
    }
}
