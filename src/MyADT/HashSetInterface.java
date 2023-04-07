package MyADT;

public interface HashSetInterface<Object> {
    boolean add(Object e);

    boolean remove(Object e);

    void clear();

    boolean isEmpty();

    int size();

    boolean contains(Object e);

    String[] toArray();

    String toString();

}

