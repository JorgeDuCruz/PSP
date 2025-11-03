public class Cliente extends Thread{
    private SuperMercado superMercado;

    public Cliente (SuperMercado superMercado){
        this.superMercado = superMercado;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(generarTiempo());
            int cajaElegida = elegirCaja(superMercado.getN());
            double precio = generarPrecio();
            superMercado.pagar(cajaElegida,precio,getName());
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: "+e.getMessage());
        }
    }

    private int elegirCaja(int nCajas){
        int nCaja;
        nCaja = (int) (Math.random()*nCajas);
        return nCaja;
    }

    private double generarPrecio(){
        return (Math.random()*14)+1;
    }
    private long generarTiempo(){
        return  (long) (Math.random()*900)+100;
    }
}
