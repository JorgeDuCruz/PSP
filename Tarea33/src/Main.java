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
        try ( HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        BufferedWriter escritor =  new BufferedWriter(new FileWriter("inspector.html"))) {
            Scanner sc = new Scanner(System.in);
            String url;

            System.out.println("URL a la que hacer un GET?");
            url = sc.nextLine();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            int codigo = response.statusCode();
            System.out.println("Código de respuesta: "+codigo);
            System.out.println("Contenido: "+response.headers());
            if (codigo == 200){
                escritor.write(response.body());
            }
        } catch (IOException e) {
            System.out.println("Error con el send. "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error con el send 2. "+e.getMessage());;
        }

    }
}