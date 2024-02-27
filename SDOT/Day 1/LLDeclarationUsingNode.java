

import java.util.*;

public class LLDeclarationUsingNode {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    public static Node insert(Node head, int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newnode;
        }
        return head;
    }

    public static void printList(Node head) {
        Node currNode = head;

        // System.out.print("LinkedList: ");

        while (currNode != null) {

            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // head = insert(head, 1);
        // head = insert(head, 2);
        // head = insert(head, 4);
        // head = insert(head, 4);

        for (int i = 1;; i++) {
            System.out.print("Enter val : ");
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            head = insert(head, n);
        }

        printList(head);

    }
}