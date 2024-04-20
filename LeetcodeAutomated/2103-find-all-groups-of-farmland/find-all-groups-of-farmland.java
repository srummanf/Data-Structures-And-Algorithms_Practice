class Solution {
    int bottom_i, bottom_j;
    public void dfs(int[][] land, int i, int j){
        if(i==land.length || j==land[0].length || land[i][j]==0 ) return;
        land[i][j] = 0;
        bottom_i = Math.max(i, bottom_i);
        bottom_j = Math.max(j, bottom_j);
        dfs(land, i, j+1);
        dfs(land, i+1, j);
    }
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> ll = new ArrayList<>();
         for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j]==1){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);

                    dfs(land, i, j);
                    
                    l.add(bottom_i);
                    l.add(bottom_j);
                    bottom_i=0;
                    bottom_j=0;
                    ll.add(l);
                }
            }
         }
         int size = ll.size();
         int[][] ans = new int[size][4];
         int i = 0;
         for(List<Integer> list : ll){
            ans[i][0] = list.get(0);
            ans[i][1] = list.get(1);
            ans[i][2] = list.get(2);
            ans[i][3] = list.get(3);
            i++;
         }
         return ans;
    }
}