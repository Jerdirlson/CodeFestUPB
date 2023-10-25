package server;

import interfaces.SkeletonEstudiante;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceEstudiante extends UnicastRemoteObject implements SkeletonEstudiante{

    protected ServiceEstudiante() throws RemoteException {
        super();
    }
    
}
