class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        int  a = 1;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            a = arr[i];
            for(int k = i+1; k<n; k++){
                a = a^arr[k];
                if(a==0) count = count + k-i; 
            }
        }
        return count;
        
    }
}