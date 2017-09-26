package net.djtek.data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of HashMap using Java Lists
 * @param <K> The key type
 * @param <V> The value type
 */
public class HashMap<K, V> {
    class KeyValuePair<K, V> {
        K key;
        V value;

        KeyValuePair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private List<List<KeyValuePair<K, V>>> hash; // use list to handle collisions
    private int bucketSize;
    private int size;

    public HashMap(){
        this(512 /* default bucket size */);
    }

    public HashMap(int bucketSize){
        if (bucketSize <= 0){
            throw new IllegalArgumentException("bucket size must be > 0");
        }
        this.hash = new ArrayList<>(bucketSize);
        this.bucketSize = bucketSize;

        // need to call clear to populate with null entries
        clear();
    }

    /**
     * Clear the hash map
     */
    public void clear(){
        for (int i = 0; i < bucketSize; ++i) {
            hash.add(null);
        }
        size = 0;
    }

    /**
     * Determine if the hash map contains key.  This is just a
     * wrapper around find
     * @param key  The key
     * @return True if the hash map contains the key, false otherwise
     */
    public boolean contains(K key){
        return find(key) != null;
    }

    /**
     * Find the value for a given key
     * @param key The key
     * @return The value if present, null otherwise
     */
    public V find(K key){
        V value = null;

        int bucket = findBucket(key);
        List<KeyValuePair<K, V>> list = hash.get(bucket);
        if (list != null){
            for (KeyValuePair<K, V> kvp : list){
                if (kvp.key.equals(key)){
                    value = kvp.value;
                    break;
                }
            }
        }

        return value;
    }

    /**
     * Add a key value pair to the hash map
     * @param key The key
     * @param value The value
     * @return The existing objecting if it exists, null otherwise
     */
    public V put(K key, V value){
        V oldValue = null;

        // find bucket number
        int bucket = findBucket(key);

        // create collision list for bucket number if null
        List<KeyValuePair<K, V>> list = hash.get(bucket);
        if (list == null) {
            hash.set(bucket, new ArrayList<>());
        }

        // iterate over collision list looking for matching values and replace as needed
        list = hash.get(bucket);
        for (int i = 0; i < list.size(); ++i){
            KeyValuePair<K, V> kvp = list.get(i);
            if (kvp.key.equals(key)){
                oldValue = kvp.value;
                list.set(i, new KeyValuePair<K, V>(key, value));
                break;
            }
        }

        if (oldValue == null){
            // no matching value so just add it to the collision list
            list.add(new KeyValuePair<K, V>(key, value));
            ++size;
        }

        return oldValue;
    }

    /**
     * Remove the hash map entry for a given key if present
     * @param key The key
     */
    public void remove(K key){
        int bucket = findBucket(key);
        List<KeyValuePair<K, V>> list = hash.get(bucket);
        if (list != null) {
            for (int i = 0; i < list.size(); ++i){
                KeyValuePair<K, V> kvp = list.get(i);
                if (kvp.key.equals(key)){
                    list.remove(i);
                    --size;
                }
            }
        }
    }

    /**
     * Get the size of the hash map
     * @return The size
     */
    public int size(){
        return size;
    }

    private int findBucket(K key){
        return (key.hashCode() % bucketSize);
    }
}