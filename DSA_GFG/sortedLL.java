// Sorted Insert in a Singly Linked List

import java.util.Scanner;

public class sortedLL {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void sortedInsert(Node new_node) {
        Node current;

        if (head == null || head.data >= new_node.data) {
            new_node.next = head;
            head = new_node;
        } else {
            current = head;

            while (current.next != null && current.next.data < new_node.data) {
                current = current.next;
            }

            new_node.next = current.next;
            current.next = new_node;
        }
    }

    Node newNode(int data) {
        Node x = new Node(data);
        return x;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        sortedLL llist = new sortedLL();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int data = scanner.nextInt();
            Node new_node = llist.newNode(data);
            llist.sortedInsert(new_node);
        }
        
        System.out.println("Created Linked List");
        llist.printList();
        
        scanner.close();
    }
}