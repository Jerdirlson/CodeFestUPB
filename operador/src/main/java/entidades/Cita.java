package entidades;

import java.sql.Date;


public class Cita {
    private int idCita;
    private boolean cancelar;
    private Tutor tutor;
    private Estudiante estudiante;
    private Date fecha;
    public Cita(){

    }
    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    public boolean isCancelar() {
        return cancelar;
    }
    public void setCancelar(boolean cancelar) {
        this.cancelar = cancelar;
    }
    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
