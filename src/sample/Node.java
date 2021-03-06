package sample;

/**
 * A self-referential generic node class that accepts any type
 * of object and keeps track of the next node set to it.
 *
 * @param <T> Node can accept any type of object
 */
public class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getElement() {
        return element;
    }
}
