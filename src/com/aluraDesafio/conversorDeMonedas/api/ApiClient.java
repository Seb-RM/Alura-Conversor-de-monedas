package com.aluraDesafio.conversorDeMonedas.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String ACCESS_KEY = "f9c94e16da0cb63888ce5348";

    public String obtenerTasasDeCambio() {

        String url = API_URL  + ACCESS_KEY + "/latest/USD";

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
