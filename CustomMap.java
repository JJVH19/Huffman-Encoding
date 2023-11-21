/*
 * This map supports adding, retrieving, and listing key-value based
 * on the provided keys and values. It uses hash code of the keys to 
 * distribute them among different buckets and each bucket is a linked list
 * to handle collisions
 */
import java.util.ArrayList;
import java.util.List;

public class CustomMap<K, V> {
    // Entry class represents key-value pairs in the map
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>> bucketArray;  // Array of linked lists (buckets) to store key-value pairs
    private int capacity;                   // Capacity of the map (number of buckets)
    private int size;                       // Number of key-value pairs in the map

    // Constructor to initialize the map with a specified capacity
    public CustomMap(int capacity) {
        this.capacity = capacity;
        this.bucketArray = new ArrayList<>(capacity);

        // Initialize each bucket with null
        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }

        this.size = 0;  // Initial size is zero
    }

    // Add or update a key-value pair in the map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = bucketArray.get(bucketIndex);

        // Check if the key already exists, then update the value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Key doesn't exist, add a new entry at the beginning of the bucket's linked list
        size++;
        head = bucketArray.get(bucketIndex);
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        bucketArray.set(bucketIndex, newEntry);
    }

    // Retrieve the value associated with a given key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = bucketArray.get(bucketIndex);

        // Traverse the linked list in the bucket to find the key
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Key not found
    }

    // Get a list of all keys in the map
    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        for (Entry<K, V> entry : bucketArray) {
            Entry<K, V> current = entry;
            while (current != null) {
                keysList.add(current.key);
                current = current.next;
            }
        }
        return keysList;
    }

    // Get the number of key-value pairs in the map
    public int size() {
        return size;
    }

    // Private method to calculate the bucket index for a given key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }
}
