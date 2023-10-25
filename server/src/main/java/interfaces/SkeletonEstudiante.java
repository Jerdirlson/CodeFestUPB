package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Estudiante;

public interface SkeletonEstudiante extends Remote{
    
    public Estudiante getEstudiante(String email, String contraseña) throws RemoteException;
    
}
