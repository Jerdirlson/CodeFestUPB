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

    @Override
    public boolean insertarCita(int idEstudiante, int idTutor) throws RemoteException {
        boolean bool = false;
        try {
            bool = Conection.insertarCita(idEstudiante, idTutor);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return bool;
    }

    @Override
    public boolean cancelarCita(int idEstudiante) throws RemoteException {
        boolean bool = false;
        try {
            bool = Conection.cancelarCita(idEstudiante);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return bool;
    }

    @Override
    public boolean insertarEstudiante(Estudiante estudiante) throws RemoteException {
        boolean bool = false;
        try {
            bool = Conection.insertarEstudiante(estudiante);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return bool;
    }

    
    
}
