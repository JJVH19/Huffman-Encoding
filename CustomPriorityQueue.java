import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomPriorityQueue<T> {
    private List<T> data;
    private Comparator<T> comparator;

    public CustomPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.data = new ArrayList<>();
    }

    public void addandMove(T item) {
        data.add(item);
        siftUp(data.size() - 1);
    }

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

    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    public int size() {
        return data.size();
    }


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
