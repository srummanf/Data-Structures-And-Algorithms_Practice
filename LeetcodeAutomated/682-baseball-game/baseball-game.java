class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int n = operations.length;
        for (String s : operations) {
            if (!s.equals("C") && !s.equals("D") && !s.equals("+")) {
                int a = Integer.parseInt(s);
                st.push(a);
            } else if (s.equals("C")) {
                st.pop();
            } else if (s.equals("D")) {
                int a = st.pop();
                st.push(a);
                st.push(2 * a);
            } else if (s.equals("+") && st.size() >= 2) {
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a + b);
            }
        }
        // System.out.println(st);
        if (st.size() > 1) {
            int sum = 0;
            while(!st.isEmpty()){
                sum += st.pop();
            }
            return sum;
        } else
            return 0;

    }
}