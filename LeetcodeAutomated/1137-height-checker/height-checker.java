class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            copy[i] = heights[i];
        }
        Arrays.sort(heights);
        int count =0;
        for(int i=0; i<heights.length; i++){
            if(copy[i] != heights[i]){
                count++;
            }

        }
        return count;
        
    }
}