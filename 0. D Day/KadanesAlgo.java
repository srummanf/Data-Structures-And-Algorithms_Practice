public int MinKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public int MaxKadanesAlgo(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }