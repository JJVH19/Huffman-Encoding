import java.util.ArrayList;
import java.util.List;

public class CustomMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>> bucketArray;
    private int capacity;
    private int size;

    public CustomMap(int capacity) {
        this.capacity = capacity;
        this.bucketArray = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            bucketArray.add(null);
        }
        this.size = 0;
    }

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

        // Key doesn't exist, add a new entry
        size++;
        head = bucketArray.get(bucketIndex);
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        bucketArray.set(bucketIndex, newEntry);
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Key not found
    }

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

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }
}
