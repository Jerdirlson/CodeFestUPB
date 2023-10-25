package app;

import controller.ControllerLogin;
import javafx.application.Application;
import javafx.stage.Stage;
import server.Server;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        try {
            String IP_OPERARIO = ConfigLoader.getProperty("IP");
            String PORT_OPERARIO = ConfigLoader.getProperty("PORT_OPERARIO");
            String SERVICENAMEOPERARIO = ConfigLoader.getProperty("SERVICENAMEOPERARIO");
            Server serverOperario = new Server( IP_OPERARIO,PORT_OPERARIO,SERVICENAMEOPERARIO);
            serverOperario.deployOperario();
            System.out.println("Servicio en linea de Operario");
            
            String IP_COCINA = ConfigLoader.getProperty("IP");
            String PORT_COCINA = ConfigLoader.getProperty("PORT_ESTUDIANTE");
            String SERVICENAMECOCINA = ConfigLoader.getProperty("SERVICENAMEESTUDIANTE");
            Server servercocina = new Server( IP_COCINA,PORT_COCINA,SERVICENAMECOCINA);
            servercocina.deployEstudiante();
            System.out.println("Servicio en linea de Estudiante");
                    
            ControllerLogin init = new ControllerLogin();
        } catch (Exception e) {
            System.out.println("Error al intentar conectar el servidor "+ e.getMessage());
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}