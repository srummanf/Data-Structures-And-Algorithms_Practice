
class NumArray {
    private int[] segmentTree;
    private int n;

    void buildSegmentTree(int i, int l, int r, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    int querySegmentTree(int start, int end, int i, int l, int r) {
        // Case 1: Out of Bound
        if (l > end || r < start) {
            return 0;
        }

        // Case 2: Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        // Case 3: Overlapping
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * i + 1, l, mid) +
               querySegmentTree(start, end, 2 * i + 2, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */


// class NumArray {

//     void buildSegmentTree(int i, int l, int r, int[] segmentTree, int[] arr) {
//     if (l == r) {
//       segmentTree[i] = arr[l];
//       return;
//     }
//     int mid = l + (r - l) / 2;
//     buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
//     buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
//     segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
//   }

//     public NumArray(int[] nums) {
//         int n = nums.length;
//         int[] segmentTree = new int[4 * n];
//         buildSegmentTree(0, 0, n - 1, segmentTree, nums);
//     }

//     public int sumRange(int left, int right) {
//         return 0;
//     }

//     int querySegmentTree(
//             int start,
//             int end,
//             int i,
//             int l,
//             int r,
//             int[] segmentTree) {
//         // Case 1 : Out of Bound
//         if (l > end || r < start) {
//             return 0;
//         }

//         // Case 2 : Completely within the range
//         if (l >= start && r <= end) {
//             return segmentTree[i];
//         }

//         // Case 3 : Overlapping
//         int mid = l + (r - l) / 2;
//         return (querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree) +
//                 querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree));
//     }
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * int param_1 = obj.sumRange(left,right);
//  */