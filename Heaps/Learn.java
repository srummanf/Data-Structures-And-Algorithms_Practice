// Remember, heap is a complete binary tree. So values are simply stored in an array.
// Use this for Priority Queue as well!

import java.util.*;

class minHeap {

  int arr[];
  int size;
  int capacity;

  minHeap(int cap) {
    capacity = cap;
    size = 0;
    arr = new int[cap];
  }

  int left(int i) {
    return (2 * i - 1);
  }

  int right(int i) {
    return (2 * i + 1);
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  // ------------------------------------------------------------------------------------------------
  // Insertion in a min heap
  // ------------------------------------------------------------------------------------------------
  void insert(int x) {
    if (size == capacity) return;
    size++;
    arr[size - 1] = x;
    for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
      int temp = arr[parent(i)];
      arr[parent(i)] = arr[i];
      arr[i] = temp;
      i = parent(i);
    }
  }

  // ------------------------------------------------------------------------------------------------
  // Min Heapify  O(LogN)
  // ------------------------------------------------------------------------------------------------
  void minHeapify(int i) {
    int lt = left(i);
    int rt = right(i);
    int smallest = i;
    if (lt < size && arr[lt] < arr[i]) smallest = lt;
    if (rt < size && arr[rt] < arr[smallest]) smallest = rt;
    if (smallest != i) {
      int temp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = temp;
      minHeapify(smallest);
    }
  }

  // ------------------------------------------------------------------------------------------------
  // Extract Min  O(LogN)
  // It returns the min value and heapify it ------------------------------------------------------------------------------------------------
  int extractMin() {
    if (size == 0) return Integer.MAX_VALUE;
    if (size == 1) {
      size--;
      return arr[0];
    }
    int temp = arr[0];
    arr[0] = arr[size - 1];
    arr[size - 1] = temp;
    size--;
    minHeapify(0);
    return arr[size];
  }
}
