package org.example.funcionalidad_parking_u.dto;

public class VerificacionDTO {
    private String nombreCompleto;
    private String placa;
    private String codigoQR;
    private String tipoCliente;
    private String estadoQR;


    public VerificacionDTO(String nombreCompleto, String placa, String codigoQR, String tipoCliente, String estadoQR) {
        this.nombreCompleto = nombreCompleto;
        this.placa = placa;
        this.codigoQR = codigoQR;
        this.tipoCliente = tipoCliente;
        this.estadoQR = estadoQR;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getEstadoQR() {
        return estadoQR;
    }
}