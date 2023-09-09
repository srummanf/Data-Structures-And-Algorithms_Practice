// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A, int X, int Y) {
        int min = Integer.MAX_VALUE;
        int count = 0, sum =0, val=0;
        for(int j = 0; j<A.length-Y;j++){
        for(int i=j;i<A.length;i=i+Y)
        {
            sum=sum + A[i];
             System.out.println(sum + "\n");
             //System.out.println(A[1] + "\n");

            count++ ;
            if(count == X)
            {
                System.out.println(sum + "\n\n");
                min=Math.min(min,sum);
                sum=0;
                count=0;
                break;
            }
        }
        }
        
        return min;
        
    }

    public static void main(String args[])
    {
        int A[] = {4,2,5,4,3,5,1,4,2,7};
        Solution ob = new Solution();
        int ans =  ob.solution(A,3,2);
        System.out.println("Ans= "+ ans);
    }
}
