class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        ans.add("");
        if (digits.length() == 0)
            return new ArrayList<>();
        String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for (char dig : digits.toCharArray()) {
            String pressed = keypad[dig - '0'];
            List<String> temp = new ArrayList<>();
            for (String combination : ans) {
                for (char keys : pressed.toCharArray()) {
                    temp.add(combination + keys);
                }
            }
            ans = temp;
        }

        return ans;

    }
}