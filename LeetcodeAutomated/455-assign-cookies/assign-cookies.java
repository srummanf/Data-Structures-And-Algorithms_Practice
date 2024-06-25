class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort the greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

        // Iterate through the cookies and try to satisfy each child
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                // If the current cookie can satisfy the current child, move to the next child
                childIndex++;
            }
            // Move to the next cookie in either case
            cookieIndex++;
        }

        // The number of children satisfied is the number of children we have iterated through
        return childIndex;
    }
}