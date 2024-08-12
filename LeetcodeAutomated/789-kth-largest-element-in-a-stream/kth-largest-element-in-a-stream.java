import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


// class KthLargest {
//     int k;
//     int[] nums;

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         this.nums = nums;
//     }

//     public int add(int val) {
//         ArrayList<Integer> temp = new ArrayList<>();
//         for (int a : nums)
//             temp.add(a);
//         temp.add(val);
//         nums = new int[temp.size()];
//         Collections.sort(temp, Collections.reverseOrder());
//         int ans = -1;
//         for (int i = 0; i < k; i++)
//             ans = temp.get(i);
//         int idx = 0;
//         for (int a : temp)
//             nums[idx++] = a;

//         return ans;
//     }
// }

// /**
//  * Your KthLargest object will be instantiated and called as such:
//  * KthLargest obj = new KthLargest(k, nums);
//  * int param_1 = obj.add(val);
//  */