
class Solution {
    public int chalkReplacer(int[] chalk, int initialChalkPieces) {
        long totalChalkNeeded = 0;
        for (int studentChalkUse : chalk) {
            totalChalkNeeded += studentChalkUse;
        }
        
        int remainingChalk = (int)(initialChalkPieces % totalChalkNeeded);
        
        for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
            if (remainingChalk < chalk[studentIndex]) {
                return studentIndex;
            }
            remainingChalk -= chalk[studentIndex];
        }
        
        return 0;  
    }
}


/**
 * TLE --> O(n)
 * public int chalkReplacer(int[] chalk, int k) {
 * int n = chalk.length;
 * int idx = 0;
 * int ans = 0;
 * while (k >= 0) {
 * k = k - chalk[idx++];
 * ans = idx;
 * if (idx % n == 0)
 * idx = 0;
 * }
 * return ans-1;
 * }
 * 
 */