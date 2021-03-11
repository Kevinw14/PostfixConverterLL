package sample;

import java.util.EmptyStackException;

/**
 * A stack class that uses a linked list as it's underlying
 * data structure to perform it's operations.
 *
 * @param <T> StackLink can accept any type of object
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private Node<T> head;

    public LinkedStack() {
        count = 0;
        head = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        Node<T> node = new Node<>(element);
        node.setNext(head);
        head = node;
        count++;
    }

    /**
     * Removes and returns the top element from this stack.
     *
     * @return the element removed from the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T results = head.getElement();
        head = head.getNext();
        count--;
        return results;
    }

    /**
     * Returns without removing the top element of this stack.
     *
     * @return the element on top of the stack
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return head.getElement();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return count;
    }

    public void print() {
        for (Node ptr = head; ptr != null; ptr = ptr.getNext()) {
            System.out.println(ptr.getElement());
        }
    }
}
