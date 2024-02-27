
/*****************************************************************************
Given a string in which the same characters are repeated . Your task is to find the characters which have even freq and are consecutive. Print the sum of such string
*******************************************************************************/
import java.util.*;

public class CharacterEvenSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        s = s + " ";
        int len = s.length();
        int count = 1, sum = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count % 2 == 0) {
                    sum += count;
                }
                count = 1;
            }
        }

        System.out.println("Sum is " + sum);
    }
}