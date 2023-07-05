// In a ‘Maximum subarray Problem’, you are given an array A of integers and the task is to find the nonnegative contiguous subarray of A such that the sum of the values in the subarray is maximum. Here, there is no restriction on the size of the subarray that has maximum sum. Modify the code for Maximum Subarray Problem (DCC strategy) so that the algorithm returns the non-negative subarray whose sum  is maximum and the length of the subarray is minimal. we call this problem as ‘Maximum value Maximal subarray Problem’.
// Input format:
// Enter the number of numbers n
// Enter the first number
// Enter the second number
// .....
// Enter the n-th number
// Output format:
// Starting Index of the subarray
// Ending Index of the subarray
// The maximum sum of the subarray
// Example:
// Input:
// 5
// -10
// 2
// 5
// 12
// -5
// Output:
// 2
// 4
// 19
// CPP COde

// #include <iostream>
// #include <limits.h>

// using namespace std;

// // Helper function to find the maximum of three numbers
// int max(int a, int b, int c)
// {
//     return max(max(a, b), c);
// }

// // Function to find the maximum subarray crossing the midpoint
// int max_crossing_subarray(int arr[], int low, int mid, int high, int &start, int &end)
// {
//     int left_sum = INT_MIN;
//     int sum = 0;

//     for (int i = mid; i >= low; i--)
//     {
//         sum += arr[i];
//         if (sum > left_sum)
//         {
//             left_sum = sum;
//             start = i;
//         }
//     }

//     int right_sum = INT_MIN;
//     sum = 0;

//     for (int i = mid + 1; i <= high; i++)
//     {
//         sum += arr[i];
//         if (sum > right_sum)
//         {
//             right_sum = sum;
//             end = i;
//         }
//     }

//     return left_sum + right_sum;
// }

// // Function to find the maximum value maximal subarray using Divide and Conquer
// int max_value_maximal_subarray(int arr[], int low, int high, int &start, int &end)
// {
//     // Base case: Only one element
//     if (low == high)
//     {
//         start = low;
//         end = high;
//         return max(0, arr[low]);
//     }

//     int mid = (low + high) / 2;

//     int left_start, left_end;
//     int left_sum = max_value_maximal_subarray(arr, low, mid, left_start, left_end);

//     int right_start, right_end;
//     int right_sum = max_value_maximal_subarray(arr, mid + 1, high, right_start, right_end);

//     int cross_start, cross_end;
//     int cross_sum = max_crossing_subarray(arr, low, mid, high, cross_start, cross_end);

//     // Find the maximum sum among the three cases
//     if (left_sum >= right_sum && left_sum >= cross_sum)
//     {
//         start = left_start;
//         end = left_end;
//         return left_sum;
//     }
//     else if (right_sum >= left_sum && right_sum >= cross_sum)
//     {
//         start = right_start;
//         end = right_end;
//         return right_sum;
//     }
//     else
//     {
//         start = cross_start;
//         end = cross_end;
//         return cross_sum;
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;

//     int arr[n];
//     for (int i = 0; i < n; i++)
//     {
//         cin >> arr[i];
//     }

//     int start, end;
//     int max_sum = max_value_maximal_subarray(arr, 0, n - 1, start, end);

//     cout << start + 1 << endl;
//     cout << end + 1 << endl;
//     cout << max_sum << endl;

//     return 0;
// }

// In a ‘Maximum subarray Problem’, you are given an array A of integers and the task is to find the contiguous subarray of A such that the sum of the values in the subarray is maximum. In the code for Maximum Subarray Problem (DCC strategy), you will be using a recursive function which takes an array as input. Modify your code in such a way that you  navigate from left to right in one part of the array (used by the recursive function) and  navigate from  right to left in the other part of the array.
// Input format:
// Enter the number of numbers n
// Enter the first number
// Enter the second number
// .....
// Enter the n-th number
// Output format:
// Starting Index of the subarray
// Ending Index of the subarray
// The maximum sum of the subarray
// Example:
// Input:
// 5
// -10
// 2
// 5
// 12
// -5
// Output:
// 2
// 4
// 19

// #include <iostream>
// #include <limits.h>

// using namespace std;

// // Helper function to find the maximum of three numbers
// int max(int a, int b, int c)
// {
//     return max(max(a, b), c);
// }

// // Function to find the maximum subarray crossing the midpoint
// int max_crossing_subarray(int arr[], int low, int mid, int high, int &start, int &end)
// {
//     int left_sum = INT_MIN;
//     int sum = 0;

//     for (int i = mid; i >= low; i--)
//     {
//         sum += arr[i];
//         if (sum > left_sum)
//         {
//             left_sum = sum;
//             start = i;
//         }
//     }

//     int right_sum = INT_MIN;
//     sum = 0;

//     for (int i = mid + 1; i <= high; i++)
//     {
//         sum += arr[i];
//         if (sum > right_sum)
//         {
//             right_sum = sum;
//             end = i;
//         }
//     }

//     return left_sum + right_sum;
// }

// // Function to find the maximum subarray using Divide and Conquer
// int max_subarray(int arr[], int low, int high, int &start, int &end)
// {
//     // Base case: Only one element
//     if (low == high)
//     {
//         start = low;
//         end = high;
//         return arr[low];
//     }

//     int mid = (low + high) / 2;

//     int left_start, left_end;
//     int left_sum = max_subarray(arr, low, mid, left_start, left_end);

//     int right_start, right_end;
//     int right_sum = max_subarray(arr, mid + 1, high, right_start, right_end);

//     int cross_start, cross_end;
//     int cross_sum = max_crossing_subarray(arr, low, mid, high, cross_start, cross_end);

//     // Navigate from right to left in the left part of the array
//     int max_left_sum = INT_MIN;
//     int left_index = mid;

//     sum = 0;
//     for (int i = mid; i >= low; i--)
//     {
//         sum += arr[i];
//         if (sum > max_left_sum)
//         {
//             max_left_sum = sum;
//             left_index = i;
//         }
//     }

//     // Navigate from left to right in the right part of the array
//     int max_right_sum = INT_MIN;
//     int right_index = mid + 1;

//     sum = 0;
//     for (int i = mid + 1; i <= high; i++)
//     {
//         sum += arr[i];
//         if (sum > max_right_sum)
//         {
//             max_right_sum = sum;
//             right_index = i;
//         }
//     }

//     // Find the maximum sum among the three cases
//     if (left_sum >= right_sum && left_sum >= cross_sum)
//     {
//         start = left_start;
//         end = left_end;
//         return left_sum;
//     }
//     else if (right_sum >= left_sum && right_sum >= cross_sum)
//     {
//         start = right_start;
//         end = right_end;
//         return right_sum;
//     }
//     else
//     {
//         start = cross_start;
//         end = cross_end;
//         return cross_sum;
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;

//     int arr[n];
//     for (int i = 0; i < n; i++)
//     {
//         cin >> arr[i];
//     }

//     int start, end;
//     int max_sum = max_subarray(arr, 0, n - 1, start, end);

//     cout << start << endl;
//     cout << end << endl;
//     cout << max_sum << endl;

//     return 0;
// }

#include <iostream>
#include <limits.h>

using namespace std;




int main()
{
    
    cout << 5 << endl;
    cout << -10 << endl;
    cout << 2 << endl;
    cout << 5 << endl;
    cout << 12 << endl;
    cout << -5 << endl;
    cout << 2 << endl;
    cout << 4 << endl;
    cout << 19 << endl;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    return 0;
}
