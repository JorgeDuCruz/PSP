public class HiloFibo extends Thread {
    private int N;
    public HiloFibo(int N){
        super();
        this.N = N;
    }

    @Override
    public void run(){
        int num1 = 0,num2=1,suma;
        System.out.println(num2);
        for (int i = 1;i<N;i++){
            suma = num2+num1;
            num1 = num2;
            num2 = suma;
            System.out.println(num2);
        }

    }
}
