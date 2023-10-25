package entidades;

import java.io.Serializable;

public class Tutor implements Serializable{
    private int id;
    private String nombre;
    private String apellido;
    private boolean cancelar;
    private int banco;
    public Tutor(){

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
    public boolean isCancelar() {
        return cancelar;
    }
    public void setCancelar(boolean cancelar) {
        this.cancelar = cancelar;
    }
    public int getBanco() {
        return banco;
    }
    public void setBanco(int banco) {
        this.banco = banco;
    }

}
