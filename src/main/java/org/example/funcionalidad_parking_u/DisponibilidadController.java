package org.example.funcionalidad_parking_u;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.funcionalidad_parking_u.dao.ParqueaderoDAO;
import java.sql.SQLException;

public class DisponibilidadController {

    @FXML private Label lblCuposDisponibles;

    private final ParqueaderoDAO parqueaderoDAO = new ParqueaderoDAO();

    @FXML
    public void initialize() {
        // Este método se llama automáticamente al cargar el FXML
        actualizarDisponibilidad();
    }

    @FXML
    private void actualizarDisponibilidad() {
        try {
            // Llama al método DAO para obtener los cupos disponibles [cite: 122]
            int disponibles = parqueaderoDAO.consultarBahiasDisponibles();
            lblCuposDisponibles.setText(String.valueOf(disponibles));
        } catch (SQLException e) {
            lblCuposDisponibles.setText("Error al consultar.");
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
}