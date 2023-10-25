package controller;

import java.rmi.RemoteException;

import entidades.Estudiante;
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
                Estudiante estudianteTemp = modelOperaodr.getEstudiante(viewOperador.busquedaDeEstudiantes.getText());
                if (estudianteTemp.getNombre() != null) { // metodo para buscar cliente en la base de datos
                    viewOperador.estudiantesFounded.addAll("Nombre: "+estudianteTemp.getNombre(),"Apellido: "+ estudianteTemp.getApellido(),
                            "Semestre: "+String.valueOf(estudianteTemp.getSemestre()),"Discapacidad: "+ estudianteTemp.getDiscapacidad(), 
                            "Password: "+estudianteTemp.getPassword());
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

                            viewAgregarEstudiante.confirmAddButton.setOnAction(actionEvent -> { // nomb , apelli , smes
                                                                                                // , discpa ,pass ,
                                                                                                // wmail
                                Estudiante estudiante = new Estudiante();
                                estudiante.setNombre(viewAgregarEstudiante.nombreEstudiante.getText());
                                estudiante.setApellido(viewAgregarEstudiante.apellidoEstudiante.getText());
                                estudiante.setSemestre(
                                        Integer.valueOf(viewAgregarEstudiante.semestreEstudiante.getValue()));
                                estudiante.setDiscapacidad(
                                        Boolean.valueOf(viewAgregarEstudiante.discapacidadEstudiante.getValue()));
                                estudiante.setPassword(viewAgregarEstudiante.passwordEstudiante.getText());
                                estudiante.setEmailEstudiante(viewAgregarEstudiante.emailEstudiante.getText());

                                try {
                                    if (modelOperaodr.addEstudiante(estudiante)) {
                                        // metodo para insertar estudiante
                                        Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
                                        confirmAlert.setTitle("WOw!");
                                        confirmAlert.setHeaderText("Estudiante Agregado ");
                                        confirmAlert.setContentText(
                                                "Felicidades al nuevo estudiante!" + "\n"
                                                        + "CAC-UPB...");
                                        confirmAlert.showAndWait();
                                        viewAgregarEstudiante.window.close();
                                    } else {
                                        Alert erroAlert = new Alert(Alert.AlertType.INFORMATION);
                                        erroAlert.setTitle("NOOOO!");
                                        erroAlert.setHeaderText("Estudiante NO Agregado ");
                                        erroAlert.setContentText(
                                                "Revisa todo los campos del nuevo estudiante!" + "\n"
                                                        + "CAC-UPB...");
                                        erroAlert.showAndWait();

                                    }
                                } catch (RemoteException e) {
                                    System.out.println("Errorr");
                                }

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
