package app;

import controller.StartController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StartController start = new StartController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}