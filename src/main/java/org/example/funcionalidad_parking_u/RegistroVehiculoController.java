package org.example.funcionalidad_parking_u;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.funcionalidad_parking_u.dao.VehiculoDAO;
import org.example.funcionalidad_parking_u.dto.VehiculoDTO; // Necesitas crear este DTO si no existe

public class RegistroVehiculoController {

    @FXML private TextField txtPlaca;
    @FXML private TextField txtTipo;
    // Debes añadir un ComboBox o similar para seleccionar el Tipo de Vehículo [cite: 118]

    private final VehiculoDAO vehiculoDAO = new VehiculoDAO();

    @FXML
    private void registrarVehiculo() {
        String placa = txtPlaca.getText();
        String tipo = txtTipo.getText();

        // Asume que el ID de usuario ya está disponible (ej. por sesión)
        int idUsuarioSesion = 1;

        // 1. Crear el DTO y asignar valores (Necesitas el VehiculoDTO)
        // VehiculoDTO vehiculo = new VehiculoDTO();
        // vehiculo.setPlaca(placa);
        // ...

        // 2. Llamar al DAO para registrar [cite: 118]
        // try {
        //     vehiculoDAO.registrarVehiculo(vehiculo);
        //     // Mostrar mensaje de éxito
        // } catch (Exception e) {
        //     // Mostrar mensaje de error
        // }
    }
}
