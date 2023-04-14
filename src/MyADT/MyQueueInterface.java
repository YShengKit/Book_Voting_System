package MyADT;

public interface MyQueueInterface<T> {
    int size();

    boolean isEmpty();

    boolean isFull();

    void enqueue(T value) throws Exception;

    T dequeue() throws Exception;

    T peek() throws Exception;

    void clear();

    boolean contains(T element);
}
