package com.aluraDesafio.conversorDeMonedas.api;

import com.google.gson.Gson;

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

    public ApiResponse obtenerTasaDeConversion(String monedaBase, String monedaDestino) {

        String url = API_URL + apiKey + "/pair/" + monedaBase + "/" + monedaDestino;;

        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ApiResponse conversionResponse = gson.fromJson(response.body(), ApiResponse.class);
                return conversionResponse;
            } else {
                System.out.println("Error en la solicitud, estado: " + response.statusCode());
            }
        } catch(Exception e) {
            System.out.println("Error al conectar a la API: " + e.getMessage());
        }

        return null;
    }

    public double convertirMoneda(String monedaBase, String monedaDestino, double monto) {

        ApiResponse response = obtenerTasaDeConversion(monedaBase, monedaDestino);

        if (response != null && "success".equals(response.getResult())) {

            double tasaDeConversion = response.getConversionRate();
            return monto * tasaDeConversion;
        } else {
            System.out.println("No se pudo obtener la tasa de conversión.");
        }

        return 0.0; // Valor retornado en caso de error
    }
}
