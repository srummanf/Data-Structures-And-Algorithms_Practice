class Solution {
    public boolean check(int n) {
        if(n==1) return true;
        if(n==0) return false;
        int d = n;
        while (d > 0) {
            if (d % 5 == 0) {
                d = d / 5;
            } else if (d % 3 == 0) {
                d = d / 3;
            } else if (d % 2 == 0) {
                d = d / 2;
            } else {
                return false;
            }
            if (d == 1)
                return true;
        }

        return false;

    }

    public boolean isUgly(int n) {
        return check(n);
    }
}