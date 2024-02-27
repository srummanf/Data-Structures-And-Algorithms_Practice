import java.util.*;
public class PalindromicLLusingCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        LinkedList<Integer> ll = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();
        int count = 0;
        while (val != -1) {
            ll.add(val);
            count++;
            ll2.addFirst(val);
            val = sc.nextInt();
        }
        int check = 1;
        for (int i = 0; i <= count / 2; i++) {
            if (ll.get(i) != ll2.get(i)) {
                check = 0;
                break;
            }
        }

        if (check == 1)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}

