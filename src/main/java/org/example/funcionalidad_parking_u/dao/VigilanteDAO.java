package org.example.funcionalidad_parking_u.dao;

import org.example.funcionalidad_parking_u.DatabaseUtil;
import org.example.funcionalidad_parking_u.dto.VerificacionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VigilanteDAO {

    /**
     * Consulta la información del usuario y vehículo por PLACA o CÓDIGO QR.
     * @param identificador Placa o Código QR ingresado por el vigilante.
     * @return VerificacionDTO con los datos del usuario, o null si no se encuentra.
     */
    public VerificacionDTO verificarUsuario(String identificador) {
        VerificacionDTO resultado = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        String sql = "SELECT c.Nombre, c.Apellido, v.Placa, q.Codigo, tc.TipoCliente, eqr.Estado AS Estado_QR " +
                "FROM QR q " +
                "JOIN VEHICULO v ON q.ID_Vehiculo = v.ID_Vehiculo " +
                "JOIN CLIENTE c ON v.ID_Usuario = c.ID_Usuario " +
                "JOIN ESTADO_QR eqr ON q.ID_Estado_QR = eqr.ID_Estado_QR " +
                "JOIN TIPO_CLIENTE tc ON c.ID_Tipo_Usuario = tc.ID_Tipo_Usuario " +
                "WHERE v.Placa = ? OR q.Codigo = ?";

        try {
            conn = DatabaseUtil.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, identificador);
            stmt.setString(2, identificador);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nombreCompleto = rs.getString("Nombre") + " " + rs.getString("Apellido");
                String placa = rs.getString("Placa");
                String codigoQR = rs.getString("Codigo");
                String tipoCliente = rs.getString("TipoCliente");
                String estadoQR = rs.getString("Estado_QR");

                resultado = new VerificacionDTO(nombreCompleto, placa, codigoQR, tipoCliente, estadoQR);
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta de verificación: " + e.getMessage());
        } finally {

            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignorar */ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* Ignorar */ }
            DatabaseUtil.close(conn);
        }
        return resultado;
    }
}
