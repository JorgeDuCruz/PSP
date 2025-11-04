import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        Scanner sc = new Scanner(System.in);
        int N,M;
        System.out.println("Elige cuantas cajas tendrá el mercado");
        N = sc.nextInt();
        System.out.println("Elige cuantos clientes tendrá el mercado");
        M = sc.nextInt();
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
