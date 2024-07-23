class Solution {
    public boolean isPossible(long k, int[] piles, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / k + 1;
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long l = 1;
        long r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l < r) {
            long mid = l + (r - l) / 2;
            if (isPossible(mid, piles, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }
}