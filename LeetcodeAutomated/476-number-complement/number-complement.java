class Solution {
    public int findComplement(int num) {
        char[] word = Integer.toBinaryString(num).toCharArray();
        int n = word.length;
        for (int i = 0; i < n; i++) {
            if (word[i] == '1')
                word[i] = '0';
            else
                word[i] = '1';
        }
        String s = new String(word);
        return Integer.parseInt(s, 2);

    }
}