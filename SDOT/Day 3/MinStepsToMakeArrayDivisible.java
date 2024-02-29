import java.util.*;

class MinStepsToMakeArrayDivisible {
    public static int minops(int[] nums, int[] numdiv) {
        int gcd = findGCD(numdiv);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int findGCD(int[] numdiv) {
        int gcd = numdiv[0];
        for (int i = 1; i < numdiv.length; i++) {
            int num = numdiv[i];
            while (num > 0) {
                int tmp = gcd % num;
                gcd = num;
                num = tmp;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] numdiv = new int[M];
        for (int j = 0; j < M; j++) {
            numdiv[j] = sc.nextInt();
        }
        System.out.println(minops(num, numdiv));
    }
}
