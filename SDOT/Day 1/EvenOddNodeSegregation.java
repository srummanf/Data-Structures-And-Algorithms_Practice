import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class EvenOddNodeSegregation {
    public static void main(String[] args) {
        Node prev, head, newNode;

        prev = new Node(-1);
        head = null;

        Scanner scanner = new Scanner(System.in);
        int i = 0, j = 1, ele = 0;
        while (i < j) {
            ele = scanner.nextInt();
            if (ele != -1) {
                newNode = new Node(ele);
                if (head == null)
                    head = newNode;
                else
                    prev.next = newNode;
                prev = newNode;
                j++;
            } else
                break;
        }

        Node slow = head;
        Node fast = head;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        Node prevNode = null;
        Node currentNode = slow;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        int palindrome = 1;
        // Compare the first half with the reversed second half
        Node firstHalf = head;
        Node secondHalf = prevNode;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = 0;
                break;
            } // Not a palindrome

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        if (palindrome == 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

