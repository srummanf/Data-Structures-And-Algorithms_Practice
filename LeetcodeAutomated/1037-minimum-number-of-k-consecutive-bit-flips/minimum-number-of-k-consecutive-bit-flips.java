class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int length = nums.length; // The length of the input array.
        int[] flips = new int[length + 1]; // Difference array to track flips.
        int totalFlips = 0; // The number of flips made.
        int flipCounter = 0; // Counter to track the effect of flips done so far.

        for (int i = 0; i < length; ++i) {
            flipCounter += flips[i]; // update flip effect from previous operations

            // Check if the current bit is the same as the total flips made (even number of flips).
            if (nums[i] % 2 == flipCounter % 2) {
                // If we can't flip the next k bits because we're at the end, return -1.
                if (i + k > length) {
                    return -1;
                }
                // Increment the position where the flip started.
                flips[i]++;
                // Decrement the position right after where the flip ends to nullify the flip effect later.
                flips[i + k]--;
                // We've flipped once more, so increment the flip counter and total flips.
                flipCounter++;
                totalFlips++;
            }
        }
        // Return the total number of flips required to make all bits 1.
        return totalFlips;
    }
}