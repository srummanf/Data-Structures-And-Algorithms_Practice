class Solution {
    public boolean check(int[] bloomDay, int day, int m, int k) {
        int ans = 0;
        int count = 0;
        for (int i : bloomDay) {
            if (i <= day)
                count++;
            else {
                ans += count / k;
                count = 0;
            }
        }
        ans += count / k;
        if (ans >= m)
            return true;
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)
            return -1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            mini = Math.min(i, mini);
            maxi = Math.max(i, maxi);
        }

        int low = mini;
        int high = maxi;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low<=maxi? low: -1;
        // for (int i = mini; i <= maxi; i++) {
        //     if (check(bloomDay, i, m, k)) {
        //         return i;
        //     }
        // }
        

    }
}