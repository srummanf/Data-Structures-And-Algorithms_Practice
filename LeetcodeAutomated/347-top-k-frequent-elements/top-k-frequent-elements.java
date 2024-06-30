class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int ans[] = new int[k];

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }

        int n = hm.size();

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(hm.entrySet());

        for(int i = 0; i<k; i++){
            ans[i] = maxHeap.poll().getKey();


        }
        
        return ans;
        
    }
}