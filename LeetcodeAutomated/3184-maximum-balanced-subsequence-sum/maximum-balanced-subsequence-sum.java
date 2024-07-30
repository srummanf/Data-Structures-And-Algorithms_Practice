class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = nums[i]-i;
        }
        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(nums[i]<=0){
                ans = Math.max(ans, nums[i]);
            }
            else{
                long temp = nums[i];
                if(map.floorKey(arr[i])!=null){
                    temp += map.get(map.floorKey(arr[i]));
                }
                while(map.ceilingKey(arr[i])!=null && map.get(map.ceilingKey(arr[i]))<temp){
                    map.remove(map.ceilingKey(arr[i]));
                }
                if(map.floorKey(arr[i])==null || map.get(map.floorKey(arr[i]))<temp){
                    map.put(arr[i], temp);
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}

// public class Solution {
//     private int n;
//     private Long[][] t;

//     public long solve(int[] nums, int prevIdx, int currIdx) {
//         if (currIdx == n) {
//             return 0;
//         }

//         if (prevIdx != -1 && t[prevIdx][currIdx] != null) {
//             return t[prevIdx][currIdx];
//         }

//         long taken = Integer.MIN_VALUE;

//         if (prevIdx == -1 || nums[currIdx] - currIdx >= nums[prevIdx] - prevIdx) {
//             taken = nums[currIdx] + solve(nums, currIdx, currIdx + 1);
//         }

//         long notTaken = solve(nums, prevIdx, currIdx + 1);
//         long result = Math.max(taken, notTaken);

//         if (prevIdx != -1) {
//             t[prevIdx][currIdx] = result;
//         }

//         return result;
//     }

//     public long maxBalancedSubsequenceSum(int[] nums) {
//         boolean allNegative = true;
//         long maxEl = Integer.MIN_VALUE;
//         n = nums.length;

//         for (int x : nums) {
//             maxEl = Math.max(maxEl, x);
//             if (x >= 0) {
//                 allNegative = false;
//             }
//         }

//         if (allNegative) {
//             return maxEl;
//         }

//         t = new Long[n+1][n + 1]; // Initialize the memoization array
//         return solve(nums, -1, 0);
//     }
// }
