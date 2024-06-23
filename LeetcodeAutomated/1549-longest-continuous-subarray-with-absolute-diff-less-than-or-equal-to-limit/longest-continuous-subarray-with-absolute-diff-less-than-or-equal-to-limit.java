// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int n = nums.length;
//         int maxLen = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             int maxi = Integer.MIN_VALUE;
//             int mini = Integer.MAX_VALUE;
//             for (int j = i; j < n; j++) {
//                 // System.out.println(nums[i] + " -lll- "+ nums[j]);
//                 maxi = Math.max(maxi, Math.max(nums[i], nums[j]));
//                 mini = Math.min(mini, Math.min(nums[i], nums[j]));
               
//                 // System.out.println("max - " + maxi + " -- mini - "+ mini);
//                 if((int)Math.abs(maxi - mini)<=limit){
//                     maxLen = Math.max(maxLen, (j-i+1)); 
//                 }
//             }
//         }
//         return maxLen;

//     }
// }

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0; // Left end of the window
        int maxLen = 0; // Result to store the maximum length of the subarray
        
        // Deques to store the indexes of the elements in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        for (int right = 0; right < n; right++) {
            // Maintain the maxDeque to store the maximum values in descending order
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Maintain the minDeque to store the minimum values in ascending order
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // If the current window does not satisfy the limit condition, shrink it from the left
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                // Remove the elements which are out of the window
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            
            // Update the maximum length of the subarray
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
