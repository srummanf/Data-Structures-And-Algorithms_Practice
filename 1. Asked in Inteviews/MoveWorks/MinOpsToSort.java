// Asked in OA
// https://www.geeksforgeeks.org/minimize-moves-to-sort-array-in-non-decreasing-order-by-breaking-elements-in-two-parts/

// https://www.youtube.com/watch?v=kFe_LRWuZjE

// Java code to implement the approach

import java.lang.*;
import java.util.*;

class GFG {

  // Function to count the minimum
  // number of splits
  public static int minimumSplits(int arr[], int n) {
    int totalSplits = 0;

    // Get the value at the last index
    int prevVal = arr[n - 1];

    for (int idx = n - 2; idx >= 0; idx--) {
      totalSplits += (arr[idx] - 1) / prevVal;
      int numGroups = ((arr[idx] - 1) / prevVal + 1);
      prevVal = arr[idx] / numGroups;
    }

    return totalSplits;
  }

  // Driver code
  public static void main(String[] args) {
    int arr[] = { 3, 2, 4 };
    int N = arr.length;

    int minSplit = minimumSplits(arr, N);
    System.out.print(minSplit);
  }
}
