import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void rotateList(int k) {
        if (head == null || head.next == null || k <= 0) {
            return;
        }

        int count = 1;
        Node current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = head;
        k = k % count;
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        head = current.next;
        current.next = null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int data;
        while ((data = sc.nextInt()) != -1) {
            list.insertAtEnd(data);
        }
        int rotations = sc.nextInt();
        System.out.println("Given linked list:");
        list.printList();
        list.rotateList(rotations);
        System.out.println("Rotated Linked list:");
        list.printList();

    }
}
