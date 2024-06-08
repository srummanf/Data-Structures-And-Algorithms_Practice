class Solution {
    // public boolean checkValidString(String s) {
    // Stack<Character> stack = new Stack<>();

    // for (char ch : s.toCharArray()) {
    // if (ch == '(' || ch == '{' || ch == '[' || ch == ')' || ch == '}' || ch ==
    // ']') {
    // // If the current character is an opening bracket, push it to the stack.
    // if (ch == '(' || ch == '{' || ch == '[') {
    // stack.push(ch);
    // } else {
    // // If the stack is empty or the top of the stack doesn't match the current
    // // closing bracket, return false.
    // if (stack.isEmpty()) {
    // return false;
    // }

    // char top = stack.pop();
    // if (ch == ')' && top != '(') {
    // return false;
    // } else if (ch == '}' && top != '{') {
    // return false;
    // } else if (ch == ']' && top != '[') {
    // return false;
    // }
    // }
    // }
    // }

    // // If the stack is empty, all brackets were properly closed; otherwise,
    // return
    // // false.
    // return stack.isEmpty();
    // }

    // public boolean checkValidString(String s) {
    //     int n = s.length();
    //     if(n==1 && (s.charAt(0)=='(' || s.charAt(0)==')'  )) return false;
    //     if(n==1 && (s.charAt(0)=='*')) return true;
    //     int i = 0;
    //     int j = n - 1;
    //     int count = 0;

    //     while (i < j) {
    //         System.out.println("i = " + i);
    //         System.out.println("j = " + j + "\n");
    //         // if (s.charAt(i) == '*') {
    //         // count++;
    //         // i++;
    //         // }
    //         // else if( s.charAt(j) == '*' ){
    //         // j--;
    //         // count++;
    //         // }

    //         if ((s.charAt(i) == '(' && s.charAt(j) == ')') || (s.charAt(i) == '(' && s.charAt(j) == '*')
    //                 || (s.charAt(i) == '*' && s.charAt(j) == ')') || (s.charAt(i) == '*' && s.charAt(j) == '*')) {
    //             i++;
    //             j--;
    //         } else {

    //             return false;
    //         }

    //     }
    //     return true;
    // }

public boolean checkValidString(String s) {
    int leftBalance = 0;
    int rightBalance = 0;
    int n = s.length();
    
    // Forward pass: treating '*' as '('
    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (c == '(' || c == '*') {
            leftBalance++;
        } else {
            leftBalance--;
        }
        if (leftBalance < 0) {
            return false;  // More ')' than '('
        }
    }
    
    // Backward pass: treating '*' as ')'
    for (int i = n - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == ')' || c == '*') {
            rightBalance++;
        } else {
            rightBalance--;
        }
        if (rightBalance < 0) {
            return false;  // More '(' than ')'
        }
    }
    
    return true;  // Both passes succeeded
}

}