class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void check(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        HashSet<Integer> hm = new HashSet<>();
        for (int i : nums2) {
            hm.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        for (int i : hm) {
            if (nums1.contains(i) == false) {
                temp.add(i);
            }
        }
        ans.add(temp);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // ArrayList<Integer> a = new ArrayList<>(nums1)
        ArrayList<Integer> a = new ArrayList<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        ArrayList<Integer> b = new ArrayList<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        check(b, a);
        check(a, b);
        return ans;
    }
}