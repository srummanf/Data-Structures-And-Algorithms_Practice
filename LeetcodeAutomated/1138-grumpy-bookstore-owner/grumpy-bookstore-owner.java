// class Solution {
//     public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
//         int curr = 0;
//         int n = grumpy.length;

//         for (int i = 0; i < minutes; i++) {
//             curr += customers[i] * grumpy[i];
//         }

//         int maxi = curr;

//         int i = 0;
//         int j = minutes;

//         while (j < n) {
//             curr += customers[j] * grumpy[j];
//             curr -= customers[i] * grumpy[i];
//             maxi = Math.max(maxi, curr);
//             i++;
//             j++;
//         }

//         int total = maxi;

//         for (int k = 0; k < minutes; k++) {
//             if (grumpy[k] == 0)
//                 total += customers[k];
//         }

//         return total;

//     }
// }

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int n = customers.length;
        
        // Calculate the initial number of satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        // Calculate the maximum number of customers that can be satisfied
        // during the grumpy period by using the secret technique
        int maxExtraSatisfied = 0;
        int currentExtraSatisfied = 0;
        
        // Calculate the initial window of 'minutes' size
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentExtraSatisfied += customers[i];
            }
        }
        maxExtraSatisfied = currentExtraSatisfied;
        
        // Use sliding window to calculate for the rest of the array
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentExtraSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentExtraSatisfied -= customers[i - minutes];
            }
            maxExtraSatisfied = Math.max(maxExtraSatisfied, currentExtraSatisfied);
        }
        
        return totalSatisfied + maxExtraSatisfied;
    }
}
