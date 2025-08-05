
---

### 1. **Bubble Sort : [ During ascending order, largest element is selected and swapped side by side to reach the end , in the next iteration, we will be choosing the second largest element**

#### **Code:**

```java
public class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n²) in the worst and average case, O(n) in the best case (when the array is already sorted).
- **Space Complexity:** O(1) (in-place sorting).
- **Stable:** Yes.
- **Adaptive:** Yes, if optimized with a flag to check for sorted array.

**Interview Points:**

- Bubble Sort is often used to explain basic sorting concepts.
- It is a simple, yet inefficient algorithm, often taught as an introduction to sorting.

---

### 2. **Selection Sort**

#### **Code:**

```java
public class SelectionSort {
    void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n²) in the worst, average, and best case.
- **Space Complexity:** O(1) (in-place sorting).
- **Stable:** No.
- **Adaptive:** No.

**Interview Points:**

- Selection Sort is useful to explain the concept of in-place sorting.
- It’s not a stable sort, so its practical use is limited.

---

### 3. **Insertion Sort**

#### **Code:**

```java
public class InsertionSort {
    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n²) in the worst and average case, O(n) in the best case (when the array is already sorted).
- **Space Complexity:** O(1) (in-place sorting).
- **Stable:** Yes.
- **Adaptive:** Yes.

**Interview Points:**

- Insertion Sort is efficient for small data sets and nearly sorted data.
- It's adaptive and works well for online algorithms where data comes in over time.

---

### 4. **Merge Sort**

#### **Code:**

```java
public class MergeSort {
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n log n) in the worst, average, and best case.
- **Space Complexity:** O(n) (due to the auxiliary space used for merging).
- **Stable:** Yes.
- **Adaptive:** No.

**Interview Points:**

- Merge Sort is a classic example of the divide and conquer technique.
- It’s preferred for sorting linked lists due to its non-in-place nature and stability.

---

### 5. **Quick Sort**

#### **Code:**

```java
public class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n²) in the worst case (rare, can be avoided with random pivot selection), O(n log n) in the average and best case.
- **Space Complexity:** O(log n) (in-place sorting).
- **Stable:** No.
- **Adaptive:** No.

**Interview Points:**

- Quick Sort is preferred for arrays due to its in-place nature and average-case efficiency.
- Discuss the importance of choosing a good pivot to avoid the worst case.

---

### 6. **Heap Sort**

#### **Code:**

```java
public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
```

#### **Theory:**

- **Time Complexity:** O(n log n) in the worst, average, and best case.
- **Space Complexity:** O(1) (in-place sorting).
- **Stable:** No.
- **Adaptive:** No.

**Interview Points:**

- Heap Sort is often discussed for its efficiency and in-place nature.
- It is based on the binary heap data structure.

---

### **Table of Differences**

| Algorithm      | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity | Stable | Adaptive | Comments

|                          |            |            |            |          |     |     |                                                            |
| ------------------------ | ---------- | ---------- | ---------- | -------- | --- | --- | ---------------------------------------------------------- |
| **Bubble Sort**    | O(n)       | O(n²)     | O(n²)     | O(1)     | Yes | Yes | Good for small datasets, simple                            |
| **Selection Sort** | O(n²)     | O(n²)     | O(n²)     | O(1)     | No  | No  | Simple but inefficient for large datasets                  |
| **Insertion Sort** | O(n)       | O(n²)     | O(n²)     | O(1)     | Yes | Yes | Efficient for small datasets or nearly sorted data         |
| **Merge Sort**     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes | No  | Stable, preferred for linked lists                         |
| **Quick Sort**     | O(n log n) | O(n log n) | O(n²)     | O(log n) | No  | No  | In-place, efficient for large datasets, careful with pivot |
| **Heap Sort**      | O(n log n) | O(n log n) | O(n log n) | O(1)     | No  | No  | Based on binary heap, in-place                             |

---

This should cover the essential concepts, code, and differences related to these common sorting algorithms that might be asked during interviews.
