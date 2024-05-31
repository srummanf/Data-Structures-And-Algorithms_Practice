class Solution {
    static String s = "";
    static List<String> ans = new ArrayList<>();

    public static boolean isValid(String str) {
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }
        if (count == 0)
            return true;
        return false;
    }

    public static void solve(int n, int openCount, int closeCount) {
        if (s.length() == 2 * n) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        if (openCount < n) {
            s += '(';
            solve(n, openCount + 1, closeCount);
            s = s.substring(0, s.length() - 1);
        }
        if (closeCount < openCount) {
            s += ')';
            solve(n, openCount, closeCount + 1);
            s = s.substring(0, s.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        // Reset static variables
        s = "";
        ans = new ArrayList<>();
        solve(n, 0, 0);
        return ans;
        
    }
}