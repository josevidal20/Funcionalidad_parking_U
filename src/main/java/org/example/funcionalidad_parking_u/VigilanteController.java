package org.example.funcionalidad_parking_u;

import javafx.event.ActionEvent;
import java.sql.Connection;

public class VigilanteController {
    // ... otros elementos @FXML si los tienes ...

    /**
     * Método vinculado al botón 'Registrar' en Scene Builder.
     * Su lógica es la de registrar un nuevo acceso o una salida.
     */
    public void handleRegistroAcceso(ActionEvent event) {
        // 1. Lógica para conectar y registrar el acceso
        Connection connection = null;
        try {
            // Obtener la conexión a la DB
            connection = DatabaseUtil.getConnection();
            System.out.println("✅ Conexión establecida para registrar el acceso.");

            // Aquí iría la lógica específica de la funcionalidad
            // Por ejemplo, si tienes un campo de texto para la placa:
            // String placa = txtPlaca.getText();
            // registrarEntrada(connection, placa);

        } catch (Exception e) {
            // Mostrar alerta de error en la interfaz
            System.err.println("Error durante el registro de acceso: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            DatabaseUtil.close(connection);
        }
    }
}