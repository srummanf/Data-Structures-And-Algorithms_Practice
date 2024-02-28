import java.util.Scanner;

public class RecursiveSODwithoutLoops {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n==0?0:((n%9)==0?9:n%9));
        
    }
}
