import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Build a frequency map
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>(Collections.reverseOrder());
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue to sort based on frequency and value
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return b.get(1) - a.get(1); // Sort by value in decreasing order if frequencies are the same
            }
            return a.get(0) - b.get(0); // Sort by frequency in increasing order
        });

        // Step 3: Add frequency and value pairs to the priority queue
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(entry.getValue());
            temp.add(entry.getKey());
            pq.add(temp);
        }

        // Step 4: Build the result array based on the sorted pairs
        int idx = 0;
        while (!pq.isEmpty()) {
            ArrayList<Integer> entry = pq.poll();
            int frequency = entry.get(0);
            int value = entry.get(1);
            for (int i = 0; i < frequency; i++) {
                nums[idx++] = value;
            }
        }

        return nums;
    }
}
