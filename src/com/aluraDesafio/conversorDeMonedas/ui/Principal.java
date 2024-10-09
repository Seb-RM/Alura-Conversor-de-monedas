package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;
import com.aluraDesafio.conversorDeMonedas.api.ApiResponse;

public class Principal {

    public static void main(String[] args) {

        ApiClient apiClient = new ApiClient();

        String monedaBase = "EUR";
        String monedaDestino = "GBP";

        ApiResponse conversion = apiClient.obtenerTasaDeConversion(monedaBase, monedaDestino);

        if (conversion != null && "success".equals(conversion.getResult())) {
            System.out.println("Tasa de conversión de " + conversion.getBaseCode() + " a " + conversion.getTargetCode() + ": " + conversion.getConversionRate());
        } else {
            System.out.println("Error al obtener los datos de la API.");
        }
    }
}
