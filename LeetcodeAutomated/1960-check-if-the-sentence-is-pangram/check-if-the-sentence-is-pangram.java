// class Solution {
//     public boolean checkIfPangram(String sentence) {
//         int[] alphabets = new int[26];
//         for(char ch : sentence.toCharArray()){
//             alphabets[ch-97]++;
//         }
//         for(int i : alphabets){
//             if(i==0) return false;
//         }
//         return true;  
//     }
// }


import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                uniqueChars.add(Character.toLowerCase(ch));
            }
        }
        return uniqueChars.size() == 26;
    }
}
