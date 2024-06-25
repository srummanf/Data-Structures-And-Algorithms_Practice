class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1;
        int b = -1;
        int c = -1;
        int num = 0;
        int l = 0, r = 0;
        int n = s.length();
        while(r<n){
        
            if(s.charAt(r)=='a') a = r;
            if(s.charAt(r)=='b') b = r;
            if(s.charAt(r)=='c') c = r;

            if(a!=-1 && b!=-1 && c!=-1){
                int min = Math.min(a, Math.min(b,c));
                 num += min+1;
            }




            r++;
        }



        return num;
        
    }
}