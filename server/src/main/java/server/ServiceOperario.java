package server;

import interfaces.SkeletonOperario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import database.Conection;

import entidades.Operario;

public class ServiceOperario extends UnicastRemoteObject implements SkeletonOperario{

    public ServiceOperario() throws RemoteException {
        
    }

    @Override
    public Operario login(String email, String password) {
        Operario user = null;

        try {
            user = Conection.getUser(email, password);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        return user;
    }
    
}
