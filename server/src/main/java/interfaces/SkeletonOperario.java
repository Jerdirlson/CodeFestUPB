package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Operario;

public interface SkeletonOperario extends Remote{
    
    public Operario login(String email, String password) throws RemoteException;

}
