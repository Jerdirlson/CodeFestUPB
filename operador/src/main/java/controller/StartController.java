package controller;

import javafx.scene.control.Alert;
import model.ModelLogin;
import view.ViewLogin;

public class StartController {
    public StartController() {
        ViewLogin login = new ViewLogin();
        ModelLogin model = new ModelLogin();
        login.submit.setOnAction(actionEvent -> {
            if (model.getAuthenticatedUser(login.usuario.getText(), login.password.getText()).getNombre() != null) {
                System.out.println("ESTA REGISTRADO");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Operador No encontrado ");
                alert.setContentText(
                        "Tienes que escribir un correo existente!" + "\n"
                                + "...");
                alert.showAndWait();
            }
        });
    }
}
