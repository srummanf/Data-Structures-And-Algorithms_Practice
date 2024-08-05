// KMP Algorithm

class Solution {
    public int strStr(String str, String pat) {
        int M = pat.length();
        int N = str.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (str.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M)
                return i;
        }

        return -1;
    }
}