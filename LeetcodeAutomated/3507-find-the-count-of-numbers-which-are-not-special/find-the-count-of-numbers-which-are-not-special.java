class Solution {
    public int nonSpecialCount(int l, int r) {
        int sqrtR = (int) Math.sqrt(r);
        boolean[] isPrime = new boolean[sqrtR + 1];
        for (int i = 2; i <= sqrtR; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= sqrtR; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrtR; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int specialCount = 0;
        for (int i = 2; i <= sqrtR; i++) {
            if (isPrime[i]) {
                long square = (long) i * i;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }
        
        return r - l + 1 - specialCount;
    }
}