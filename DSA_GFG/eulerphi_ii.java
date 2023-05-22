import java.io.*;
public class eulerphi_ii {
    // function to return gcd of a and b
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    static int phi(int a, int b) {
        int result = 1;
        for (int i = 2; i < b; i++)
            if (gcd(i, b) == 1)
                result++;
        return result;
    }
    public static void main(String[] args){
        int n =5;
        System.out.println("phi(" + n + ") = " + phi(n, n));
    }
}
