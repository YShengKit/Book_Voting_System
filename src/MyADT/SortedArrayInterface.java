package MyADT;

/**
 * SortedArrayInterface.java An interface for the ADT list. Entries in the list have
 * positions that begin with 1.
 *
 * @author Too Chin Xian
 * @version 2.0
 */
public interface SortedArrayInterface<T> {
    /**
     * Task: Adds a new entry to the sorted list in its proper order.
     * position within the array. The array's size is increased by 1
     *
     *
     * @param newData the object to be added as a new entry
     * @return true if the addition is successful
     */
    boolean add(T newData);
    /**
     * Task: Removes a specified entry from the sorted array.
     *
     * @param element the object to be removed
     * @return true if anEntry was located and removed
     */
    boolean remove(T element);
    /**
     * Task: Removes all entries from the array.
     */
    void clear();
    /**
     * Task: checks whether the array contains a given entry.
     *
     * @param element the object that is the desired entry
     * @return true if the array contains element, or false if not
     */
    boolean contains(T element);
    /**
     * Task: Gets the number of entries in the array.
     *
     * @return the integer number of entries currently in the array
     */
    int getNumberOfEntries();
    /**
     * Task: Sees whether the array is empty.
     *
     * @return true if the list is empty, or false if not
     */
    boolean isEmpty();
    /**
     * Task: To retrieve the array with elements being sorted.
     *
     * @return the list of sorted array
     */
    Integer[] getSortedArr();

    String toString();
    /**
     * Task: Sees whether the list is full.
     *
     * @return true if the list is full, or false if not
     */
    boolean isFull();
    /**
     * Task: Replaces the entry at a given position in the list.
     * @return true if the replacement occurs, or false if either the array is
     * empty, givenPosition < 1, or givenPosition > getNumberOfEntries()
     */
    boolean replace();
}