import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_PQ_Sort {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(9);
        minHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(9);
        maxHeap.add(1);
        System.out.println("Min Heap: " + minHeap);
        System.out.println("Max Heap: " + maxHeap);
    }
}
