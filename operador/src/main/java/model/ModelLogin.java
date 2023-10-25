package model;
//Aqui va la conexion a la base de datos 

import app.ConfigLoader;
import client.Client;
import controller.OperadorController;
import entidades.Operario;

/**
 * A class representing a model for the Login view.
 */
public class ModelLogin {

    public Operario operario = new Operario();

    /**
     * Retrieves the authenticated user based on the provided email and password.
     *
     * @param email    the email of the user
     * @param password the password of the user
     * @return the authenticated user
     */
    public static Operario getAuthenticatedUser(String email, String password) {

        String IP = ConfigLoader.getProperty("IP");
        String PORT = ConfigLoader.getProperty("PORT_OPERARIO");
        String SERVICENAMEOPERARIO = ConfigLoader.getProperty("SERVICENAMEOPERARIO");

        Operario operario = null;

        Client cliente = new Client(IP, PORT, SERVICENAMEOPERARIO);

        try {
            OperadorController operadorController = new OperadorController();

           // operario = cliente.login(email, password);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return operario;
    }

}