package MyADT;


public class MyHashMap<K, V>  implements MyHashMapInterface<K, V> {
    private final int SIZE = 16; // initial capacity of the array
    private Entry<K, V>[] entries = new Entry[SIZE]; // the array to hold the entries

    // Entry class to hold the key-value pair
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }


        // getters and setters
    }

    // get the index of the array based on the key
    private int getIndex(K key) {
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % SIZE;
    }

    // get the entry in the array based on the key
    private Entry<K, V> getEntry(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];

        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }

        return entry;
    }

    // put a key-value pair in the hashmap
    @Override
    public void put(K key, V value) {
        //hashcode
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];

        //if there is no linked list object (entry) in the array
        //then assign it to the array by hashing
        if (entry == null) {
            entries[index] = new Entry<>(key, value);
        } else {
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }

            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new Entry<>(key, value);
            }
        }
    }


    // get the value associated with the key
    @Override
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    @Override
    public HashSet<K> getKeys(){
        HashSet<K> keySet = new HashSet<>();
        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                keySet.add(entry.key);
//                System.out.println(entry.key);
                entry = entry.next;
            }
        }
        return keySet;
    }

    // check if the hashmap contains the key
    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null;
    }

    // remove the entry with the specified key
    @Override
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];

        if (entry == null) {
            return;
        }

        if (entry.key.equals(key)) {
            entries[index] = entry.next;
        } else {
            Entry<K, V> prev = entry;
            entry = entry.next;

            while (entry != null) {
                if (entry.key.equals(key)) {
                    prev.next = entry.next;
                    break;
                }

                prev = entry;
                entry = entry.next;
            }
        }
    }

    // get the size of the hashmap
    @Override
    public int size() {
        int size = 0;

        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                size++;
                entry = entry.next;
            }
        }

        return size;
    }

    @Override
    public void resize() {
//        might not required
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            Entry<K, V> entry = entries[i];
            while (entry != null) {
                sb.append(i+") "+entry.key + " -> " + entry.value + ",");
                entry = entry.next;
            }sb.append(i+") null " + "\n");
        }
        return sb.toString();
    }
}
