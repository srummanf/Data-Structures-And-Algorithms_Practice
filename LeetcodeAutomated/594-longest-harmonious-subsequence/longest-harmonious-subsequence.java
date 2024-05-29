class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        for (int key : hm.keySet()) {
            if (hm.containsKey(key + 1)) {
                ans = Math.max(ans, hm.get(key) + hm.get(key + 1));
            }
        }
        return ans;
    }
}