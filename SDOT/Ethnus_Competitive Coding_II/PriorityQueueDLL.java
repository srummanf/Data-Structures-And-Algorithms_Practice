// Node class representing each element of the Priority Queue
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

// Priority Queue class
public class PriorityQueueDLL {
    Node head; // Head of the Priority Queue

    public PriorityQueueDLL() {
        this.head = null;
    }

    // Function to insert an element into the Priority Queue
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the Priority Queue is empty or the new node has higher priority than the
        // head
        if (head == null || newNode.data < head.data) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;
            // Traverse the Priority Queue to find the correct position to insert the new
            // node
            while (current.next != null && current.next.data <= newNode.data) {
                current = current.next;
            }
            // Insert the new node after the current node
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Function to print the elements of the Priority Queue
    public void display() {
        Node current = head;
        System.out.print("Priority Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a Priority Queue
        PriorityQueueDLL pq = new PriorityQueueDLL();

        // Insert elements into the Priority Queue
        pq.insert(10);
        pq.insert(30);
        pq.insert(20);
        pq.insert(5);

        // Display the Priority Queue
        pq.display();
    }
}
