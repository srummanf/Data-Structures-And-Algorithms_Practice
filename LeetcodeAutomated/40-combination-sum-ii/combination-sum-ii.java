class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates to handle duplicates
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return; // If remaining target is less than zero, return
        else if (remain == 0) ans.add(new ArrayList<>(tempList)); // If we hit the target, add the current combination to the result
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
                tempList.add(candidates[i]);
                backtrack(ans, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }
}






// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int l = 0;
//         int n = candidates.length;
//         int temp = 0;
//         LinkedList<Integer> vals = new LinkedList<>();
//         for (int r = 0; r < n; r++) {
//             if (temp < target) {
//                 temp += candidates[r];
//                 vals.add(candidates[r]);
//             } else if (temp > target) {
//                 temp -= candidates[l];
//                 vals.remove((Integer)candidates[l++]);
//             } else {
//                 ans.add(new ArrayList<>(vals));
//                 vals.clear();
//             }
//         }

//         return ans;

//     }
// }