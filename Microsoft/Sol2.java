import java.util.*;

class Sol2 {
    public int solution(int[] A, int X, int Y) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < Y; i++) {
            sum += A[i];
        }

        for (int j = 0; j <= A.length - X; j++) {
            min = Math.min(min, sum);
            
            if (j + X < A.length) {
                sum += A[j + X] - A[j];
            }
        }

        return min;
    }

    public static void main(String args[])
    {
        int A[] = {4,2,5,4,3,5,1,4,2,7};
        Sol2 ob = new Sol2();
        int ans =  ob.solution(A,3,2);
        System.out.println("Ans= "+ ans);
    }
}
