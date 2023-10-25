package entidades.estructuras.colas;





import java.io.Serializable;

import entidades.estructuras.interfaces.StackInterface;
import entidades.estructuras.pilas.Stack;
import entidades.estructuras.pilas.StackArray;

public class ColaDoble<T extends Serializable> implements StackInterface<T>, Serializable {

    private T[] arryCola;
    private int size;
    private int head;
    private int tail;

    public ColaDoble(int tamArr) {
        arryCola = (T[]) new Object[tamArr];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public boolean clear() {
        arryCola = (T[]) new Object[0];
        size = 0;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return arryCola[head];
        }
        return null;
    }


    @Override
    public T pop() {
        if (!isEmpty()) {
            T pop = arryCola[head];
            arryCola[head] = null;
            head += 1;
            size--;
            if (head == arryCola.length) {
                head = 0;
            }
            return pop;
        }
        return null;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean push(T object) {
        if (size <= arryCola.length) {
            arryCola[tail] = (T) object;
            tail++;
            if (tail >= arryCola.length) {
                tail = 0;
            }
            size++;
            return true;
        }
        return false;
    }

    public T popIzq() {
        if (!isEmpty()) {
            T pop = arryCola[tail];
            arryCola[tail] = null;
            head += 1;
            size--;
            if (tail == arryCola.length) {
                tail = 0;
            }
            return pop;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean search(T object) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (arryCola[i].equals(object)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean sort() {
        if (!isEmpty()) {
            StackArray<T> stack1 = new StackArray<>(size());
            StackArray<T> stack2 = new StackArray<>(size());
            int size = size();

            for (int i = 0; i < size; i++) {
                T current = pop();
                while ((!stack1.isEmpty()) && (current.toString().length() > stack1.peek().toString().length())) {
                    stack2.push(stack1.pop());
                }
                stack1.push(current);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            while (!stack1.isEmpty()) {
                push(stack1.pop());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean reverse() {
        if (!isEmpty()) {
            Stack<T> stak = new Stack<>();
            while (!isEmpty()) {
                stak.push(pop());
            }
            while (!stak.isEmpty()) {
                push(stak.pop());
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    public void print() {
        int posicion = head;
        for (int i = 0; i < size; i++) {
            System.out.println(arryCola[posicion]);
            posicion++;
            if (posicion == arryCola.length) {
                posicion = 0;
            }
        }
    }
}
