import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void fillArray(String w, int[] arr) {
        int n = w.length();
        for (int i = 0; i < n; i++) {
            arr[w.charAt(i) - 'a']++;
        }
    }

    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        fillArray(words[0], count);

        int n = words.length;
        for (int i = 1; i < n; i++) {
            int[] temp = new int[26];
            fillArray(words[i], temp);
            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], temp[j]);
            }
        }

        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < count[j]; i++) {
                char ch = (char) (j + 'a');
                ans.add(Character.toString(ch));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = {"bella", "label", "roller"};
        System.out.println(sol.commonChars(words1)); // Output: ["e", "l", "l"]

        String[] words2 = {"cool", "lock", "cook"};
        System.out.println(sol.commonChars(words2)); // Output: ["c", "o"]
    }
}
