package sample;

/**
 * A queue class that uses a linked list as it's underlying
 * data structure to perform it's operations.
 *
 * @param <T> QueueLink can accept any type of object
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private Node<T> head, tail;

    public LinkedQueue() {
        count = 0;
        head = null;
        tail = null;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of the queue
     */
    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<>(element);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        count++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of the queue
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty()) {
            tail = null;
        }
        return result;
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in the queue
     */
    @Override
    public T first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue");
        }

        return head.getElement();
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of the queue
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
