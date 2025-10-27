package org.example.funcionalidad_parking_u.dao;

import org.example.funcionalidad_parking_u.DatabaseUtil;
import java.sql.*;

public class ParqueaderoDAO {

    // Implementación para "Consultar disponibilidad de cupos" [cite: 122]
    public int consultarBahiasDisponibles() throws SQLException {
        // La consulta SQL coincide con la justificación del proyecto [cite: 126]
        String sql = "SELECT SUM(CASE WHEN eb.Estado = 'Disponible' THEN 1 ELSE 0 END) AS Bahias_Disponibles " +
                "FROM PARQUEADERO p JOIN BAHIA b ON p.ID_Parqueadero = b.ID_Parqueadero " +
                "JOIN ESTADO_BAHIA eb ON b.ID_Estado_Bahia = eb.ID_Estado_Bahia";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("Bahias_Disponibles");
            }
            return 0;
        }
    }
}