import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
 * This priority queue is implemented as binary heap as a complete binary tree
 * where the value of each node is less than or equal to values of its children according
 * to the comparator. This way it makes sure the highest priority is always at the root of the heap.
 */
public class CustomPriorityQueue<T> {
    private List<T> data;          // List to store the elements of the priority queue
    private Comparator<T> comparator;  // Comparator for defining the priority order

    // Constructor to initialize the priority queue with a comparator
    public CustomPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.data = new ArrayList<>();
    }

    // Add an item to the priority queue and adjust its position to maintain the heap property
    public void addandMove(T item) {
        data.add(item);
        siftUp(data.size() - 1);
    }

    // Remove and return the element with the highest priority (root of the heap)
    public T poll() {
        if (isEmpty()) {
            return null;
        }

        T result = data.get(0);
        int lastIndex = data.size() - 1;
        T last = data.remove(lastIndex);

        if (!isEmpty()) {
            data.set(0, last);
            siftDown(0);
        }

        return result;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    // Return the number of elements in the priority queue
    public int size() {
        return data.size();
    }

    // Restore heap property by moving the element up the tree
    private void siftUp(int index) {
        T item = data.get(index);

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = data.get(parentIndex);

            if (comparator.compare(item, parent) >= 0) {
                break;
            }

            data.set(index, parent);
            index = parentIndex;
        }

        data.set(index, item);
    }

    // Restore heap property by moving the element down the tree
    private void siftDown(int index) {
        int size = data.size();
        T item = data.get(index);

        while (index < size / 2) {
            int leftChildIdx = 2 * index + 1;
            int rightChildIdx = 2 * index + 2;
            int minChildIdx = leftChildIdx;

            if (rightChildIdx < size && comparator.compare(data.get(leftChildIdx), data.get(rightChildIdx)) > 0) {
                minChildIdx = rightChildIdx;
            }

            if (comparator.compare(item, data.get(minChildIdx)) <= 0) {
                break;
            }

            data.set(index, data.get(minChildIdx));
            index = minChildIdx;
        }

        data.set(index, item);
    }
}
