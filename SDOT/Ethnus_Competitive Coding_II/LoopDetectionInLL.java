
/**
 * Detect a loop in a linked list-Floyd’s Detection
 */
import java.util.*;

public class LoopDetectionInLL {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void detectLoopAndPrint() {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop found");
                return;
            }
        }
        System.out.println("Loop not found");
    }

    public static void main(String[] args) {
        LoopDetectionInLL list = new LoopDetectionInLL();

        list.push(20);
        list.push(41);
        list.push(5);
        list.push(10);
        // 5.Creating a loop for testing
        list.head.next.next.next.next = list.head;
        list.detectLoopAndPrint();
    }
}

// NOTES 

/**
 * - Detecting a loop in a linked list can be done using techniques like Floyd's
 * Cycle Detection algorithm or using a HashSet to track visited nodes [T1],
 * [T2].
 * - Floyd's Cycle Detection algorithm has a time complexity of O(n) and a space
 * complexity of O(1) as it uses two pointers, making it more memory-efficient
 * for large lists [T2], [T3].
 * - The time complexity of loop detection using Floyd's Cycle Detection is O(n)
 * because it makes at most two full passes over the list, and the space
 * complexity is O(1) as it only uses two pointers [T4].
 * - A singly linked list is a type of linked list where each node has a
 * reference to the next node in the list, allowing traversal in one direction
 * from the head to the tail [T5].
 * - Removing a loop in a linked list using Floyd's Cycle Detection has a time
 * complexity of O(1) as it involves setting the next of the previous node to
 * null, which takes constant time regardless of the list's size [T4].
 * - The space complexity of using Floyd's Cycle Detection for loop detection is
 * O(1) because it only uses a fixed amount of additional memory (two pointers)
 * regardless of the size of the linked list [T2], [T4].
 */



// MCQ Questions

/**
 * 
 * 1. What is a Singly Linked List?
 * A) A list where each node has a reference to the previous node
 * B) A list where each node has a reference to the next node ✅
 * C) A list where traversal can be done in both directions
 * D) A list where nodes are stored in contiguous memory locations
 * 
 * 2. Which algorithm is commonly used to detect loops in a linked list?
 * A) Depth-First Search
 * B) Breadth-First Search
 * C) Floyd's Cycle Detection ✅
 * D) Dijkstra's Algorithm
 * 
 * 3. In Floyd's Cycle Detection algorithm, how many pointers are used?
 * A) One
 * B) Two ✅
 * C) Three
 * D) Four
 * 
 * 4. What is the time complexity of Floyd's Cycle Detection algorithm?
 * A) O(1)
 * B) O(log n)
 * C) O(n) ✅
 * D) O(n^2)
 * 
 * 5. Which data structure can be used to track visited nodes in loop detection?
 * A) Stack
 * B) Queue
 * C) HashSet ✅
 * D) Binary Search Tree
 * 
 * 6. How does the Tortoise and Hare algorithm work in loop detection?
 * A) Both pointers move at the same speed
 * B) The tortoise moves faster than the hare
 * C) The hare moves faster than the tortoise ✅
 * D) The tortoise moves backwards
 * 
 * 7. What is the space complexity of using a HashSet for loop detection?
 * A) O(1)
 * B) O(log n)
 * C) O(n) ✅
 * D) O(n^2)
 * 
 * 8. Which type of linked list allows traversal in both directions?
 * A) Singly Linked List
 * B) Doubly Linked List ✅
 * C) Circular Linked List
 * D) Binary Linked List
 * 
 * 9. How can you remove a loop in a linked list?
 * A) Reverse the linked list
 * B) Use Floyd's Cycle Detection
 * C) Delete the last node
 * D) Set the next of the previous node to null ✅
 * 
 * 10. What is the time complexity of detecting a loop using HashSet?
 * A) O(1)
 * B) O(log n)
 * C) O(n) ✅
 * D) O(n^2)
 * 
 * 11. Which pointer in Floyd's Cycle Detection moves faster?
 * A) Slow pointer
 * B) Fast pointer ✅
 * C) Both move at the same speed
 * D) None of the above
 * 
 * 12. In a Circular Linked List, the last node points to:
 * A) Null
 * B) The first node ✅
 * C) The middle node
 * D) The previous node
 * 
 * 13. What is the purpose of using Floyd's Cycle Detection in a linked list?
 * A) To reverse the linked list
 * B) To detect and remove loops ✅
 * C) To sort the linked list
 * D) To add a new node at the end
 * 
 * 14. Which of the following is not a type of linked list?
 * A) Singly Linked List
 * B) Doubly Linked List
 * C) Triply Linked List ✅
 * D) Circular Linked List
 * 
 * 15. How many nodes are involved in creating a loop in a linked list?
 * A) 1
 * B) 2 ✅
 * C) 3
 * D) 4
 * 
 * 16. What is the time complexity of removing a loop in a linked list using
 * Floyd's Cycle Detection?
 * A) O(1) ✅ [ONLY TO REMOVE THE LOOP, NOT THE DETECTION]
 * B) O(log n)
 * C) O(n)
 * D) O(n^2)
 * 
 * 17. Which of the following is true about a Singly Linked List?
 * A) Each node has a reference to the previous node
 * B) Traversal can be done in both directions
 * C) Each node has a reference to the next node ✅
 * D) Nodes are stored in contiguous memory locations
 * 
 * 18. What is the starting node of a loop in a linked list?
 * A) Head node ✅
 * B) Tail node
 * C) Middle node
 * D) Random node
 * 
 * 19. Which algorithm uses two pointers, one slow and one fast, for loop
 * detection?
 * A) Depth-First Search
 * B) Breadth-First Search
 * C) Floyd's Cycle Detection ✅
 * D) Dijkstra's Algorithm
 * 
 * 20. What is the space complexity of using Floyd's Cycle Detection for loop
 * detection?
 * A) O(1) ✅
 * B) O(log n)
 * C) O(n)
 * D) O(n^2)
 * 
 * 
 */
