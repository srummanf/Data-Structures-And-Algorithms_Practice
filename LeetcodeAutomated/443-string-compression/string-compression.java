class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int index = 0;
        while(i<n){
            char temp = chars[i];

            int count = 0;
            while(i<n && chars[i]==temp){
                count++;
                i++;
            }
            chars[index++] = temp;

            if(count>1){
                String ctr = Integer.toString(count);
                for(char ch : ctr.toCharArray()){
                    chars[index++] = ch;
                }
            }
        }


        return index;
        
    }
}