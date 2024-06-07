import java.util.StringTokenizer;  

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> h = new HashSet<>();
        for (String w : dictionary) {
            h.add(w);
        }
        String ans = "";
        int flag = 0;
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            String temp = "";
            String word = st.nextToken();
            
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i + 1);
                if (h.contains(sub)) {
                    ans = ans + sub;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                ans = ans + word;
            }
            ans=ans+ " ";
            flag=0;
        }

        return ans.trim();

    }
}