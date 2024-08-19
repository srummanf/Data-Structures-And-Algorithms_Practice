// class Solution {
//     public int paste(int n) {
//         return n + 1;
//     }

//     public int copy(int n) {
//         return n + 1;
//     }

//     public int minSteps(int n) {
//         if (n == 1)
//             return 0;
//         int ctr = 0;
//         int idx = 0;
//         while (n > 0)
//             if (ctr <= n) {
//                 ctr += copy(n);
//                 ctr += paste(n);
//                 n -= (int)Math.pow(2, idx++);
//             }

//         return 0;
//     }
// }
class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;

        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                count += i;
                n = n / i;
            }
        }
        return count;
    }
}
