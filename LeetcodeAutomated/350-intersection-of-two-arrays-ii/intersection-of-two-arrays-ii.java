class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> hash = new ArrayList<>();
        int[] a = nums1.length >= nums2.length ? nums1 : nums2;
        int[] b = nums1.length < nums2.length ? nums1 : nums2;
        for (int i : a) {
            hash.add(i);
        }
        ArrayList<Integer> vals = new ArrayList<>();
        for (int i : b) {
            if (hash.contains(i)) {
                hash.remove(Integer.valueOf(i));
                vals.add(i);
            }
        }
        int[] ans = vals.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}