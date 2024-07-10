class Solution {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String x : logs) {
            int l = x.length();
            // System.out.println(x);
            int dot1 = l - 2;
            int dot2 = l - 3;

            if (x.equals("../") && cnt==0)
                cnt+=0;
            else if (x.equals("../") && cnt>0)
                cnt--;
            else if (x.equals("./"))
                cnt += 0;
            else
                cnt++;
        }
        if (cnt < 0)
            cnt = 0;
        return cnt;

    }
}