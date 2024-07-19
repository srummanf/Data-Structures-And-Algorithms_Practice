class NumArray {
    private int[] segmentTree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    private void updateSegmentTree(int idx, int val, int root, int l, int r) {
        if (l == r) {
            segmentTree[root] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateSegmentTree(idx, val, 2 * root + 1, l, mid);
        } else {
            updateSegmentTree(idx, val, 2 * root + 2, mid + 1, r);
        }
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    public void update(int index, int val) {
        nums[index] = val;
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    private int querySegmentTree(int start, int end, int root, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segmentTree[root];
        }
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * root + 1, l, mid) +
               querySegmentTree(start, end, 2 * root + 2, mid + 1, r);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }
}
