package entidades.estructuras.colas;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CilaPriiory<T extends Serializable> implements Serializable {
    ColaPrioridadList[] arrayClasi;
    int cont ;
    private static final long serialVersionUID = 3621271727859909664L;

    public CilaPriiory(int n) {
        arrayClasi = new ColaPrioridadList[n];
        for (int i = 0; i < n; i++) {
            arrayClasi[i] = new ColaPrioridadList();
        }
        cont = 0;
    }

    public boolean addToCola(int indice, T objeto) {
        if ((indice >= 0) && (indice < arrayClasi.length)) {
            cont++;
            return arrayClasi[indice].push(objeto);
        }
        return false;
    }


    public T popcola() {
        try {
            for (int i = arrayClasi.length-1; i >= 0 ; i--){
                if (!arrayClasi[i].isEmpty()){
                    return (T) arrayClasi[i].pop();
                }
            }
        }
        catch (Exception e){
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(),e);
        }
        return null;
    }

    @Override
    public String toString(){
        String text = "";

        for (int i = arrayClasi.length-1; i >= 0; i--){
            text += arrayClasi[i].print()+"\n";
        }

        return text;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < arrayClasi.length; i++) {
            size += arrayClasi[i].size();
        }
        return size;
    }
}
