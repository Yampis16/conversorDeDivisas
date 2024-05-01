package Conversiones;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeDivisas {

    // Metodo construido para que sea mas facil llamar a la API segun las divisas a convertir.

    public static Conversion convierteDivisas(String divisa1, String divisa2, double amount) throws IOException, InterruptedException {

        // Llamado del paquete Gson para la conversion del archivo Gson.

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Construccion del llamado a la API de conversión de divisas usando la opcion de conversión.

        String address = "https://v6.exchangerate-api.com/v6/0fd43b0475f953ab9be68b3c/pair/" + divisa1 + "/" + divisa2 + "/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), Conversion.class);
    }

}