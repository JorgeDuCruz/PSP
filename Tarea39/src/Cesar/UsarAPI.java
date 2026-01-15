package Cesar;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class UsarAPI {
    public static boolean buscarPalabra(String palabra){
        palabra = palabra.toLowerCase();
        try (HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){
            String formData = "text="+palabra+"&language=es"    ;
            HttpRequest request = HttpRequest.newBuilder().
                    uri(URI.create("https://api.languagetool.org/v2/check")).
                    header("Content-Type", "application/x-www-form-urlencoded").
                    POST(HttpRequest.BodyPublishers.ofString(formData)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                String responseBody = response.body();
                // Verificar si la respuesta tiene sugerencias de errores
                return responseBody.contains("\"matches\":[]");
            }
            else {
                System.out.println("Error en la solicitud. Código de estado: " + response.statusCode());
                return false;
            }




        } catch (IOException | InterruptedException e) {
            System.out.println("Error al buscar palabra. "+e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        buscarPalabra("hola");
    }
}
