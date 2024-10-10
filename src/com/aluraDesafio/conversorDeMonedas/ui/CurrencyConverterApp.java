package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;
import com.aluraDesafio.conversorDeMonedas.api.ApiResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterApp {

    private static final Map<Integer, String> monedasDisponibles = new HashMap<>();

    static {
        monedasDisponibles.put(1, "USD - Dólar estadounidense");
        monedasDisponibles.put(2, "EUR - Euro");
        monedasDisponibles.put(3, "GBP - Libra esterlina");
        monedasDisponibles.put(4, "JPY - Yen japonés");
        monedasDisponibles.put(5, "AUD - Dólar australiano");
        monedasDisponibles.put(6, "CAD - Dólar canadiense");
        // Puedes añadir más monedas aquí
    }

    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Bienvenido al conversor de monedas");
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                convertirMoneda();
            } else if (opcion == 2) {
                System.out.println("¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    private void convertirMoneda() {
        scanner.nextLine();
        String monedaBase = seleccionarMoneda("base", null);
        String monedaDestino = seleccionarMoneda("destino", monedaBase);

        System.out.print("Ingresa el monto a convertir: ");
        double monto = scanner.nextDouble();

        ApiClient apiClient = new ApiClient();
        ApiResponse respuesta = apiClient.obtenerTasaDeConversion(monedaBase, monedaDestino);

        if (respuesta != null) {
            double tasa = respuesta.getConversionRate();
            double montoConvertido = monto * tasa;
            System.out.printf("Monto convertido: %.2f %s\n", montoConvertido, monedaDestino);
        } else {
            System.out.println("No se pudo obtener la tasa de conversión.");
        }
    }

    private String seleccionarMoneda(String tipo, String monedaExcluida) {

        if (tipo.equals("base")) {
            System.out.println("Selecciona la primera moneda:");
        } else {
            System.out.println("Selecciona la moneda de destino:");
        }

        for (Map.Entry<Integer, String> entry : monedasDisponibles.entrySet()) {
            String codigoMoneda = obtenerCodigoMoneda(entry.getKey());

            if (monedaExcluida == null || !codigoMoneda.equals(monedaExcluida)) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
        }

        int seleccion = scanner.nextInt();
        String monedaSeleccionada = obtenerCodigoMoneda(seleccion);

        if (monedaSeleccionada == null || monedaSeleccionada.equals(monedaExcluida)) {
            System.out.println("Selección inválida, intenta de nuevo.");
            return seleccionarMoneda(tipo, monedaExcluida);
        }

        return monedaSeleccionada;
    }

    private String obtenerCodigoMoneda(int seleccion) {
        String monedaInfo = monedasDisponibles.get(seleccion);
        if (monedaInfo != null) {

            return monedaInfo.split(" - ")[0];
        }
        return null;
    }

    public static void main(String[] args) {
        CurrencyConverterApp app = new CurrencyConverterApp();
        app.iniciar();
    }

}
