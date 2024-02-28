import java.util.Scanner;

public class RecursiveSOD {
    public static int findSum(int n){
        int ans = 0;
        if(n<10) 
            return n;
        else {
            while(n>0){
                int d = n % 10;
                ans = ans + d;
                n = n/10;
            }
            return findSum(ans);
        }
        
        
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(findSum(n));
        
    }
}
