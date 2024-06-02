import java.math.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int acc = (int)Math.floor(n/3);
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        for( int i : hm.keySet()){
            int freq = hm.get(i);
            if(freq>acc) ans.add(i);
        }
        return ans;
        
    }
}