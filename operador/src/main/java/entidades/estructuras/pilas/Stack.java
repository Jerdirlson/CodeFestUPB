package entidades.estructuras.pilas;

import java.io.Serializable;

import entidades.estructuras.listas.DoubleLinkedList;

public class Stack<T extends Serializable> implements entidades.estructuras.interfaces.StackInterface<T>, Serializable {
    DoubleLinkedList<T> listDouble = new DoubleLinkedList<>();

    @Override
    public boolean clear() {
        return listDouble.clear();
    }

    @Override
    public boolean isEmpty() {
        return listDouble.isEmpty();
    }

    @Override
    public T peek() {
        return listDouble.get();
    }

    @Override
    public T pop() {
        return listDouble.pop();
    }

    @Override
    public boolean push(T object) {
        return listDouble.addOnHead(object);
    }

    @Override
    public int size() {
        return listDouble.size();
    }

    @Override
    public boolean search(T object) {
        return listDouble.contains(object);
    }

    @Override
    public boolean sort() {
        if (!isEmpty()) {
            Stack<T> stack1 = new Stack<>();
            Stack<T> stack2 = new Stack<>();
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
        Stack<T> newStack = new Stack<>();
        while (!listDouble.isEmpty()) {
            newStack.push(pop());
        }
        listDouble = newStack.listDouble;
        return true;
    }

    public void print() {
        listDouble.imprimir();
    }
}
