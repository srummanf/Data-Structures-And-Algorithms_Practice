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

        int previousCount = 0;
        for (int count : hm.values()) {
            System.out.println("Count == "+count);
            System.out.println("previousCount == "+previousCount);
            if (previousCount != 0) {
                ans += previousCount * count;
                System.out.println("ans == "+ans);
            }
            previousCount = count;
            System.out.println("updated previousCount == "+previousCount);
            System.out.println();
        }

        return ans;

        
    }
}