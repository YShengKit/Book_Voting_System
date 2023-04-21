package MyADT;
/**
 * MyHashMapInterface.java
 * An interface for the ADT MyHashMap. It consists of 2 parts, where
 * an array like structure behaves like a container to store each entries.
 * Each entries behave like a linked list where each of it can shares a
 * same index based on the size of the hashmap.
 *
 * @author Yeap Sheng Kit
 * @param <K> the Key index for each entries in the MyHashMap.
 * @param <V> the Value for each correspond Key.
 */

public interface MyHashMapInterface <K, V> {

    /**
     * Task: Adds a new entry to the HashMap. If there is entry with
     * same index of the new entry, it will be assigned to the next
     * position of the existing entry which is pointing to null. If the
     * existing entry shares a same key as new entry, the existing entry
     * will be replaced by overwriting the value.
     *
     * @param key  the value that specifies the position of each entry
     *             by its hashcode
     * @param value the value that paired with its correspond key which
     *              is mapped to the key.
     */
    void put(K key, V value);

    /**
     * Task: Gets the value associated with the key
     *
     * @param key  the value that specifies the position of each entry
     *             by its hashcode
     * @return null if the entry does not contain any value, else return
     *          its correspond value based on the key.
     */
    V get(K key);

    /**
     * Task: Retrieves all the existing key in the MyHashMap
     *
     * @return all the existing key in the form of HashSet
     */
    HashSet<K> getKeys();

    /**
     * Task: Checks whether the MyHashMap contains a given key.
     *
     * @param key  the value that specifies the position of each entry
     *             by its hashcode
     * @return true if the list contains the key, or false if not
     */
    boolean containsKey(K key);

    /**
     * Task: Remove an entry in the MyHashMap. The entry will be located
     * by the hashed key value. If there is no such entry, the method will
     * return and break. Otherwise, it will be removed. If the entry is not
     * a last entry of the linked list, the previous entry will point to the
     * entry's next position, thus removing the entry with given key.
     *
     * @param key  the value that specifies the position of each entry
     *             by its hashcode
     */
    void remove(K key);

    /**
     * Task: Retrieves the size of the MyHashMap.
     *
     * @return integer value of the MyHashMap's size.
     */
    int size();

    /**
     * Task: Retrieves the entire MyHashMap & visualize its structure.
     *
     * @return String value of the MyHashMap structure.
     */
    String toString();
}
