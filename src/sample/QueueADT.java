package sample;

public interface QueueADT<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    boolean isEmpty();
    int size();
}
