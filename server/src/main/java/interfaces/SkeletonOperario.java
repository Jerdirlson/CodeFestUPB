package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Estudiante;
import entidades.Operario;

public interface SkeletonOperario extends Remote{
    
    public Operario login(String email, String password) throws RemoteException;

    public Estudiante getEstudiante(String email) throws RemoteException;

    public boolean addEstudiante(Estudiante estudiante) throws RemoteException; 

    public boolean addCita(int idEstudiante, int idTutor) throws RemoteException;
}