package org.example.funcionalidad_parking_u.dto;

import java.time.LocalDateTime;

public class QRDTO {
    private int idQR;
    private String codigo;
    private LocalDateTime fechaCreacion;
    private int idVehiculo;
    private int idEstadoQR; // Referencia a ESTADO_QR

    // Constructor, Getters y Setters
    public int getIdQR() { return idQR; }
    public void setIdQR(int idQR) { this.idQR = idQR; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    // ... añade el resto de campos (idVehiculo, idEstadoQR)
}
