// class Solution {
//     public int f(int sum) {
//         if (sum == 0)
//             return 0;
//         int mini = Integer.MAX_VALUE;
//         for (int i = 1; i * i <= sum; i++) {
//             int result = 1 + f(sum - i * i);
//             mini = Math.min(mini, result);
//         }

//         return mini;
//     }

//     public int numSquares(int n) {
//         if(n==1) return 1;
//         return f(n);
//     }
// }

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int f(int sum) {
        if (sum == 0) {
            return 0;
        }
        if (memo.containsKey(sum)) {
            return memo.get(sum);
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i * i <= sum; i++) {
            int result = 1 + f(sum - i * i);
            mini = Math.min(mini, result);
        }

        memo.put(sum, mini);
        return mini;
    }

    public int numSquares(int n) {
        return f(n);
    }
}
