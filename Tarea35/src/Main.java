import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.Scanner;
import java.net.http.HttpClient;
public class Main {
    public static void main(String[] args) {
        try ( HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()) {

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/tickers/?start=100&limit=100")).GET().build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (IOException e) {
            System.out.println("Error con el send. "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error con el send 2. "+e.getMessage());;
        }

    }

    public static int buscarID(String nombre){
        try (HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){
            for (int i = 0;i<=cantidadMonedas();i += 100){
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/tickers/?start="+i+"&limit=100")).GET().build();
            }


        }
        return -1;
    }

    private static int cantidadMonedas() {
        try (HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/global/")).GET().build();
            HttpResponse<String> json = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();

        } catch (IOException e) {
            System.out.println("Error con el send. "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error con el send2. "+e.getMessage());
        }
        return 0;
    }
}