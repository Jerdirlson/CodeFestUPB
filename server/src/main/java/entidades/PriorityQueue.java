package entidades;

import entidades.estructuras.colas.CilaPriiory;

public class PriorityQueue {
    /**
     * Cola de prioridad de estudiantes que se registran al llegrr. 
     * esta tiene 4 prioridades siendo la mayor prioridad:  si es discapacidatdo y de primer semestre
     * la siguiente prioridad es si es discapacitado , 
     * la 3 era prioridad si el estudiate es de primer semestre. 
     * Y por ultima  prioridad si el estudiante no es discapacittado o de primer semestre.  
     */
    public static CilaPriiory<Estudiante> colaPriority = new CilaPriiory(4);
    static {

    }
/**
 * Metodo para añadir el estudiante a la cola , teniendo en cuenta las prioridades mencionadas en el comentario anterior.
 * @param estudiantee
 * @return
 */
    public static boolean addToCola(Estudiante estudiantee) {
        if (estudiantee.isDiscapacidad() && estudiantee.getSemestre() == 1) {
            colaPriority.addToCola(0, estudiantee);
            return true;
        } else if(estudiantee.isDiscapacidad()){
            colaPriority.addToCola(1, estudiantee);
        }
        else if (estudiantee.getSemestre() == 1) {
            colaPriority.addToCola(2, estudiantee);
            return true;
        } else if (!estudiantee.isDiscapacidad() && estudiantee.getSemestre() != 1) {
            colaPriority.addToCola(3, estudiantee);
            return true;
        }
        return false;
    }

    public static Estudiante popcola (){
        return colaPriority.popcola();
    } 

    public static CilaPriiory<Estudiante>  getCola (){
        return colaPriority;
    }

}
