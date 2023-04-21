package MyADT;

/**
 * SortedArrayList - Implements the ADT Sorted List using an array.
 *
 * @author Too Chin Xian
 * */

public class SortedArray<T extends Comparable<T>> implements SortedArrayInterface<T> {

    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 30;

    public SortedArray() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArray(int capacity) {
        size = 0;
        array = (T[]) new Comparable[capacity];
    }

    // add newData into the array
    public boolean add(T newData) {
        int i = 0;
        while (i < size && newData.compareTo(array[i]) < 0) {
            i++;
        }
        makeRoom(i + 1);
        array[i] = newData;
        size++;
        return true;
    }

    // Remove all entries from the array
    public void clear() {
        size = 0;
    }

    // Check whether specified entry is in the array
    public boolean contains(T element) {
        boolean found = false;
        for (int index = 0; !found && (index < size); index++) {
            if (element.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    // Check size of the array
    public int getNumberOfEntries() {
        return size;
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }


    // Use to get list of sorted array
    public Integer[] getSortedArr(){
        Object[] arr = new Object[size];
        for (int i = 0; i < size; ++i) {
            arr[i]= array[i];
        }
        Integer[] result = new Integer[size];
        for (int i=0; i<size; i++){
            result[i] = (Integer) arr[i];
        }
        return result;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < size; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }


    //check to see if the array is Full
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean replace() {
        return false;
    }

    private void doubleArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = size - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    // remove element from array
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                removeGap(i + 1);
                size--;
                return true;
            }
        }
        return false;
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = size - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
        array[lastIndex] = null;
    }

    // Replace existing element with newData
    public boolean replace(T oldData, T newData) {
        boolean found = false;
        int i = 0;
        while (!found && i < size) {
            int comparison = oldData.compareTo(array[i]);
            if (comparison == 0) {
                found = true;
            } else if (comparison < 0) {
                // oldEntry is less than array[i], so it is not in the array
                return false;
            } else {
                i++;
            }
        }
        if (found) {
            array[i] = newData;
            return true;
        } else {
            return false;
        }
    }
}