class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);
        System.out.println(s1 + " --- " + s2);
        int min = Math.min(s1.length(), s2.length());
        if (s1.length() == min) {
            for (int i = 1; i <= s2.length() - min; i++) {
                s1 = "0" + s1;
            }
        }
        if (s2.length() == min) {
            for (int i = 1; i <= s1.length() - min; i++) {
                s2 = "0" + s2;
            }
        }
        int cnt = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            System.out.println("A" + s1.charAt(i));
            System.out.println("B" + s2.charAt(i));
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        

        return cnt;
    }
}