// DP  17

// Recursive solutione
// boolean f(int ind, int target, int arr[]){
//     if(target==0) return true;
//     if(ind==0) return arr[0]= =target; --> This will return true if array[0] equal to target

//     boolean nottake = f(ind-1, target, arr);
//     boolean take = false;
//     if(a[ind]<= target){
//         take = f(ind-1, target-a[ind], arr);
//     }

//     return take || nottake;
// }

import java.util.ArrayList;
import java.util.Arrays;

public class subsetSumEqualsToTarget {

  public static boolean frec(int ind, int target, int arr[]) {
    if (target == 0) return true;
    if (ind == 0) return arr[0] == target;

    boolean nottake = frec(ind - 1, target, arr);

    boolean take = false;
    if (arr[ind] <= target) {
      take = frec(ind - 1, target - arr[ind], arr);
    }

    return take || nottake;
  }

  public static void main(String[] args) {
    int arr[] = { 3, 34, 4, 12, 5, 2 };
    int n = arr.length;
    int k = 9;
    //System.out.println(subsetSumToK(n, k, arr));
    System.out.println(frec(n-1, k, arr));
    //System.out.println(findWays(arr, k));
  }
}
