class Solution {
    public boolean isPalindrome(int x) {
        // Convert the integer to a string
        String s = Integer.toString(x);
        
        // Create a StringBuilder from the string and reverse it
        StringBuilder ss = new StringBuilder(s);
        String reversed = ss.reverse().toString();
        
        // Compare the original string with the reversed string
        return s.equals(reversed);
    }
}
