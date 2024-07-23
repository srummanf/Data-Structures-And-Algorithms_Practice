import java.util.*;

public class Solution {
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            indices.add(maxHeap.poll()[1]);
        }
        Collections.sort(indices);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices.get(i)];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = maxSubsequence(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
