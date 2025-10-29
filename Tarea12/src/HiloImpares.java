public class HiloImpares extends Thread{
    @Override
    public void run(){
        int suma = 0;
        for (int i = 1;i<=1923;i++){
            if (i%2!=0){
                suma += i;
            }
        }
        System.out.println("Suma impares: "+suma);
    }
}
