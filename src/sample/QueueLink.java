package sample;

public class QueueLink<T> implements QueueADT<T> {

    private int count;
    private Node<T> head, tail;

    public QueueLink() {
        count = 0;
        head = null;
        tail = null;
    }
    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<T>(element);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
//            throws new EmptyQueueException();
            System.out.println("Empty Queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty()) {
            tail = null;
        }
        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
//            throws new EmptyQueueException();
            System.out.println("Empty Queue");
        }

        T result = head.getElement();
        return result;
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
