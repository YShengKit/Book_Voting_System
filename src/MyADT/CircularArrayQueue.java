package MyADT;

public class CircularArrayQueue<T> {
//    private int size;
//    private int front;
//    private int rear;
//    private T[] data;
//
//    public myQueue(int capacity) {
//        size = 0;
//        front = 0;
//        rear = -1;
//        data = (T[]) new Object[capacity];
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public boolean isFull() {
//        return size == data.length;
//    }
//
//    public void enqueue(T value) throws Exception {
//        if (isFull()) {
//            throw new Exception("Queue is full");
//        }
//        rear = (rear + 1) % data.length;
//        data[rear] = value;
//        size++;
//    }
//
//    public T dequeue() throws Exception {
//        if (isEmpty()) {
//            throw new Exception("Queue is empty");
//        }
//        T value = data[front];
//        data[front] = null;
//        front = (front + 1) % data.length;
//        size--;
//        return value;
//    }
//
//    public T peek() throws Exception {
//        if (isEmpty()) {
//            throw new Exception("Queue is empty");
//        }
//        return data[front];
//    }
//
//    public void clear() {
//        size = 0;
//        front = 0;
//        rear = -1;
//        for (int i = 0; i < data.length; i++) {
//            data[i] = null;
//        }
//    }
}
