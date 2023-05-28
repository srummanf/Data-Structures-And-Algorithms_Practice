// import java.util.*;

// public class eulerphi_algo {
//     int gcd(int a, int b){
//         if(a==0)
//         return (b);
//         else
//         return gcd(b%a,a);
//     }

//     public static void main(String[] args)
//     {
//         eulerphi_algo ob = new eulerphi_algo();
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int res = 0;
//         for(int i=1;i<n;i++){
//             if(ob.gcd(n,i)==1)
//             res++;
//         }
//         System.out.println(res);
//     }
// }
//

import java.io.*;

class eulerphi_algo {
    static int phi(int n) {
        float result = n;
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result *= (1.0 - (1.0 / (float) p));
            }
        }
        if (n > 1)
            result -= result / n;
        return (int) result;
    }

    public static void main(String args[]) {
        eulerphi_algo ob = new eulerphi_algo();
        int n = 35;
        System.out.println("phi(" + n + ") = " + ob.phi(n));
    }
}
