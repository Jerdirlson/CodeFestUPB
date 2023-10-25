package server;

import interfaces.SkeletonEstudiante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import database.Conection;
import entidades.Estudiante;

public class ServiceEstudiante extends UnicastRemoteObject implements SkeletonEstudiante{

    protected ServiceEstudiante() throws RemoteException {
        super();
    }

    @Override
    public Estudiante getEstudiante(String email, String contraseña) throws RemoteException {
        Estudiante estudiante = null;

        try {
            estudiante = Conection.getEstudianteWhitPassword(email, contraseña);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return estudiante;
    }
    
}
