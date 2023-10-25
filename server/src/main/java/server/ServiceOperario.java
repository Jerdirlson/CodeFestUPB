package server;

import interfaces.SkeletonOperario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

import database.Conection;
import entidades.Estudiante;
import entidades.Operario;

public class ServiceOperario extends UnicastRemoteObject implements SkeletonOperario {

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
    public boolean addEstudiante(Estudiante estudiante) throws RemoteException {
        try {
            return Conection.insertarEstudiante(estudiante);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addCita(int idEstudiante, int idTutor) throws RemoteException {
        try {
            return Conection.insertarCita(idEstudiante, idTutor);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

}
