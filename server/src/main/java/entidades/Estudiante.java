package entidades;

import java.io.Serializable;

    public class Estudiante implements Serializable {
    private int id ;
    private String nombre;
    private String apellido;
    private int semestre;

    private boolean discapacidad;

    // pendiente tiempo;
    private String password ;
    public Estudiante(){

    }

    public Estudiante(int id, String nombre, String apellido, int semestre, boolean discapacidad, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.discapacidad = discapacidad;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
