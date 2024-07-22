class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> vals = new TreeMap<>(Collections.reverseOrder());
        int n = names.length;
        for (int i = 0; i < n; i++) {
            vals.put(heights[i], names[i]);
        }
        String[] ans = new String[n];
        int index = 0;
        for (String name : vals.values()) {
            ans[index++] = name;
        }
        return ans;

    }
}