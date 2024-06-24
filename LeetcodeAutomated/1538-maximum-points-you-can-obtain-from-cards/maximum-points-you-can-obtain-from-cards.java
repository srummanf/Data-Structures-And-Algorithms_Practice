class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxi = 0;
        int lsum = 0;
        for(int i=0; i<k; i++){
            lsum += cardPoints[i];
        }
        int rsum = 0;
        maxi = Math.max(maxi, (lsum+rsum));
        int l=k-1, r=n-1;
        for(int i=0; i<k; i++){
            lsum -= cardPoints[l];
            l--;
            rsum += cardPoints[r];
            r--;
            maxi = Math.max(maxi, (lsum+rsum));
        }

        return maxi;
        
    }
}