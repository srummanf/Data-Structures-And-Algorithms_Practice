class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || 
                        (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}



// class Solution {
//     int f(int i, int j, int[] arr, int k) {
//         if (i == 1) {
//             if (arr[i] > arr[0])
//                 return 1;
//         }
//         if (j == 1) {
//             if (arr[j] > arr[0])
//                 return 01;
//         }
//         if (i == 0 || j == 0)
//             return 0;
       
//         int nottake = f(i - 1, j, arr, k) + f(i, j - 1, arr, k);
//         int take = 0;
//         if (arr[i] > arr[j] && k==3)
//             take = f(i - 1, j, arr, k + 1) + f(i, j - 1, arr, k + 1);

//         return take+nottake;
//     }

//     public int numTeams(int[] arr) {
//         return f(arr.length-1,arr.length-2,arr, 0);
//     }
// }