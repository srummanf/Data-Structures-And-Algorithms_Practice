import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        // Determine the sign
        if (numerator < 0 ^ denominator < 0)
            sb.append("-");
        
        // Convert to positive and handle as long to avoid overflow
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        
        // Append the integer part
        sb.append(n / d);
        long remainder = n % d;
        
        if (remainder == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();
        
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                sb.insert(hm.get(remainder), "(");
                sb.append(")");
                break;
            }
            
            hm.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / d);
            remainder %= d;
        }
        
        return sb.toString();
    }
}
