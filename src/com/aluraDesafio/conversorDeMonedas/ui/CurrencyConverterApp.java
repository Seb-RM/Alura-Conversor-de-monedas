package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;
import com.aluraDesafio.conversorDeMonedas.api.ApiResponse;
import com.aluraDesafio.conversorDeMonedas.modelos.ConversionHistory;
import com.aluraDesafio.conversorDeMonedas.modelos.ConversionRecord;

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
        monedasDisponibles.put(7, "ARS - Peso argentino");
        monedasDisponibles.put(8, "BRL - Real brasileño");
        monedasDisponibles.put(9, "CLP - Peso chileno");
        monedasDisponibles.put(10, "COP - Peso colombiano");
        monedasDisponibles.put(11, "MXN - Peso mexicano");
        monedasDisponibles.put(12, "PEN - Sol peruano");
    }

    private Scanner scanner = new Scanner(System.in);
    private static final ConversionHistory historial = new ConversionHistory();

    public void iniciar() {

        System.out.println("*".repeat(40));
        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println("*".repeat(40));

        boolean continuar = true;

        while (continuar) {

            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda();
                    break;
                case 2:
                    historial.mostrarHistorial();
                    break;
                case 3:
                    historial.limpiarHistorial();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\n" + "*".repeat(40));
                    System.out.println("* ¡Gracias por usar el Conversor de Monedas!");
                    System.out.println("* Esperamos que te haya servido.");
                    System.out.println("* ¡Hasta luego!");
                    System.out.println("*".repeat(40));
                    break;
                default:
                    System.out.println("*".repeat(40));
                    System.out.println("Opción no válida, intenta de nuevo.");
                    System.out.println("*".repeat(40));
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Seleccione una opción:");
        System.out.println("1. Convertir moneda");
        System.out.println("2. Ver historial de conversiones");
        System.out.println("3. Limpiar historial");
        System.out.println("4. Salir");
        System.out.println("=".repeat(40));
        System.out.print("Selecciona una opción: ");
    }

    private void convertirMoneda() {
        scanner.nextLine();
        String monedaBase = seleccionarMoneda("base", null);
        String monedaDestino = seleccionarMoneda("destino", monedaBase);

        System.out.print("\n¿Cuánto deseas convertir? ");
        System.out.println("\n" + "=".repeat(40));
        System.out.print("Ingresa el monto: ");
        double monto = scanner.nextDouble();

        ApiClient apiClient = new ApiClient();
        ApiResponse respuesta = apiClient.obtenerTasaDeConversion(monedaBase, monedaDestino);

        if (respuesta != null) {
            double tasa = respuesta.getConversionRate();
            double montoConvertido = monto * tasa;
            System.out.println("\n" + "*".repeat(40));
            System.out.println("* Resultado de la conversión:");
            System.out.printf("* %.2f %s equivalen a %.2f %s\n", monto, monedaBase, montoConvertido, monedaDestino);
            System.out.printf("* Tasa de conversión: 1 %s = %.4f %s%n", monedaBase, tasa, monedaDestino);
            System.out.println("*".repeat(40));

            ConversionRecord conversion = new ConversionRecord( monedaBase, monedaDestino, monto, montoConvertido );
            historial.agregarConversion(conversion);

        } else {
            System.out.println("\n" + "*".repeat(40));
            System.out.println("No se pudo obtener la tasa de conversión.");
            System.out.println("*".repeat(40));
        }
    }

    private String seleccionarMoneda(String tipo, String monedaExcluida) {
        System.out.println("\n" + "=".repeat(40));
        if (tipo.equals("base")) {
            System.out.println("* Elige la primera moneda (origen):");
        } else {
            System.out.println("* Elige la moneda a la que quieres convertir:");
        }

        for (Map.Entry<Integer, String> entry : monedasDisponibles.entrySet()) {
            String codigoMoneda = obtenerCodigoMoneda(entry.getKey());

            if (monedaExcluida == null || !codigoMoneda.equals(monedaExcluida)) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
        }
        System.out.println("=".repeat(40));
        System.out.print("\n* Ingresa el número de tu elección: ");
        int seleccion = scanner.nextInt();
        String monedaSeleccionada = obtenerCodigoMoneda(seleccion);

        if (monedaSeleccionada == null || monedaSeleccionada.equals(monedaExcluida)) {
            System.out.println("\n" + "*".repeat(40));
            System.out.println("Selección inválida, intenta de nuevo.");
            System.out.println("*".repeat(40));
            return seleccionarMoneda(tipo, monedaExcluida);
        }

        System.out.println("* Has seleccionado: " + monedaSeleccionada);
        System.out.println("=".repeat(40));
        return monedaSeleccionada;
    }

    private String obtenerCodigoMoneda(int seleccion) {
        String monedaInfo = monedasDisponibles.get(seleccion);
        if (monedaInfo != null) {

            return monedaInfo.split(" - ")[0];
        }
        return null;
    }
}
