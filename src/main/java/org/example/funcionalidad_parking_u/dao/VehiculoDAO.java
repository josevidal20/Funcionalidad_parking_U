package org.example.funcionalidad_parking_u.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDAO {

    // Función para buscar y verificar un vehículo/usuario por Placa o QR
    public void verificarUsuario(String identificador) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;

        // La consulta SQL que busca por Placa (la primera que definiste)
        sql = "SELECT c.Nombre, c.Apellido, v.Placa, q.Codigo AS Codigo_QR, tq.TipoCliente, eqr.Estado AS Estado_QR "
                + "FROM CLIENTE c "
                + "JOIN VEHICULO v ON c.ID_Usuario = v.ID_Usuario "
                + "JOIN QR q ON v.ID_Vehiculo = q.ID_Vehiculo "
                + "JOIN TIPO_CLIENTE tq ON tq.ID_Tipo_Usuario = c.ID_Tipo_Usuario " // Corregido ID_Usuario por ID_Tipo_Usuario
                + "JOIN ESTADO_QR eqr ON eqr.ID_Estado_QR = q.ID_Estado_QR " // Corregido ID_QR por ID_Estado_QR
                + "WHERE v.Placa = ? OR q.Codigo = ?";

        try {
            connection = DatabaseUtil.getConnection();
            ps = connection.prepareStatement(sql);

            // Asume que 'identificador' puede ser una Placa o un Código QR
            ps.setString(1, identificador);
            ps.setString(2, identificador);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Si se encuentra el registro
                String nombre = rs.getString("Nombre");
                String estadoQR = rs.getString("Estado_QR");
                System.out.println("✅ Usuario encontrado:");
                System.out.println("Nombre: " + nombre + ", Placa: " + rs.getString("Placa") + ", Rol: " + rs.getString("TipoCliente"));

                if (estadoQR.equals("Activo")) {
                    System.out.println("✅ ACCESO AUTORIZADO (QR Activo)");
                } else {
                    System.out.println("❌ ACCESO NO AUTORIZADO (QR: " + estadoQR + ")");
                }
            } else {
                // Si no se encuentra
                System.out.println("❌ Usuario/Vehículo NO REGISTRADO o no válido: " + identificador);
            }
        } finally {
            // Cerrar recursos en orden inverso
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            DatabaseUtil.close(connection);
        }
    }
}
