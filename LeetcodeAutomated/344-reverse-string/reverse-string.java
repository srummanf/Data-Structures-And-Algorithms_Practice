class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int a = 0;
        int b = n-1;
        if(n%2==1) n--;
        for(int i=1; i<=n/2; i++){
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--; 
        }

        
    }
}