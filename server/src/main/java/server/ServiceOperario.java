package server;

import interfaces.SkeletonOperario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import database.Conection;
import entidades.Estudiante;
import entidades.Operario;

public class ServiceOperario extends UnicastRemoteObject implements SkeletonOperario{

    public ServiceOperario() throws RemoteException {
        
    }

    @Override
    public Operario login(String email, String password) {
        Operario user = null;

        try {
            user = Conection.getOperario(email, password);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return user;
    }

    @Override
    public Estudiante getEstudiante(String email) throws RemoteException {
        Estudiante estudiante = null;

        try {
            estudiante = Conection.getEstudiante(email);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return estudiante;
    }
    
}
