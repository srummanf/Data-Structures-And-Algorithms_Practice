class Solution {
    private HashMap<String, Boolean> mp = new HashMap<>();
    public boolean solve_recursion(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int n = s1.length();
        boolean result = false;

        for (int i = 1; i < n; i++) {
            boolean swapped = solve(s1.substring(0, i), s2.substring(n - i, n)) &&
                    solve(s1.substring(i, n), s2.substring(0, n - i));

            boolean not_swapped = solve(s1.substring(0, i), s2.substring(0, i)) &&
                    solve(s1.substring(i, n), s2.substring(i, n));

            if (swapped || not_swapped) {
                result = true;
                break;
            }
        }

        return result;
    }
    public boolean solve(String s1, String s2) {
        // Base cases
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "_" + s2;
        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        boolean result = false;
        int n = s1.length();

        for (int i = 1; i < n; i++) {
            // Case 1: Swapped
            boolean swapped = solve(s1.substring(0, i), s2.substring(n - i, n)) &&
                              solve(s1.substring(i, n), s2.substring(0, n - i));

            if (swapped) {
                result = true;
                break;
            }

            // Case 2: Not swapped
            boolean not_swapped = solve(s1.substring(0, i), s2.substring(0, i)) &&
                                  solve(s1.substring(i, n), s2.substring(i, n));

            if (not_swapped) {
                result = true;
                break;
            }
        }

        mp.put(key, result);
        return result;
    }

    public boolean isScramble(String s1, String s2) {
        // return solve_recursion(s1, s2);
        return solve(s1, s2);
    }
}