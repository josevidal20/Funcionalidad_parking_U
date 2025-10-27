package org.example.funcionalidad_parking_u.dto;

import java.time.LocalDateTime;

public class AccesoDTO {
    private int idAcceso;
    private int idVehiculo;
    private int idBahia;
    private int idQR;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private int idEstadoAcceso; // Referencia a ESTADO_ACCESO

    // Constructor, Getters y Setters (similares a ClienteDTO, ajustando tipos de datos)
    public int getIdAcceso() { return idAcceso; }
    public void setIdAcceso(int idAcceso) { this.idAcceso = idAcceso; }
    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }
    public LocalDateTime getFechaHoraEntrada() { return fechaHoraEntrada; }
    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) { this.fechaHoraEntrada = fechaHoraEntrada; }
    // ... añade el resto de campos (idBahia, idQR, fechaHoraSalida, idEstadoAcceso)
}
