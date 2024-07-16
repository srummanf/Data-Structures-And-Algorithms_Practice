class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alphabets = new int[26];
        StringBuilder alpha = new StringBuilder("abcdefghijklmnopqrstuvwzyz");
        for(char ch : sentence.toCharArray()){
            alphabets[ch-97]++;
        }
        for(int i : alphabets){
            if(i==0) return false;
        }

        return true;

        
    }
}