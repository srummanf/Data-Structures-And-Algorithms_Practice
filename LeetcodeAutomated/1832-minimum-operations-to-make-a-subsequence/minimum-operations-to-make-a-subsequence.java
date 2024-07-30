import java.util.*;

public class Solution {

    public int minOperations(int[] target, int[] arr) {
        // Step 1: Map elements of target to their indices
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetIndexMap.put(target[i], i);
        }

        // Step 2: Transform arr elements into target indices
        List<Integer> transformed = new ArrayList<>();
        for (int num : arr) {
            if (targetIndexMap.containsKey(num)) {
                transformed.add(targetIndexMap.get(num));
            }
        }

        // Step 3: Find the LIS in the transformed array
        int lisLength = patienceSort(transformed);

        // Step 4: Calculate the minimum number of operations
        return target.length - lisLength;
    }

    private int patienceSort(List<Integer> nums) {
        List<Integer> piles = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(piles, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == piles.size()) {
                piles.add(num);
            } else {
                piles.set(idx, num);
            }
        }

        return piles.size();
    }
}
