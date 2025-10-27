package org.example.funcionalidad_parking_u.dto;

public class ClienteDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private int idTipoUsuario; // Referencia a TIPO_CLIENTE

    // Constructor vacío
    public ClienteDTO() {}

    // Constructor completo (Opcional)
    // public ClienteDTO(int idUsuario, String nombre, ...) { ... }

    // Getters
    public int getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public int getIdTipoUsuario() { return idTipoUsuario; }

    // Setters
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setIdTipoUsuario(int idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }
}