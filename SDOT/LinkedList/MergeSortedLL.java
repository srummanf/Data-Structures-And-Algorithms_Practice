import java.util.*;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }

}

class MergeSortedLL {
  public static Node insert(Node head, int val) {
    Node temp = head;

    Node newNode = new Node(val);
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

  public static Node merge(Node head1, Node head2) {
    Node temp = head1;
    Node temp2 = head2;
    Node res = null;
    while (temp != null && temp2 != null) {
      if (temp.data > temp2.data) {
        res = insert(res, temp2.data);
        temp2 = temp2.next;
      } else {
        res = insert(res, temp.data);
        temp = temp.next;
      }
    }
    while (temp != null) {
      res = insert(res, temp.data);
      temp = temp.next;
    }
    while (temp2 != null) {
      res = insert(res, temp2.data);
      temp2 = temp2.next;
    }
    return res;
  }

  public static void printlist(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.print("NULL");

  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N1 = sc.nextInt();
    Node head1 = null;
    for (int i = 0; i < N1; i++) {
      int val = sc.nextInt();
      head1 = insert(head1, val);
    }
    int N2 = sc.nextInt();
    Node head2 = null;
    for (int j = 0; j < N2; j++) {
      int val = sc.nextInt();
      head2 = insert(head2, val);
    }

    Node res1 = merge(head1, head2);
    printlist(res1);
  }
}