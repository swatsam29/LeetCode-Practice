package Google;
import java.util.*;

public class 3FindingMKAverage {
    
// Define the MKAverage class
class MKAverage {

    // Declare necessary variables
    private int m, k;
    private Deque<Integer> stream;
    private TreeMap<Integer, Integer> minHeap, maxHeap;
    private long sumMiddle;
    private int size;

    // Constructor to initialize the object with m and k
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.stream = new LinkedList<>();
        this.minHeap = new TreeMap<>();
        this.maxHeap = new TreeMap<>();
        this.sumMiddle = 0;
        this.size = 0;
    }

    // Method to add a new element to the stream
    public void addElement(int num) {
        // If the stream size exceeds m, remove the oldest element
        if (stream.size() == m) {
            int oldest = stream.poll();
            removeElement(oldest);
        }

        // Add the new element to the stream
        stream.offer(num);
        addElementToDataStructures(num);
    }

    // Method to calculate the MKAverage
    public int calculateMKAverage() {
        // If there are fewer than m elements, return -1
        if (stream.size() < m) {
            return -1;
        }

        // Calculate and return the MKAverage
        return (int) (sumMiddle / (m - 2 * k));
    }

    // Helper method to add an element to the data structures
    private void addElementToDataStructures(int num) {
        if (minHeap.size() < k) {
            minHeap.put(num, minHeap.getOrDefault(num, 0) + 1);
        } else if (maxHeap.size() < k) {
            maxHeap.put(num, maxHeap.getOrDefault(num, 0) + 1);
        } else {
            if (num <= minHeap.lastKey()) {
                minHeap.put(num, minHeap.getOrDefault(num, 0) + 1);
                sumMiddle += moveElement(minHeap, maxHeap);
            } else if (num >= maxHeap.firstKey()) {
                maxHeap.put(num, maxHeap.getOrDefault(num, 0) + 1);
                sumMiddle += moveElement(maxHeap, minHeap);
            } else {
                sumMiddle += num;
            }
        }

        size++;
    }

    // Helper method to remove an element from the data structures
    private void removeElement(int num) {
        if (minHeap.containsKey(num)) {
            if (minHeap.get(num) == 1) {
                minHeap.remove(num);
            } else {
                minHeap.put(num, minHeap.get(num) - 1);
            }
        } else if (maxHeap.containsKey(num)) {
            if (maxHeap.get(num) == 1) {
                maxHeap.remove(num);
            } else {
                maxHeap.put(num, maxHeap.get(num) - 1);
            }
        } else {
            sumMiddle -= num;
        }

        if (size == m) {
            if (num <= minHeap.lastKey()) {
                sumMiddle -= moveElement(minHeap, maxHeap);
            } else if (num >= maxHeap.firstKey()) {
                sumMiddle -= moveElement(maxHeap, minHeap);
            }
        }

        size--;
    }

    // Helper method to move an element between heaps
    private int moveElement(TreeMap<Integer, Integer> from, TreeMap<Integer, Integer> to) {
        int num = from.firstKey();
        if (from.get(num) == 1) {
            from.remove(num);
        } else {
            from.put(num, from.get(num) - 1);
        }

        to.put(num, to.getOrDefault(num, 0) + 1);

        return num;
    }
}

}
