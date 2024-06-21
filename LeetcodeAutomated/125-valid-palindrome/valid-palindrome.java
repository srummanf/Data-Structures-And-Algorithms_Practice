class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        
        // Remove non-alphanumeric characters and convert to lowercase
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        String cleanedStr = cleaned.toString();
        String reversedStr = cleaned.reverse().toString();
        
        // Check if the cleaned string is equal to its reverse
        return cleanedStr.equals(reversedStr);
    }
    
    
}
