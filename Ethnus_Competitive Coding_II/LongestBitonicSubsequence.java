import java.util.ArrayList;
import java.util.List;

public class LongestBitonicSubsequence {

    public static void LBS(int[] nums) {
        int n = nums.length;
        if (n == 0) return;

        List<List<Integer>> increasing = new ArrayList<>();
        List<List<Integer>> decreasing = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            increasing.add(new ArrayList<>());
            decreasing.add(new ArrayList<>());
        }

        increasing.get(0).add(nums[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && increasing.get(i).size() < increasing.get(j).size()) {
                    increasing.set(i, new ArrayList<>(increasing.get(j)));
                }
            }
            increasing.get(i).add(nums[i]);
        }

        decreasing.get(n - 1).add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && decreasing.get(i).size() < decreasing.get(j).size()) {
                    decreasing.set(i, new ArrayList<>(decreasing.get(j)));
                }
            }
            decreasing.get(i).add(0, nums[i]);
        }

        int peak = 0;
        for (int i = 1; i < n; i++) {
            if ((increasing.get(i).size() + decreasing.get(i).size()) > (increasing.get(peak).size() + decreasing.get(peak).size())) {
                peak = i;
            }
        }

        System.out.println(increasing.get(peak) + " " + decreasing.get(peak).subList(1, decreasing.get(peak).size()));
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        LBS(arr);
    }
}
