import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        for (int i = 0; i < n; ) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, multiplicity = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
                for (String key : top.keySet()) {
                    int val = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + val * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = (i > iStart) ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        Map<String, Integer> result = stack.pop();
        TreeMap<String, Integer> sortedResult = new TreeMap<>(result);
        StringBuilder sb = new StringBuilder();
        for (String key : sortedResult.keySet()) {
            sb.append(key);
            int count = sortedResult.get(key);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
