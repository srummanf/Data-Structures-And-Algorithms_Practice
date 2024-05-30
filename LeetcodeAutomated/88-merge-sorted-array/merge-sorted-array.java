
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ss = Math.min(m, n);
        int i = 0, j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int k = 0; k < ss; k++) {
            if (nums1[i] < nums2[j]) {
                al.add(nums1[i]);
                i++;
            } else {
                al.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            al.add(nums1[i]);
            i++;
        }
        while (j < n) {
            al.add(nums2[j]);
            j++;
        }
        // System.out.println(al);
        Collections.sort(al);
        int c = 0;
        for(int k : al){
            nums1[c++] = k;
        }

    }
}