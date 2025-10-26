package org.example.funcionalidad_parking_u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil { // <--- ¡Corregido!

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/parqueadero_uniajc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "valencia";

    // Método para obtener conexión
    public static Connection getConnection() {
        try {
            // Cargar driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver MySQL. Revisa el pom.xml", e);
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos: " + e.getMessage());
            throw new RuntimeException("No se pudo establecer la conexión con la base de datos.", e);
        }
    }

    // Cierre seguro de conexión
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("⚠️ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}