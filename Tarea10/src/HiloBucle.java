public class HiloBucle extends Thread{
    public HiloBucle(){
        super();
    }


    @Override
    public void run(){
        for (int i=0;i<11;i++){
            System.out.println("numero de iteracion: "+i+" nombre: "+getName());
            try {
                Thread.sleep((long) ((Math.random()*10)+1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
