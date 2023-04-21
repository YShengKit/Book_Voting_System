package MyADT;
/**
 * HashSetInterface.java
 * An interface for the ADT HashSet.
 * It works like an array but no repeated entry in a HashSet
 *
 * @author Chai Kian Hun
 * @param <Object> specifies the datatype of the entry that HashSet store.
 */
public interface HashSetInterface<Object> {

    /**
     * Task: Adds an entry to the hashset.
     * new entry must not exist in HashSet, otherwise it won't add into HashSet.
     * The hashset's size increase by 1.
     *
     * @param e the object to be added as a new element
     * @return true if successful, false otherwise.
     */
    boolean add(Object e);

    /**
     * Task: Removes a specific entry from the hashset.
     * The hashset's size decreased by 1.
     *
     * @param e the object to be removed from the set
     * @return true if the removal is successful else false
     */

    boolean remove(Object e);

    /**
     * Task: Removes all entries from the hashset.
     */

    void clear();// Removes all entries from the set.

    /**
     * Task: Sees whether the hashset is empty.
     *
     * @return true if the list is empty, or false if not
     */

    boolean isEmpty();// Checks if the set is empty. Returns true if the set is empty, false otherwise.

    /**
     * Task: Get the number of entry inside Hashset.
     *
     * @return the number of entry inside Hashset.
     */
    int size(); // Returns the number of entries in the set.

    /**
     * Task: Check whether the specified entry exists or not in hashset.
     *
     * @param e the object to be specified in hashset
     * @return true if the specified entry exist in hashset.
     */
    boolean contains(Object e);// Checks if a specific entry is in the set. Returns true if the entry is in the set, false otherwise.

    /**
     * Task: Converts the hashset into an array of strings.
     *
     * @return back the array of strings.
     */
    String[] toArray(); // Converts the set into an array of strings.
    /**
     * Task: Converts the hashset into an array of integer.
     *
     * @return back the array of integer.
     */
    Integer[] toIntArray(); // Converts the set into an array of integers.

    /**
     * Task: Converts the hashset into strings.
     *
     * @return back the strings.
     */
    String toString(); // Returns a string representation of the set.

}

