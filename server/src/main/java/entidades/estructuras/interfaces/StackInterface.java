package entidades.estructuras.interfaces;

import java.io.Serializable;

public interface StackInterface<T extends Serializable>  {
    public boolean clear();

    public boolean isEmpty();

    public T peek();

    public T pop();

    public boolean push(T object);

    public int size();

    public boolean search(T object);

    public boolean sort();

    public boolean reverse();

    public String toString();
}
