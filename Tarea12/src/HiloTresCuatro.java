public class HiloTresCuatro extends Thread{
    @Override
    public void run(){
        int suma = 0;
        int unidad;
        for (int i = 1;i<=1923;i++){
            unidad = getUnidad(i);
            if (unidad==3 || unidad == 4){
                suma += i;
            }
        }
        System.out.println("Suma de numeros terminados en 3 o 4: "+suma);
    }


    private int getUnidad(int numero){
        return numero%10;
    }
}

