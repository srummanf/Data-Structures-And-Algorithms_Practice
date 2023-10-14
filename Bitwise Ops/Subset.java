import java.util.*;

class Subset {

    void printSubset(String str[]) {
        int n = str.length;
        int powSize = (int) Math.pow(2, n);
        for (int counter = 0; counter < powSize; counter++) {
            for (int j = 0; j < n; j++) {
                if ((counter & (1 << j)) != 0) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        
        Subset obj = new Subset();
        String str[] = {"a","b","c"};
        obj.printSubset(str);
    }
}