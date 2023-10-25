package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import model.ModelLogin;
import model.ModelOperador;
import view.ViewAgregarEstudiante;
import view.ViewLogin;
import view.ViewOperador;

public class OperadorController {
    public OperadorController() {
        ViewOperador viewOperador = new ViewOperador();
        ModelOperador modelOperaodr = new ModelOperador();
        // --

        viewOperador.addCitaButton.setOnAction(actionEvent -> {
            viewOperador.switchScene(viewOperador.buscarEstudianteView);
        });
        viewOperador.busquedaDeEstudiantes.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (false) { // metodo para buscar cliente en la base de datos
                    // Conseguir las citas del estudainte

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("WOw!");
                    alert.setHeaderText("Estudiante No encontrado ");
                    alert.setContentText(
                            "Registra al nuevo estudiante!" + "\n"
                                    + "CAC-UPB...");
                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            ViewAgregarEstudiante viewAgregarEstudiante = new ViewAgregarEstudiante();

                            viewAgregarEstudiante.confirmAddButton.setOnAction(actionEvent -> {
                                Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
                                confirmAlert.setTitle("WOw!");
                                confirmAlert.setHeaderText("Estudiante Agregado ");
                                confirmAlert.setContentText(
                                        "Felicidades al nuevo estudiante!" + "\n"
                                                + "CAC-UPB...");
                                viewAgregarEstudiante.window.close();

                            });
                        }
                    });
                    ;

                }

            }

        });

        viewOperador.goBackToOption.setOnAction(actionEvent -> {
            viewOperador.switchScene(viewOperador.optionPanel);
        });
    }

}
