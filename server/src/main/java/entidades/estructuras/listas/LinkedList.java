package entidades.estructuras.listas;



import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entidades.estructuras.interfaces.LinkedListInterface;
import entidades.estructuras.interfaces.NodeInterface;

public class LinkedList<T extends Serializable> implements LinkedListInterface<T>, Cloneable, Serializable {
    private SingleListNode<T> head;
    private SingleListNode<T> tail;
    private SingleListNode<T> inode;
    private int size;

    public LinkedList() {
    }

    @Override
    public boolean add(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);  //LAS ASIGNACIONES SE LEEN DE DERECHA A IZQUIERDA
                } else {                                             //Cola = Cabeza tiene una referencia a este objeto //Head apunta a SingleListNode
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                }
                size++;
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) {
        Iterator iterator = iterator();
        SingleListNode nodeTemp;
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SingleListNode<>(object);
                }
                if (tail.equals(node)) {
                    tail.setNext(new SingleListNode<>(object));
                    tail = tail.getNext();
                } else {
                    while (iterator.hasNext()) {
                        nodeTemp = (SingleListNode) iterator.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            SingleListNode nodeToAdd = new SingleListNode<>(object);
                            nodeToAdd.setNext(nodeTemp.getNext());    //El nodo a añadir señala al siguiente al temporal
                            nodeTemp.setNext(nodeToAdd);
                        }
                    }
                }
                size++;
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) {
        Iterator iter = iterator();
        SingleListNode nodeTemp;
        if (node != null && next != null) {
            tail.setNext((SingleListNode<T>) next);
            tail = tail.getNext();
        }
        try {
            while (iter.hasNext()) {
                nodeTemp = (SingleListNode) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    SingleListNode newNode = (SingleListNode) next;
                    newNode.setNext(nodeTemp.getNext());
                    nodeTemp.setNext(newNode);
                }
            }
            size++;
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {
        Iterator iter = iterator();
        try {
            if (isEmpty()) {
                for (int i = 0; i < objects.length; i++) {
                    if (head == null) {
                        tail = head = new SingleListNode<>(objects[i]);
                        size++;
                    } else {
                        tail.setNext(new SingleListNode<>(objects[i]));
                        tail = tail.getNext();
                        size++;
                    }
                }
            } else {
                for (int i = 0; i < objects.length; i++) {
                    tail.setNext(new SingleListNode<>(objects[i]));
                    tail = tail.getNext();
                    size++;
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        Iterator iter = iterator();
        SingleListNode nodeTemp;
        if (objects.length > 0) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            head = tail = new SingleListNode<>(objects[i]);
                            size++;
                        }
                    }
                } else {
                    while (iter.hasNext()) {
                        nodeTemp = (SingleListNode) iter.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            for (int i = 0; i < objects.length; i++) {
                                SingleListNode newNode = new SingleListNode<>(objects[i]);
                                newNode.setNext(nodeTemp.getNext());
                                nodeTemp.setNext(newNode);
                                size++;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    head = tail = new SingleListNode<>(object);
                } else {
                    SingleListNode newNode = new SingleListNode(object);
                    newNode.setNext(head);
                    head = newNode;
                }
                size++;
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects.length > 0) {
            try {
                if (isEmpty()) {
                    for (T object : objects) {
                        head = tail = new SingleListNode<>(object);
                        size++;
                    }
                } else {
                    for (T object : objects) {
                        addOnHead(object);
                    }
                    return true;
                }

            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        head = null;
        size = 0;
        return true;
    }

    @Override
    public LinkedList<T> cloneList() {
        try {
            if (!isEmpty()) {
                Iterator<NodeInterface<T>> iter = iterator();
                LinkedList<T> cloneNode = new LinkedList<>();
                while (iter.hasNext()) {
                    cloneNode.add(iter.next().getObject());
                }
                return cloneNode;
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public boolean contains(T object) {
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (object != null) {
                while (iter.hasNext()) {
                    SingleListNode newNode = (SingleListNode) iter.next();
                    if (newNode.isEquals(object)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        if (!isEmpty()) {
            try {
                int cont = 1;
                for (T object : objects) {
                    if (contains(object)) {
                        cont++;
                    }
                }
                if (cont == objects.length) {
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }


    @Override
    public NodeInterface<T> nodeOf(T object) {
        Iterator iter = iterator();
        if (object != null) {
            try {
                while (iter.hasNext()) {
                    SingleListNode newNode = (SingleListNode) iter.next();
                    if (newNode.isEquals(object)) {
                        return newNode;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return new SingleListNode<>(null);
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            return head.getObject();
        }
        return null;
    }

    @Override
    public T[] get(int n) {
        T[] arrRetur = (T[]) new Object[n];
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (size() >= n) {
                for (int i = 0; i < n; i++) {
                    SingleListNode<T> nodeArr = (SingleListNode<T>) iter.next();
                    arrRetur[i] = nodeArr.getObject();
                }
            } else {
                throw new NoSuchElementException("Te pasaste de wey");
            }
        }

        return arrRetur;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        Iterator iter = iterator();
        T objReturn = null;
        if (!isEmpty()) {
            SingleListNode<T> prevNode = null;
            SingleListNode<T> nodeTemp = null;
            while (iter.hasNext()) {
                prevNode = nodeTemp;    //NodeTemp = head     | nodePrev = null , porque anterior es cabeza
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    return prevNode.getObject();
                }
            }
            try {
                objReturn = prevNode.getObject();
            } catch (Exception ex) {
                objReturn = null;
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return objReturn;
    }

    private SingleListNode<T> getPreviousNode(NodeInterface<T> node) {
        Iterator iter = iterator();
        SingleListNode<T> prevNode = null;
        SingleListNode<T> nodeTemp = null;
        if (!isEmpty()) {
            while (iter.hasNext()) {
                prevNode = nodeTemp;    //NodeTemp = head     | nodePrev = null , porque anterior es cabeza
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {
                    return prevNode;
                }
            }
        }
        return prevNode;
    }

    @Override
    public T getFromEnd() {
        if (!isEmpty()) {
            return tail.getObject();
        }
        return null;
    }

    @Override
    public T[] getFromEnd(int n) {
        T[] arrTail = (T[]) new Object[n];
        SingleListNode<T> nodeTemp;
        nodeTemp = tail;
        if (size() > n) {
            for (int i = 0; i < n; i++) {
                arrTail[i] = nodeTemp.getObject();
                nodeTemp = new SingleListNode<>(getPrevious(nodeTemp));
            }
        }
        return arrTail;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            SingleListNode<T> nodeTemp = head;
            head = head.getNext();
            size--;
            return nodeTemp.getObject();
        }
        return null;
    }

    @Override
    public boolean remove(T object) {//impecable
        Iterator iter;
        SingleListNode<T> nodeTemp = null;
        if (object != null && (!isEmpty()) && (contains(object))) {
            try {
                if (head.isEquals(object)) {
                    head = head.getNext();
                    size--;
                    return true;
                } else if (tail.isEquals(object)) {
                    T nodeFin = getPrevious(new SingleListNode<>(object));
                    tail = (SingleListNode<T>) nodeOf(nodeFin);
                    tail.setNext(null);
                    size--;
                    return true;
                }
                SingleListNode<T> nodeU;
                iter = iterator();
                while (iter.hasNext()) {
                    nodeU = nodeTemp;
                    nodeTemp = (SingleListNode<T>) iter.next();
                    if (nodeTemp.isEquals(object)) {
                        nodeU.setNext(nodeTemp.getNext());
                        size--;
                        return true;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean remove(NodeInterface<T> node) {
        if (isEmpty()) {
            return false;
        } else {
            try {
                return remove(node.getObject());
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(T[] objects) {
        if (!isEmpty() && objects != null) {
            try {
                for (T objet : objects) {
                    if (objet != null) {
                        remove(objet);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    /*
        private boolean retain(T[] objects) {
            try {
                for (T objet : objects) {
                    if (objet != null) {
                        if (!contains(objet)) {
                            remove(objet);

                        }
                    }
                }
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
            return false;
        }


     */
    @Override
    public boolean retainAll(T[] objects) {
        if (objects != null && !isEmpty()) {
            try {
                int cont = 0;
                Iterator iter = iterator();
                T[] arrTemp = (T[]) new Object[objects.length];
                SingleListNode<T> nodeTemp;
                while (iter.hasNext()) {
                    nodeTemp = (SingleListNode<T>) iter.next();
                    for (int i = 0; i < objects.length; i++) {
                        if (nodeTemp.isEquals(objects[i])) {
                            arrTemp[cont] = nodeTemp.getObject();
                            cont++;
                        }
                    }
                }
                clear();
                add(arrTemp);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        if (validateSubList(from, to) && (!isEmpty())) {
            Iterator iter = iterator();
            SingleListNode<T> ini;
            LinkedList subLista = new LinkedList();
            while (iter.hasNext()) {
                ini = (SingleListNode<T>) iter.next();
                if (ini.isEquals(from.getObject())) {
                    subLista.add(ini.getObject());
                    ini = ini.getNext();
                    while (!ini.isEquals(to.getObject())) {
                        subLista.add(ini.getObject());
                        ini = ini.getNext();
                    }
                    subLista.add(ini.getObject());
                    return subLista;
                }
            }
            return subLista;
        } else {
            System.out.println("no entra");
        }
        return null;
    }

    private boolean validateSubList(NodeInterface<T> from, NodeInterface<T> to) {
        Iterator iter = iterator();
        SingleListNode<T> nodeTemp;
        if (from != null && to != null) {
            while (iter.hasNext()) {
                nodeTemp = (SingleListNode<T>) iter.next();
                if (nodeTemp.isEquals(from.getObject())) {
                    return true;
                } else if (nodeTemp.isEquals(to.getObject())) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        NodeInterface<T> nodo = head;
        T[] arreglo = (T[]) new Object[size];
        Iterator iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nodo = (NodeInterface<T>) iterator.next();
            arreglo[i++] = (T) nodo.getObject();
        }
        return arreglo;
    }
    /*@Override
    public T[] toArray() {
        T[] objectArr ;
        SingleListNode nodo = head;
        T[] arreglo = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            arreglo[i] = (T) nodo.getObject();
            nodo = nodo.getNext();
        }
        return arreglo;
    }*/

    @Override
    public boolean sortObjectsBySize() {
        if (!isEmpty()) {
            try {
                T[] arryLis = toArray();
                for (int gap = arryLis.length / 2; gap > 0; gap /= 2) {
                    for (int i = gap; i < arryLis.length; i++) {
                        T tempVal = arryLis[i];
                        int j = i;
                        while (j >= gap && arryLis[j - gap].toString().length() > tempVal.toString().length()) {
                            arryLis[j] = arryLis[j - gap];
                            j -= gap;
                        }
                        arryLis[j] = tempVal;
                    }
                }
                clear();
                add(arryLis);
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    @Override
    public Iterator<NodeInterface<T>> iterator() {
        inode = head;
        return new Iterator<NodeInterface<T>>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node;
            }
        };
    }

    public Iterator iteratorObj() {
        inode = head;
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node.getObject();
            }
        };
    }

    public String imprimir() {
        Iterator<NodeInterface<T>> iterator = iterator();
        String str = "";
        for (int i = 0; i < size(); i++) {
            str += iterator.next().getObject() + "\n";
        }
        return str;
    }

    public boolean invertir(int k) {
        if (k > 0 && !isEmpty()) {
            int tamaño = (size() / k);
            SingleListNode<T> nodeIter;
            SingleListNode<T> firstNode;
            SingleListNode<T> kNode;
            SingleListNode<T> prevNode;
            SingleListNode<T> moveNode;
            SingleListNode<T> nodeFor;
            SingleListNode<T> nodeSis;
            nodeIter = head;
            for (int i = 0; i < tamaño; i++) {
                firstNode = nodeIter;
                kNode = firstNode;
                for (int j = 1; j < k; j++) {
                    kNode = kNode.getNext();
                }
                if (size() == k) {
                    nodeFor = getPreviousNode(kNode);
                    moveNode = firstNode.getNext();
                    nodeFor.setNext(firstNode);
                    tail = firstNode;
                    head = kNode;
                    kNode.setNext(moveNode);
                    return true;
                }
                if (kNode.isEquals(tail.getObject())) {
                    if( k == 2) {
                        prevNode = getPreviousNode(kNode);
                        moveNode = getPreviousNode(firstNode);
                        nodeSis = firstNode.getNext();
                        prevNode.setNext(firstNode);
                        firstNode.setNext(null);
                        moveNode.setNext(kNode);
                        kNode.setNext(firstNode);
                        tail = firstNode;
                    }if (k > 2){
                        prevNode = getPreviousNode(kNode);
                        moveNode = getPreviousNode(firstNode);
                        nodeSis = firstNode.getNext();
                        prevNode.setNext(firstNode);
                        firstNode.setNext(null);
                        moveNode.setNext(kNode);
                        kNode.setNext(nodeSis);
                        tail = firstNode;
                    }
                }
                if (firstNode.isEquals(head.getObject())) {
                    if (k == 2) {
                        prevNode = firstNode.getNext();
                        moveNode = getPreviousNode(kNode);
                        moveNode.setNext(firstNode);
                        firstNode.setNext(kNode.getNext());
                        kNode.setNext(firstNode);
                        head = kNode;
                        nodeIter = firstNode.getNext();
                    }
                    if (k > 2) {
                        prevNode = firstNode.getNext();
                        moveNode = getPreviousNode(kNode);
                        moveNode.setNext(firstNode);
                        firstNode.setNext(kNode.getNext());
                        kNode.setNext(prevNode);
                        head = kNode;
                        nodeIter = firstNode.getNext();
                    }
                }
                if ((firstNode != head) && (kNode != tail) && (kNode != head) && (firstNode != tail)) {
                    if (k == 2) {
                        nodeFor = kNode.getNext();
                        prevNode = getPreviousNode(kNode);
                        moveNode = getPreviousNode(firstNode);
                        nodeSis = firstNode.getNext();
                        moveNode.setNext(kNode);
                        kNode.setNext(firstNode);
                        prevNode.setNext(firstNode);
                        firstNode.setNext(nodeFor);
                        nodeIter = firstNode.getNext();
                    }
                    if (k > 2) {
                        nodeFor = kNode.getNext();
                        prevNode = getPreviousNode(kNode);
                        moveNode = getPreviousNode(firstNode);
                        nodeSis = firstNode.getNext();
                        moveNode.setNext(kNode);
                        kNode.setNext(nodeSis);
                        prevNode.setNext(firstNode);
                        firstNode.setNext(nodeFor);
                        nodeIter = firstNode.getNext();
                    }
                }
            }
            return true;
        }

        return false;
    }
}

