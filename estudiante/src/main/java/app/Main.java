package app;

import controller.StartController;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Main Class for 'Modulo Estudiante'
 *
 * Runs the program
 *
 * @author Juan David Patiño
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StartController init = new StartController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}