/*
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list. The first node is considered odd, and the second node is even, and so on.



Note that the relative order inside both the even and odd groups should remain as it was in the input.





Sample Input:


5

1 2 3 4 5



Sample Output:

1 3 5 2 4


 */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class OddEvenLL {

    public static Node newNode(Node head, int data) {

        Node temp = head;
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;
        Node next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node oddevenlist(Node head) {
        if (head == null) {
            return null;
        }

        Node odd = head;
        Node even = head.next;

        Node evenHead = even;

        while (even != null && even.next != null) {

            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void printlist(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int data = 0;
        Node head = null;
        while (k-- != 0) {
            data = sc.nextInt();
            head = newNode(head, data);
        }

        Node newhead1 = oddevenlist(head);

        printlist(newhead1);

    }
}