class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Use the smaller array to create the HashSet
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        // Add all elements from nums1 to the set
        for (int num : nums1) {
            set.add(num);
        }
        
        // Check for intersection
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        
        // Convert Set to array
        return intersect.stream().mapToInt(Integer::intValue).toArray();
    }
}