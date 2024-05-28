
/**
 * MaxSubArraySum_KadanesAlgo
 */
import java.util.*;

public class MaxSubArraySum_KadanesAlgo {
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MAX_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum < maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        // if (maxi < 0) maxi = 0;

        return maxi;
    }

    public static void main(String args[]) {
        int[] arr = { -2, -11, -3, -4, -11, -2, -11, -5, -4 };
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The minimum subarray sum is: " + maxSum);

    }

}