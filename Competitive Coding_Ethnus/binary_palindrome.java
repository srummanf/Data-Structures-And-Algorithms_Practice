import java.util.Scanner;

public class binary_palindrome {
    static int reverseBinary(int n, int len) {
        int f = len - 1, l = 0;
        int rev = 0;

        while (f > 1) {
            if ((n & (1 << f)) != 0) {
                rev = rev | (1 << l);
            }
            if ((n & (1 << l)) != 0) {
                rev = rev | (1 << f);
            }
            f--;
            l++;
        }
        return rev;
    }

    static int nthPalindrome(int n)
    {
        int l=0, count=0;
        while(count<n){
            l++;
            count = count + (int)Math.pow(2, (l-1)/2);
        }
        count = count - (int)Math.pow(2, (l-1)/2);
        int ele = n - count - 1;
        int ans = (1 << l-1) | (ele << (l/2));
        ans = ans | reverseBinary(ans, l);
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(nthPalindrome(n));
    }
}



int nthPalindrome(int n){
    int l;
    while(count<n)
    {
        l++
        count += Math.pow(n,(l-1)/2);))
    }
    count -= Math.pow(n,(l-1)/2);
    ele =n-count-1;
    ans==1<<l-1 | ele<<l/2;
    ans=ans|revbin(ans,l);
}


revbin(int n, int l){
    f=n-1,, len=0;
    rev=0;
    while(f>1)
    {
        ifn&&(1<<f)!=0
        rev=rev|(1<<l);
        if(n&&(1<<l)!=0)
        rev=rev|(1<<f);
        f--; len++;
    }
    retrev;
}
