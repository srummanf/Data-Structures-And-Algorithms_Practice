public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIndex = 0;
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (t[i] > maxL) {
                        maxL = t[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIdx[lastChosenIndex];
        }

        return result;
    }
}


// Recursive
// public class Solution {

//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);

//         List<Integer> result = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();

//         generate(0, nums, result, temp, -1);

//         return result;
//     }

//     private void generate(int idx, int[] nums, List<Integer> result, List<Integer> temp, int prev) {
//         if (idx >= nums.length) {
//             if (temp.size() > result.size()) {
//                 result.clear();
//                 result.addAll(temp);
//             }
//             return;
//         }

//         if (prev == -1 || nums[idx] % prev == 0) {
//             temp.add(nums[idx]);
//             generate(idx + 1, nums, result, temp, nums[idx]);
//             temp.remove(temp.size() - 1);
//         }

//         generate(idx + 1, nums, result, temp, prev);
//     }
// }

// class Solution {
// public List<Integer> f(int prev, int idx, int[] nums, List<Integer> ans,
// List<Integer> temp) {

// if (idx == nums.length) {
// if (temp.size() > ans.size()) {
// ans = temp;
// }

// return ans;
// }

// if (prev != -1 || nums[idx] % prev == 0) {
// temp.add(nums[idx]);
// return f(nums[idx], idx + 1, nums, ans, temp);
// temp.remove(temp.size() - 1);
// }
// return f(prev, idx + 1, nums, ans, temp);

// }

// public List<Integer> largestDivisibleSubset(int[] nums) {
// ArrayList<Integer> ans = new ArrayList<>();
// ArrayList<Integer> temp = new ArrayList<>();
// return f(-1, 0, nums, ans, temp);

// }
// }