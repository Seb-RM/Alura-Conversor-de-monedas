package com.aluraDesafio.conversorDeMonedas.ui;

import com.aluraDesafio.conversorDeMonedas.api.ApiClient;

import java.util.Scanner;

public class CurrencyConverterApp {

    private ApiClient apiClient;

    public CurrencyConverterApp() {
        this.apiClient = new ApiClient();

    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            mostrarMenu();

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:// Convertir moneda
                    realizarConversion(scanner);
                    break;
                case 2:// Salir
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta nuevamente.");
                    break;
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("1. Convertir Moneda");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void realizarConversion(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Ingresa la moneda base (ejemplo: USD): ");
        String monedaBase = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa la moneda destino (ejemplo: EUR): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa el monto a convertir: ");
        double monto = scanner.nextDouble();

        double resultado = apiClient.convertirMoneda(monedaBase, monedaDestino, monto);

        if (resultado > 0) {
            System.out.println("Resultado: " + monto + " " + monedaBase + " son " + resultado + " " + monedaDestino);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }

}
