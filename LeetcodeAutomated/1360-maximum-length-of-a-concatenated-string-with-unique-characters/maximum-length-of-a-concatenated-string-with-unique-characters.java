class Solution {

    // Function to check if a string has all unique characters
    public boolean isUnique(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int i : count) {
            if (i >= 2) {
                return false;  // If any character repeats, the string is not unique
            }
        }
        return true;
    }

    public int maxLength(List<String> arr) {
        int n = arr.size();
        int maxi = 0;

        // Generate all possible subsequences using bit manipulation
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder con = new StringBuilder();

            // Construct a subsequence by selecting elements based on the current mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    con.append(arr.get(i));
                }
            }

            // Check if the concatenated subsequence has unique characters
            if (isUnique(con.toString())) {
                maxi = Math.max(maxi, con.length());
            }
        }

        return maxi;
    }
}
