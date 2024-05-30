class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(pref[0]);
        int i = 0;
        while(i<n-1){
            int x = pref[i]^pref[++i];
            ans.add(x);
        }
        System.out.println(ans);
        // return pref;
        int pos = 0;
        int[] sol = new int[n];
        for(int j : ans){
            sol[pos++] = j;

        }

        return sol;
    }
}