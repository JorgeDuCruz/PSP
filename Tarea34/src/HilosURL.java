import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HilosURL extends Thread{
    private String url;
    private long velocidad = 0;
    private long tamaño = 0;
    public HilosURL(String url){
        super();
        this.url = url;
    }

    @Override
    public void run(){
        try(HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            long tiempoInicio = System.currentTimeMillis();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            long tiempoFin = System.currentTimeMillis();
            velocidad = tiempoFin-tiempoInicio;
            int codigo = response.statusCode();
            if (codigo==200){
                tamaño = response.body().length();
            }

        } catch (IOException e) {
            System.out.println("Error con el send. "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error con el send 2. "+e.getMessage());;
        } catch (Exception e) {
            System.out.println("Error con la URL. "+e);
        }
    }


    public long getVelocidad() {
        return velocidad;
    }

    public long getTamaño() {
        return tamaño;
    }
}
