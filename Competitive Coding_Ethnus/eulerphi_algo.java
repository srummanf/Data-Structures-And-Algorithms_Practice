import java.util.*;

public class eulerphi_algo {
    int gcd(int a, int b){
        if(a==0)
        return (b);
        else
        return gcd(b%a,a);
    }

    public static void main(String[] args)
    {
        eulerphi_algo ob = new eulerphi_algo();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i=1;i<n;i++){
            if(ob.gcd(n,i)==1)
            res++;
        }
        System.out.println(res);
    }
}
