package sample;

import java.util.EmptyStackException;

public class StackLink<T> implements StackADT<T> {

    private int count;
    private Node<T> head;

    public StackLink() {
        count = 0;
        head = null;
    }
    @Override
    public void push(T element) {
        Node<T> node = new Node<T>(element);
        node.setNext(head);
        head = node;
        count++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T results = head.getElement();
        head = head.getNext();
        count--;
        return results;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T results = head.getElement();
        return results;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
