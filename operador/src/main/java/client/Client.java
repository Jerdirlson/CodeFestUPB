package client;

import interfaces.SkeletonOperario;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import entidades.Estudiante;
import entidades.Operario;

public class Client implements SkeletonOperario {

    private SkeletonOperario service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public Client(String ip, String port, String serviceName) {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    public boolean isConnected() throws RemoteException {
        try {
            System.out.println(url);
            service = (SkeletonOperario) Naming.lookup(url);
            return true;
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Operario login(String email, String password) throws RemoteException {
        Operario user = new Operario();
        try {
            service = (SkeletonOperario) Naming.lookup(url);
            return service.login(email, password);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return user;
        }
    }

    @Override
    public Estudiante getEstudiante(String email) throws RemoteException {
        try {
            service = (SkeletonOperario) Naming.lookup(url);
            return service.getEstudiante(email);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addEstudiante(Estudiante estudiante) throws RemoteException {
        try {
            service = (SkeletonOperario) Naming.lookup(url);
            return service.addEstudiante(estudiante);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCita(int idEstudiante, int idTutor) throws RemoteException {
        try {
            service = (SkeletonOperario) Naming.lookup(url);
            return service.addCita(idEstudiante , idTutor);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}