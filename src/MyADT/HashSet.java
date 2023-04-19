package MyADT;

public class HashSet<E> implements HashSetInterface<E> {

    private int size;
    private int capacity;
    private Node<E>[] table;

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public HashSet() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Node[DEFAULT_CAPACITY];
        //uses a hash table to store elements and provides constant-time performance for basic operations.
    }

    @Override
    public boolean add(E e) {
        if (contains(e)){
            return false;
        }
        else if((double) size / capacity >= LOAD_FACTOR){
            resize();
        }
        int index = hash(e);
        Node newNode = new Node(e);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        return true;
    }

    public int hash(E e){
        int hashCode = e.hashCode();
        return (hashCode & 0x7FFFFFFF) % capacity;
    }

    private void resize(){
        capacity *= 2;
        Node<E>[] oldTable = table;
        table = new Node[capacity];
        size = 0;

        for (Node<E> node : oldTable){
            while (node != null){
                int index = hash(node.value);
                Node<E> newNode = new Node<>(node.value);
                newNode.next = table[index];
                table[index] = newNode;
                node = node.next;
            }
        }
    }

    @Override
    public boolean remove(E e) {
        int index = hash(e);
        Node<E> node = table[index];
        Node<E> prev = null;

        while (node != null){
            if (node.value.equals(e)){
                if (prev == null){
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }

        return false;
    }

    @Override
    public void clear() {
        for (int i=0; i<capacity; i++){
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E e) {
        int index = hash(e);
        Node<E> node = table[index];

        while (node != null){
            if (node.value.equals(e)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    @Override
    //only return string type array
    public String[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<E> node : table) {
            while (node != null) {
                arr[i] = node.value;
                node = node.next;
                i++;
            }
        }
        String[] result = new String[size];
        for (i = 0; i < size; i++) {
            result[i] = (String) arr[i];
        }
        return result;
    }

    @Override
    //only return string type array
    public Integer[] toIntArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<E> node : table) {
            while (node != null) {
                arr[i] = node.value;
                node = node.next;
                i++;
            }
        }
        Integer[] result = new Integer[size];
        for (i = 0; i < size; i++) {
            result[i] = (Integer) arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int count = 0;
        for (Node<E> element : table) {
            if (element != null){
                sb.append(element.value);
                if (++count < size()) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }


}