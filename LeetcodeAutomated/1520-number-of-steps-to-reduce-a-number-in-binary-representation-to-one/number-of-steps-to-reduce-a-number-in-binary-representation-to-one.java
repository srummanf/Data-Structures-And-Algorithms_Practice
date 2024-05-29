import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        int count = 0;
        BigInteger foo = new BigInteger(s, 2);
        while (!foo.equals(BigInteger.ONE)) { 
            if (foo.testBit(0) == false) { 
                foo = foo.shiftRight(1); 
            } else {
                foo = foo.add(BigInteger.ONE);
            }
            count++;
        }

        return count;
    }
}