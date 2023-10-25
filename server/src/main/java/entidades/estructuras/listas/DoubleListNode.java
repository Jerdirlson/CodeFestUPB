package entidades.estructuras.listas;



import java.io.Serializable;

import entidades.estructuras.node.Node;

public class DoubleListNode<T extends Serializable> extends Node<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    DoubleListNode<T> next;
    DoubleListNode<T> prev;


    public DoubleListNode() {
        super();
        this.next = null;
        this.prev = null;
    }

    public DoubleListNode(T object) {
        super(object);
        this.next = null;
        this.prev = null;
    }

    public DoubleListNode(T object, DoubleListNode<T> next) {
        super(object);
        this.next = next;
        this.prev = null;
    }

    public DoubleListNode(T object, DoubleListNode<T> next, DoubleListNode<T> previus) {
        super(object);
        this.next = next;
        this.prev = previus;
    }

    public DoubleListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    public DoubleListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleListNode<T> prev) {
        this.prev = prev;
    }
}


