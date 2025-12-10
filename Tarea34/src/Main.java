import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;
import java.net.http.HttpClient;
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String url1,url2,urlVel,urlGran;
            long url1V,url2V,url1T,url2T,VelMin,TamMax;

            System.out.println("Primera URL a comparar?");
            url1 = sc.nextLine();
            System.out.println("Segunda URL a comparar?");
            url2 = sc.nextLine();

            HilosURL h1 = new HilosURL(url1);
            HilosURL h2 = new HilosURL(url2);

            h1.start();
            h2.start();

            h1.join();
            h2.join();

            url1V = h1.getVelocidad();
            url1T = h1.getTamaño();
            url2V = h2.getVelocidad();
            url2T = h2.getTamaño();

            if (url1T == url2T){
                System.out.println("Ambas webs tiene el mismo tamaño");
            }
            else{
                if (url1T>url2T){
                    urlGran = url1;
                    TamMax = url1T;
                }
                else {
                    urlGran = url2;
                    TamMax = url2T;
                }
                System.out.println("La web con más contenido ha sido: ["+urlGran+"] con ["+TamMax+"] caracteres.");
            }

            if (url1V == url2V){
                System.out.println("Ambas webs tardaron los mismo");
            }
            else {
                if (url1V<url2V){
                    urlVel = url1;
                    VelMin = url1V;
                }
                else {
                    urlVel = url2;
                    VelMin = url2V;
                }
                System.out.println("La web más rápida ha sido: ["+urlVel+"] con ["+VelMin+"] ms.");
            }


        } catch (InterruptedException e){
            System.out.println("Error con los hilos. "+e.getMessage());
        }

    }
}