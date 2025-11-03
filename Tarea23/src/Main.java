import java.text.DecimalFormat;

public class Main {
    static void main() {
        DecimalFormat df = new DecimalFormat("#.00");
        int N=3,M=8;
        SuperMercado n = new SuperMercado(N);
        Cliente[] clientes = new Cliente[M];
        for (int i = 0;i<M;i++){
            clientes[i] = new Cliente(n);
            clientes[i].start();
        }
        try {
            for (Cliente cliente:clientes){
                cliente.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido "+e.getMessage());
        }
        System.out.println("Resultado = "+df.format(n.getResultados()));
    }
}
