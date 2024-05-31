class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : hm.keySet()){
            if(hm.get(i) == 1){
                al.add(i);
            }
        }
        int ans[] = new int[2];
        int x=0;
        for(int i : al){
            ans[x++] = i;
        }
        return ans;
    }
}