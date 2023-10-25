package app;

import controller.StartController;
import javafx.application.Application;
import javafx.stage.Stage;
import client.Client;/**
 * Main Class for 'Modulo Operador'
 *
 * Runs the program
 *
 * @author Juan David Patiño
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            String IP = ConfigLoader.getProperty("IP");
            String PORT = ConfigLoader.getProperty("PORT_OPERARIO");
            String SERVICENAMEOPERARIO = ConfigLoader.getProperty("SERVICENAMEOPERARIO");

            Client client = new Client(IP,PORT,SERVICENAMEOPERARIO);
            System.out.println("El cliente esta conectado? " + client.isConnected());

            //Ahora sigue el controller del login para que haga todas las conexiones

            StartController init = new StartController();
        } catch (Exception e) {
            System.out.println("Error en la conexion con el cliente" + e.getMessage());
        }


    }
    public static void main(String[] args) {
        launch(args);
    }
}