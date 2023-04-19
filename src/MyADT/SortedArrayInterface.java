package MyADT;

public interface SortedArrayInterface<T> {
    boolean add(T newData);
    void clear();
    boolean contains(T element);
    int getNumberOfEntries();
    boolean isEmpty();
    Integer[] getSortedArr();
    String toString();
    boolean isFull();
    boolean replace();
}
