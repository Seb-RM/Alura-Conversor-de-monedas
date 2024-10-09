package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;

public class Principal {

    public static void main(String[] args) {

        ApiClient apiClient = new ApiClient();

        String resultado = apiClient.obtenerTasasDeCambio();

        if (resultado != null) {
            System.out.println("Datos de la API: " + resultado);
        } else {
            System.out.println("Error al obtener los datos de la API.");
        }
    }
}
