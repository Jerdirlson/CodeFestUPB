package entidades.estructuras.listas;


import entidades.estructuras.interfaces.LinkedListInterface;
import entidades.estructuras.interfaces.NodeInterface;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoubleLinkedList<T extends Serializable> implements LinkedListInterface<T>, Cloneable , Serializable {
    private static final long serialVersionUID = 1525693509033756841L;
    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private DoubleListNode<T> inode;
    private int size;

    public DoubleLinkedList() {
    }

    @Override
    public boolean add(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new DoubleListNode<T>(object);  //LAS ASIGNACIONES SE LEEN DE DERECHA A IZQUIERDA
                } else {                                         //Cola = Cabeza tiene una referencia a este objeto //Head apunta a DoubleListNode
                    tail.setNext(new DoubleListNode<T>(object));
                    tail.getNext().setPrev(tail);
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
        DoubleListNode nodeTemp;
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new DoubleListNode<>(object);
                }
                if (tail.equals(node)) {
                    tail.setNext(new DoubleListNode<>(object));
                    tail.getNext().setPrev(tail);
                    tail = tail.getNext();
                } else {
                    while (iterator.hasNext()) {
                        nodeTemp = (DoubleListNode) iterator.next();
                        if (nodeTemp.isEquals(node.getObject())) {

                            DoubleListNode nodeToAdd = new DoubleListNode<T>(object);

                            nodeToAdd.setNext(nodeTemp.getNext());    //El nodo a añadir señala al siguiente al temporal
                            nodeTemp.getNext().setPrev(nodeToAdd);
                            nodeTemp.setNext(nodeToAdd);
                            nodeToAdd.setPrev(nodeTemp);
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
        //add(node , next.getObject());
        Iterator iter = iterator();
        DoubleListNode nodeTemp;
        if (node != null && next != null) {
            tail.setNext((DoubleListNode<T>) next);
            tail.getNext().setPrev(tail);
            tail = tail.getNext();
        }
        try {
            while (iter.hasNext()) {
                nodeTemp = (DoubleListNode) iter.next();
                if (nodeTemp.isEquals(node.getObject())) {

                    DoubleListNode newNode = (DoubleListNode) next;

                    newNode.setNext(nodeTemp.getNext());
                    nodeTemp.getNext().setPrev(newNode);
                    nodeTemp.setNext(newNode);
                    newNode.setPrev(nodeTemp);
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
      /*  for (T object : objects) {
            add(object);
        }
       */

        Iterator iter = iterator();
        try {
            if (isEmpty()) {
                for (int i = 0; i < objects.length; i++) {
                    if (head == null) {
                        tail = head = new DoubleListNode<T>(objects[i]);
                        size++;
                    } else {
                        tail.setNext(new DoubleListNode<T>(objects[i]));
                        tail.getNext().setPrev(tail);
                        tail = tail.getNext();
                        size++;
                    }
                }
            } else {
                for (int i = 0; i < objects.length; i++) {
                    tail.setNext(new DoubleListNode<>(objects[i]));
                    tail.getNext().setPrev(tail);
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
        DoubleListNode nodeTemp;
        if (objects.length > 0) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            head = tail = new DoubleListNode<>(objects[i]);
                            size++;
                        }
                    }
                } else {
                    while (iter.hasNext()) {
                        nodeTemp = (DoubleListNode) iter.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            for (int i = 0; i < objects.length; i++) {

                                DoubleListNode newNode = new DoubleListNode<T>(objects[i]);

                                newNode.setNext(nodeTemp.getNext());
                                nodeTemp.getNext().setPrev(newNode);
                                nodeTemp.setNext(newNode);
                                newNode.setPrev(nodeTemp);
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
                    head = tail = new DoubleListNode<T>(object);
                } else {
                    DoubleListNode newNode = new DoubleListNode(object);

                    newNode.setNext(head);
                    head.setPrev(newNode);
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
                        head = tail = new DoubleListNode<T>(object);
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
    public DoubleLinkedList<T> cloneList() {
        try {
            if (!isEmpty()) {
                return (DoubleLinkedList<T>) this.clone();
            } else {
                return new DoubleLinkedList<>();
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public boolean contains(T object) {
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (object != null) {
                while (iter.hasNext()) {
                    DoubleListNode newNode = (DoubleListNode) iter.next();
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

    public boolean replace(int n, T obj) {
        if (!isEmpty()) {
            try {
                T getin = this.getInde(n);
                if (nodeOf(getin) == head) {
                    addOnHead(obj);
                    remove(nodeOf(getin));
                    return true;
                } else if (contains(getin)) {
                    DoubleListNode<T> node1 = (DoubleListNode<T>) nodeOf(getin);
                    DoubleListNode<T> nodePrev = getPreviousNode(node1);
                    DoubleListNode<T> newNode = new DoubleListNode<T>(obj);
                    add(nodePrev, newNode);
                    remove(node1);
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
                    DoubleListNode newNode = (DoubleListNode) iter.next();
                    if (newNode.isEquals(object)) {
                        return newNode;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return new DoubleListNode<>(null);
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
                    DoubleListNode<T> nodeArr = (DoubleListNode<T>) iter.next();
                    arrRetur[i] = nodeArr.getObject();
                }
            } else {
                throw new NoSuchElementException("Te pasaste de wey");
            }
        }

        return arrRetur;
    }

    public T getInde(int n) {
        Iterator iter = iterator();
        if (!isEmpty()) {
            if (size() >= n) {
                for (int i = 0; i < size(); i++) {
                    DoubleListNode<T> nodeArr = (DoubleListNode<T>) iter.next();
                    if (i == n) {
                        return nodeArr.getObject();
                    }
                }
            } else {
                throw new NoSuchElementException("Te pasaste de wey");
            }
        }
        return null;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        Iterator iter = iterator();
        T objReturn = null;
        try {
            if (!isEmpty()) {
                node = (NodeInterface<T>) nodeOf(node.getObject());
                return ((DoubleListNode<T>) node).getPrev().getObject();
            }
        } catch (Exception ex) {
            objReturn = null;
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
        }
        return objReturn;
    }


    private DoubleListNode<T> getPreviousNode(NodeInterface<T> node) {
        DoubleListNode<T> nodeTemp = (DoubleListNode<T>) node;
        if (!isEmpty()) {
            return nodeTemp.getPrev();
        }
        return nodeTemp.getPrev();
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
        DoubleListNode<T> nodeTemp;
        Iterator iter = iteratorToBack();
        if (size() > n) {
            for (int i = 0; i < n; i++) {
                nodeTemp = (DoubleListNode<T>) iter.next();
                arrTail[i] = nodeTemp.getObject();
                nodeTemp.getNext();
            }
        }
        return arrTail;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            DoubleListNode<T> nodeTemp = head;
            head = head.getNext();
            if (head != null)
                head.setPrev(null);
            size--;
            return nodeTemp.getObject();
        }
        return null;
    }

    @Override
    public boolean remove(T object) {//impecable
        Iterator iter;
        DoubleListNode<T> nodeTemp = null;
        if (object != null && (!isEmpty()) && (contains(object))) {
            try {
                if (head.isEquals(object)) {
                    head = head.getNext();
                    head.setPrev(null);
                    size--;
                    return true;
                } else if (tail.isEquals(object)) {
                    T nodeFin = tail.getPrev().getObject();
                    tail = (DoubleListNode<T>) nodeOf(nodeFin);
                    tail.setNext(null);
                    size--;
                    return true;
                }
                DoubleListNode<T> nodeU;
                iter = iterator();
                while (iter.hasNext()) {
                    nodeU = nodeTemp;
                    nodeTemp = (DoubleListNode<T>) iter.next();
                    if (nodeTemp.isEquals(object)) {
                        nodeU.setNext(nodeTemp.getNext());
                        nodeTemp.getNext().setPrev(nodeU);
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
                DoubleListNode<T> nodeTemp;
                while (iter.hasNext()) {
                    nodeTemp = (DoubleListNode<T>) iter.next();
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
            DoubleListNode<T> ini;
            DoubleLinkedList subLista = new DoubleLinkedList();
            while (iter.hasNext()) {
                ini = (DoubleListNode<T>) iter.next();
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
        DoubleListNode<T> nodeTemp;
        if (from != null && to != null) {
            while (iter.hasNext()) {
                nodeTemp = (DoubleListNode<T>) iter.next();
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
        DoubleListNode nodo = head;
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

    public Iterator<NodeInterface<T>> iteratorToBack() {
        inode = tail;
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
                inode = inode.getPrev();
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

    public boolean reverse() {
        if(!isEmpty()) {
            Stack<T> stak = new Stack<>();
            while (!isEmpty()) {
                stak.push(pop());
            }
            while (!stak.isEmpty()) {
                add(stak.pop());
            }
            return true;
        }
        return false;
    }

    public void imprimir() {
        Iterator<NodeInterface<T>> iterator = iterator();
        for (int i = 0; i < size(); i++) {
            System.out.print(iterator.next().getObject() + ", ");
        }
    }
    public String print() {
        Iterator<NodeInterface<T>> iterator = iterator();
        String str = "";
        for (int i = 0; i < size(); i++) {
            str+= iterator.next().getObject()+  "; ";
        }
        return str;
    }

    public boolean invertir(int k) {
        if (k > 0 && !isEmpty()) {
            int tamaño = (size() / k);
            DoubleListNode<T> nodeIter;
            DoubleListNode<T> firstNode;
            DoubleListNode<T> kNode;
            DoubleListNode<T> prevNode;
            DoubleListNode<T> moveNode;
            DoubleListNode<T> nodeFor;
            DoubleListNode<T> nodeSis;
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
                    if (k == 2) {
                        prevNode = getPreviousNode(kNode);
                        moveNode = getPreviousNode(firstNode);
                        nodeSis = firstNode.getNext();
                        prevNode.setNext(firstNode);
                        firstNode.setNext(null);
                        moveNode.setNext(kNode);
                        kNode.setNext(firstNode);
                        tail = firstNode;
                    }
                    if (k > 2) {
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

