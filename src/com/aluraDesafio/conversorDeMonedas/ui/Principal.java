package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;
import com.aluraDesafio.conversorDeMonedas.api.ApiResponse;

public class Principal {

    public static void main(String[] args) {

        ApiClient apiClient = new ApiClient();

        double monto = 100.0;
        String monedaBase = "USD";
        String monedaDestino = "EUR";

        double resultado = apiClient.convertirMoneda(monedaBase, monedaDestino, monto);

        if (resultado > 0) {
            System.out.println(monto + " " + monedaBase + " son " + resultado + " " + monedaDestino);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }
}
