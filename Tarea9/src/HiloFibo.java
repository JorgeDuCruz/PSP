public class HiloFibo extends Thread {
    private int N;
    public HiloFibo(int N){
        super();
        this.N = N;
    }

    @Override
    public void run(){
        int num1 = 0,num2=1,suma;

        for (int i = 0;i<N;i++){
            System.out.println(num2);
            suma = num2+num1;
            num1 = num2;
            num2 = suma;

        }

    }
}
