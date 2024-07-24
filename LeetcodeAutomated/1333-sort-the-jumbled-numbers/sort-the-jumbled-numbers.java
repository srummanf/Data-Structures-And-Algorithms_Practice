import java.util.*;

class Solution {
    public int conversion(int[] mapping, int num) {
        if (num == 0) return mapping[0];
        
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int d = num % 10;
            sb.append(mapping[d]);
            num /= 10;
        }
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> mappedList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            mappedList.add(new int[]{conversion(mapping, nums[i]), i});
        }
        
        Collections.sort(mappedList, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[mappedList.get(i)[1]];
        }
        
        return result;
    }
}

/** class Solution {

    public int conversion(int[] mapping, int num) {
        StringBuilder sb = new StringBuilder();
        int n = num;
        while (num > 0) {
            int d = num % 10;
            String ch = Integer.toString(mapping[d]);
            sb.append(ch);
            num = num / 10;
        }
        sb.reverse();
        return Integer.parseInt(new String(sb));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i : nums) {
            pq.add(new int[] { conversion(mapping, i), i });
        }
        for (int[] i : pq) {
            System.out.println(i[0] + "-" + i[1]);
        }
        int ans[] = new int[n];
        int idx = 0;
        for (int[] i : pq) {
            ans[idx++] = i[1];
        }
        return ans;

    }
} */
