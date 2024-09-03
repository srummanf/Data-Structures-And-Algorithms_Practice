import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int dis_idx = cost.length - 1 - 2;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (i != dis_idx)
                ans += cost[i];
            else
                dis_idx -= 2+1;
        }
        return ans;

    }
}