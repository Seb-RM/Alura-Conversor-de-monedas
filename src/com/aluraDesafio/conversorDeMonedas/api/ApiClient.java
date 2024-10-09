package com.aluraDesafio.conversorDeMonedas.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiClient {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;

    public ApiClient() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/config.properties");
            properties.load(fileInputStream);
            this.apiKey = properties.getProperty("API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String obtenerTasasDeCambio() {

        String url = API_URL  + apiKey + "/latest/USD";

        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Error en la solicitud, estado: " + response.statusCode());
            }
        } catch(Exception e) {
            System.out.println("Error al conectar a la API: " + e.getMessage());
        }

        return null;
    }
}
