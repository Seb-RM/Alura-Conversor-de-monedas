package com.aluraDesafio.conversorDeMonedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionRecord {

    private String monedaBase;
    private String monedaDestino;
    private double montoOriginal;
    private double montoConvertido;
    private LocalDateTime fechaHora;

    public ConversionRecord(String monedaBase, String monedaDestino, double montoOriginal, double montoConvertido) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.montoOriginal = montoOriginal;
        this.montoConvertido = montoConvertido;
        this.fechaHora = LocalDateTime.now();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public String getFechaHora() {
        // Formatear la fecha y hora de manera legible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaHora.format(formatter);
    }

    @Override
    public String toString() {
        return "Conversión: " + montoOriginal + " " + monedaBase + " a " + montoConvertido + " " + monedaDestino +
                " | Fecha y hora: " + getFechaHora();
    }
}
