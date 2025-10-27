package org.example.funcionalidad_parking_u.dao;

import org.example.funcionalidad_parking_u.DatabaseUtil;
import org.example.funcionalidad_parking_u.dto.ClienteDTO;
import java.sql.*;

public class ClienteDAO {
    // Implementación para "Registrarse en el sistema" [cite: 104]
    public boolean registrarCliente(ClienteDTO cliente) throws SQLException {
        // La consulta SQL coincide con la justificación del proyecto [cite: 118]
        String sql = "INSERT INTO CLIENTE (Nombre, Apellido, Correo, Telefono, ID_Tipo_Usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setInt(5, cliente.getIdTipoUsuario());

            return stmt.executeUpdate() > 0;
        }
    }

    // Método de ejemplo para buscar un cliente
    public ClienteDTO buscarClientePorId(int id) throws SQLException {
        String sql = "SELECT * FROM CLIENTE WHERE ID_Usuario = ?";
        // Implementación con try-with-resources para obtener el ClienteDTO
        // ...
        return null;
    }
}