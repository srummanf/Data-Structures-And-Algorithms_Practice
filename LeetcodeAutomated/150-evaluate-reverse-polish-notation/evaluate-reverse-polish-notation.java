class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>(); 
      
        
        for (String token : tokens) {
            
            if (token.length() > 1 || Character.isDigit(token.charAt(0))) {
                
                stack.push(Integer.parseInt(token));
            } else {
                
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
              
                
                switch (token) {
                    case "+":
                        stack.push(firstOperand + secondOperand); 
                        break;
                    case "-":
                        stack.push(firstOperand - secondOperand); 
                        break;
                    case "*":
                        stack.push(firstOperand * secondOperand); 
                        break;
                    case "/":
                        stack.push(firstOperand / secondOperand); 
                        break;
                }
            }
        }
      
        
        return stack.pop();
    }
}