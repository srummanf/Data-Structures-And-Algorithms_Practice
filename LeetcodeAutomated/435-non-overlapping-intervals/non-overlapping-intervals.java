class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int n = intervals.length;
        int prev_end_time = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int curr_start_time = intervals[i][0];
             if (curr_start_time < prev_end_time) {
                cnt++; 
            } else {
                prev_end_time = intervals[i][1];
            }
        }
        return cnt;

    }
}