class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class BitonicDLL {
    Node head;

    public BitonicDLL() {
        this.head = null;
    }

    // Function to insert a node at the end of the DLL
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Function to find the peak element in the bitonic sequence
    public Node findPeak(Node head) {
        Node current = head;
        while (current.next != null && current.data < current.next.data) {
            current = current.next;
        }
        return current;
    }

    // Function to reverse a DLL
    public Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function to merge two sorted DLLs
    public Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.data < right.data) {
            left.next = merge(left.next, right);
            left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next.prev = right;
            right.prev = null;
            return right;
        }
    }

    // Function to sort a bitonic sequence in DLL
    public void sortBitonic() {
        if (head == null || head.next == null)
            return;

        Node peak = findPeak(head);

        // Split the DLL into two parts at the peak
        Node secondHalf = peak.next;
        peak.next = null;
        secondHalf.prev = null;

        // Reverse the second part of the DLL
        secondHalf = reverse(secondHalf);

        // Merge the two sorted halves
        head = merge(head, secondHalf);
    }

    // Function to print the DLL
    public void display() {
        Node current = head;
        System.out.print("Sorted Bitonic DLL: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BitonicDLL bitonicDLL = new BitonicDLL();

        // Insert elements into the DLL to form a bitonic sequence
        bitonicDLL.insert(1);
        bitonicDLL.insert(3);
        bitonicDLL.insert(5);
        bitonicDLL.insert(4);
        bitonicDLL.insert(2);

        // Sort the bitonic sequence
        bitonicDLL.sortBitonic();

        // Display the sorted DLL
        bitonicDLL.display();
    }
}
