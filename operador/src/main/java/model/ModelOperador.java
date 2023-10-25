package model;

import java.rmi.RemoteException;

import app.ConfigLoader;
import client.Client;
import entidades.Estudiante;
import entidades.Operario;

public class ModelOperador {
    Client cliente;

    public ModelOperador() {
        String IP = ConfigLoader.getProperty("IP");
        String PORT = ConfigLoader.getProperty("PORT_OPERARIO");
        String SERVICENAMEOPERARIO = ConfigLoader.getProperty("SERVICENAMEOPERARIO");

        Operario operario = null;

        cliente = new Client(IP, PORT, SERVICENAMEOPERARIO);

    }

    public Estudiante getEstudiante(String email) {
        try {
            return cliente.getEstudiante(email);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
        return null;
    }
    public boolean addEstudiante(Estudiante estudiante) throws RemoteException {
        try {
            return cliente.addEstudiante(estudiante);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }
    public boolean addCita(int idEstudiante, int idTutor) throws RemoteException {
        try {
            return cliente.addCita(idEstudiante, idTutor);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

}
