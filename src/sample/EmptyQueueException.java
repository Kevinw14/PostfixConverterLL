package sample;

/**
 * An exception that is thrown when a operation is performed
 * on an empty queue.
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String collection) {
        super(collection + " is empty");
    }
}
