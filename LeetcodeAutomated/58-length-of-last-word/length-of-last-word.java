class Solution{
    public int lengthOfLastWord(String s){
        String[] arr = s.split(" ");
        int n = arr.length;
        return arr[n-1].length();
    }
}

// import java.util.*;
// class Solution {
//     public int lengthOfLastWord(String s) {
//         StringTokenizer st = new StringTokenizer(s);
//         int l= 0;
//         int c = st.countTokens();
//         for(int i=0;i<c;i++){
//             String w = st.nextToken();
//              l = w.length();
//         }
//         return l;
//     }
// }