class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                map.put(num, count - 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         ArrayList<Integer> hash = new ArrayList<>();
//         int[] a = nums1.length >= nums2.length ? nums1 : nums2;
//         int[] b = nums1.length < nums2.length ? nums1 : nums2;
//         for (int i : a) {
//             hash.add(i);
//         }
//         ArrayList<Integer> vals = new ArrayList<>();
//         for (int i : b) {
//             if (hash.contains(i)) {
//                 hash.remove(Integer.valueOf(i));
//                 vals.add(i);
//             }
//         }
//         int[] ans = vals.stream().mapToInt(Integer::intValue).toArray();
//         return ans;
//     }
// }