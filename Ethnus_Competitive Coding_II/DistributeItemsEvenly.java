import java.util.HashMap;
import java.util.Map;

class DistributeItemsEvenly {

  static boolean checkCount(int arr[], int n, int k) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    // Maintain a hash
    for (int i = 0; i < n; i++) {
      if (!hash.containsKey(arr[i])) {
        hash.put(arr[i], 0);
      } else {
        hash.put(arr[i], hash.get(arr[i]) + 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (hash.get(arr[i]) > 2 * k) {
        return false;
      }
    }


    return true;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 3, 1 };
    int n = arr.length;
    int k = 2;
    System.out.println(checkCount(arr, n, k));
  }
}
