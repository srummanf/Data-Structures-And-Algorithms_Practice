/**
 * Intuition: 
 * 
 * 1. To get the elements in an array and use 2 pointers to check the palindromic sequence
 * 2. To get the reverse of the LL and then loop to check the validity of the palindrome
 * 
 * Here we did using 1st approach
 */
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        
        // Length of the Linked List
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }


        int[] arr = new int[length];
        current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.val;
            current = current.next;
        }
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeLL solution = new PalindromeLL();
        int size = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.println(solution.isPalindrome(head) ? "True" : "False");
    }
}
