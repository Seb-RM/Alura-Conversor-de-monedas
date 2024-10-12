package com.aluraDesafio.conversorDeMonedas.modelos;

import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {

    private List<ConversionRecord> historial;

    public ConversionHistory() {
        this.historial = new ArrayList<>();
    }

    // agregar una conversión al historial
    public void agregarConversion(ConversionRecord conversion) {
        historial.add(conversion);
    }

    // mostrar el historial de conversiones
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("No se han realizado conversiones aún.");
            System.out.println("=".repeat(40));
        } else {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Historial de conversiones:");
            for (ConversionRecord record : historial) {
                System.out.println(record);
            }
            System.out.println("=".repeat(40));
        }
    }

    // limpiar el historial de conversiones
    public void limpiarHistorial() {
        historial.clear();
        System.out.println("\n" + "*".repeat(40));
        System.out.println("Historial de conversiones eliminado.");
        System.out.println("*".repeat(40));
    }
}
