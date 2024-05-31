class Solution {
    public int[] singleNumber(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int rightmostsetbit = (xor & (xor - 1)) ^ xor;
        // Concept of bucket
        int b1 = 0, b2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightmostsetbit) != 0) {
                b1 ^= arr[i];
            } else {
                b2 ^= arr[i];
            }
        }
        return new int[] { b1, b2 };
    }
}