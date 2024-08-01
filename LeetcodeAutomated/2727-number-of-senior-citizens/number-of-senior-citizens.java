class Solution {

    public int returnAge(String s) {
        s = s.substring(11, 13);
        return Integer.parseInt(s);
    }

    public int countSeniors(String[] details) {
        int ctr=0;
        for (String detail : details) {
            if (returnAge(detail) > 60)
                ctr++;
        }
        return ctr;
    }
}