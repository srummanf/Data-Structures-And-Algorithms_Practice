class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        int r  = bank.length;
        int c  = bank[0].length();

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(bank[i].charAt(j)=='1'){
                    hm.put(i, hm.getOrDefault(i,0)+1);
                }
            }
        }

        Integer previousCount = null;
        for (int count : hm.values()) {
            
            if (previousCount != null) {
                ans += previousCount * count;
            }
            previousCount = count;
        }

        return ans;

        
    }
}