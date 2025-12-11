import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre o símbolo de la moneda");
        String nomMoneda = sc.nextLine().toLowerCase();
        JsonObject moneda = buscarMoneda(nomMoneda);
        if (moneda==null){
            System.out.println("Moneda no encontrada");
        }
        else {
            mostrarDatos(moneda);
        }
    }

    private static void mostrarDatos(JsonObject moneda) {
        String nombre = moneda.get("name").getAsString();
        String simbolo = moneda.get("symbol").getAsString();
        int rank = moneda.get("rank").getAsInt();
        String precioUSD = moneda.get("price_usd").getAsString();
        String variacion = moneda.get("percent_change_24h").getAsString();

        System.out.println("Nombre: "+nombre);
        System.out.println("Símbolo: "+simbolo);
        System.out.println("Rango: "+rank);
        System.out.println("Precio en dólares: "+precioUSD);
        System.out.println("Variación de las últimas 24 horas: "+variacion+"%");
    }

    public static JsonObject buscarMoneda(String nombre){
        try (HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){
            int monedas = cantidadMonedas();
            for (int i = 0;i<=monedas;i += 100){
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/tickers/?start="+i+"&limit=100")).GET().build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonArray data = jsonResponse.getAsJsonArray("data");

                for (int j = 0; j < data.size(); j++) {
                    JsonObject moneda = data.get(j).getAsJsonObject();
                    String nombreMon = moneda.get("name").getAsString().toLowerCase();
                    String simboloMon = moneda.get("symbol").getAsString().toLowerCase();

                    if (nombreMon.equals(nombre) || simboloMon.equals(nombre)) {
                        return moneda;  // Retorna la información de la moneda
                    }
                }

            }


        } catch (IOException | InterruptedException e) {
            System.out.println("Error al buscar moneda. "+e.getMessage());
        }
        return null;
    }

    private static int cantidadMonedas() {
        try (HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/global/")).GET().build();
            HttpResponse<String> json = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json.body(),JsonArray.class);
            JsonObject data = jsonArray.get(0).getAsJsonObject();

            return data.get("coins_count").getAsInt();

        } catch (IOException e) {
            System.out.println("Error con el send. "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error con el send2. "+e.getMessage());
        }catch (JsonSyntaxException e){
            System.out.println("Error con la sintaxis del Json. "+e.getMessage());
        }
        return 0;
    }
}