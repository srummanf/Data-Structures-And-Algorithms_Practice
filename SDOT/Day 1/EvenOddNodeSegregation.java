import java.util.*;

class node {
    int data;
    node next;

    public node(int val) {
        data = val;
        next = null;
    }
}

class LinkedList {
    node head, temp;

    public LinkedList() {
        head = temp = null;
    }

    public void insert(int val) {
        node newnode = new node(val);
        if (head == null)
            head = temp = newnode;
        else {
            // temp = head;
            // while(temp.next!=null)
            // temp = temp.next;

            temp.next = newnode;
            temp = newnode;
        }
    }

    public void display() {
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}

public class EvenOddNodeSegregation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        LinkedList ll = new LinkedList();
        while (val != -1) {
            ll.insert(val);
            val = sc.nextInt();
        }
        // ll.display();

        LinkedList ll2 = new LinkedList();
        node temp2 = ll.head;
        while (temp2 != null) {
            if (temp2.data % 2 != 0)
                ll2.insert(temp2.data);

            temp2 = temp2.next;
        }
        temp2 = ll.head;
        while (temp2 != null) {
            if (temp2.data % 2 == 0)
                ll2.insert(temp2.data);

            temp2 = temp2.next;
        }
        ll2.display();
    }
}
