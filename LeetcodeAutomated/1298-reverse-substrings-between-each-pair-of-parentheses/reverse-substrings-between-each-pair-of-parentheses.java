import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push(i);
            } else if (arr[i] == ')') {
                int open = st.pop();
                reverse(arr, open + 1, i - 1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
