class Solution {
    // Helper function to calculate the sum of digits of a number represented as a string
    public int sumOfDigits(String num) {
        int sum = 0;
        for (char ch : num.toCharArray()) {
            sum += ch - '0';  // Convert char to int and add to sum
        }
        return sum;
    }

    public int getLucky(String s, int k) {
        // Convert each character in the string to its corresponding numeric value
        StringBuilder num = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int n = (ch - 'a') + 1;
            num.append(n);  // Append the numeric value to the string
        }

        // Calculate the sum of digits
        int sum = sumOfDigits(num.toString());

        // Repeat the process k-1 times
        for (int i = 1; i < k; i++) {
            sum = sumOfDigits(Integer.toString(sum));
        }

        return sum;
    }
}
// class Solution {
//     public int sumOfDigits(long n) {
//         int sum = 0;
//         while (n > 0) {
//             long d = n % 10;
//             sum += (int) d;
//             n /= 10;
//         }
//         return sum;
//     }

//     public int getLucky(String s, int k) {
//         char[] arr = s.toCharArray();
//         String num = "";
//         for (char ch : arr) {
//             int n = (ch - 'a') + 1;
//             System.out.println(n);
//             num += Integer.toString(n);
//         }
//         char x = 'z';
//         int y = x - 'a';
//         System.out.println(num);
//         long ans = sumOfDigits(Long.parseLong(num));
//         for (int i = 1; i <= k - 1; i++) {
//             ans = sumOfDigits(ans);
//         }

//         return (int) ans;

//     }
// }