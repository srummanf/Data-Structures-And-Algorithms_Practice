// class Solution {
//     public static boolean isPossible(int[] arr, int idx) {
//         int n = arr.length;
//         int evenSum = 0, oddSum = 0;
//         for (int i = 0; i < n; i++) {
//             if (i == idx) continue; 
//             if ((i < idx && i % 2 == 0) || (i > idx && (i - 1) % 2 == 0)) {
//                 evenSum += arr[i];
//             } else {
//                 oddSum += arr[i];
//             }
//         }

//         return evenSum == oddSum;
//     }
//     public int waysToMakeFair(int[] arr) {
//         int n = arr.length;
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (isPossible(arr, i)) count++;
//         }

//         return count;
//     }
// }

class Solution {
    public int waysToMakeFair(int[] nums) {
        int evenSum = 0; // Total sum of elements at even indices
        int oddSum = 0;  // Total sum of elements at odd indices

        int n = nums.length;

        // Calculate the initial sum of even and odd indexed numbers
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int tempEvenSum = 0; // Running sum of even indices up to the current index
        int tempOddSum = 0;  // Running sum of odd indices up to the current index
        int fairCount = 0;

        // Iterate over each element to check if removing it makes the array fair
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                // Check if removing nums[i] makes the remaining evenSum and oddSum equal
                if (tempOddSum + (evenSum - tempEvenSum - nums[i]) == tempEvenSum + (oddSum - tempOddSum)) {
                    fairCount++;
                }
                // Update the temporary even sum
                tempEvenSum += nums[i];
            } else {
                // Check if removing nums[i] makes the remaining evenSum and oddSum equal
                if (tempOddSum + (evenSum - tempEvenSum) == (oddSum - tempOddSum - nums[i]) + tempEvenSum) {
                    fairCount++;
                }
                // Update the temporary odd sum
                tempOddSum += nums[i];
            }
        }

        return fairCount; // Return the number of ways to make the array fair
    }
}
