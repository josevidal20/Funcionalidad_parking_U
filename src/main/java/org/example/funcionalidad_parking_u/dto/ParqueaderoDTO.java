package org.example.funcionalidad_parking_u.dto;

public class ParqueaderoDTO {
    private int idParqueadero;
    private String nombre;
    private int capacidad;
    private String ubicacion;
    // Opcionalmente, puedes incluir campos de Bahía o crear un BahíaDTO

    // Constructor, Getters y Setters
    public int getIdParqueadero() { return idParqueadero; }
    public void setIdParqueadero(int idParqueadero) { this.idParqueadero = idParqueadero; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}
