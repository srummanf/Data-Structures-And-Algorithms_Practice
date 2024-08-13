class Solution {
    void f(int i, int end, List<List<Integer>> ans, int[] candidates, int target, List<Integer> temp, int remain) {
        if (remain < 0)
            return;
        if (remain == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < end; j++) {
            temp.add(candidates[j]);
            f(j, end, ans, candidates, target, temp, remain - candidates[j]);
            temp.remove(temp.size() - 1);  // Backtrack
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates.length, ans, candidates, target, new ArrayList<>(), target);
        return ans;
    }
}
