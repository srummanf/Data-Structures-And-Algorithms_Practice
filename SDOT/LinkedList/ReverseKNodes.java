
/**
 * Intuition : The code reverses groups of k elements in a linked list by using a stack to temporarily store elements. It iterates through the list once, pushing each element onto the stack, and when a group of k elements is encountered, it pops them from the stack, effectively reversing them, and prints them.
 * 
 * To analyze the time complexity and space complexity of the `reverse` method in the `ReverseKNodes` class, let's break down the operations performed:

1. **Creating a Stack:** 
   - Space Complexity: O(k), where k is the size of the stack. 

2. **Iterating through the Linked List:**
   - Time Complexity: O(n), where n is the number of elements in the linked list.

3. **Pushing elements to the Stack:**
   - Time Complexity: O(1) for each push operation.

4. **Popping elements from the Stack and Printing:**
   - Time Complexity: O(k) for each group of k elements being reversed.

5. **Printing the remaining elements after reversal:**
   - Time Complexity: O(n - loop), where loop is the number of elements that were already processed in multiples of k.

6. **Overall:**
   - The loop iterates n times.
   - Within the loop, the operations for pushing elements to the stack and popping them are performed.
   - Thus, the time complexity of the `reverse` method is O(n).
   - The space complexity mainly depends on the size of the stack, which can grow up to k elements.
   - So, the space complexity of the `reverse` method is O(k).

In summary:
- Time Complexity: O(n)
- Space Complexity: O(k)

These complexities are based on the assumption that the value of k is relatively small compared to the total number of elements in the linked list (i.e., k << n). If k approaches n, the space complexity could be O(n) in the worst case.

You're correct to consider the while loop inside the for loop:

```java
while (!st.isEmpty()) {
    System.out.print(st.pop() + " ");
}
```

This while loop is executed each time the conditional statement `i % k == 0` evaluates to true, which happens roughly every k iterations of the outer for loop. However, the number of elements processed by this while loop is bounded by k, not by n. 

So, the time complexity of this while loop is O(k), and since it is executed a maximum of n/k times in the worst case, its overall contribution to the time complexity of the `reverse` method remains O(n).

Therefore, considering all operations within the loop, including the while loop, the time complexity remains O(n), not O(n^2).
 */

import java.util.*;

public class ReverseKNodes {
    void reverse(LinkedList<Integer> ll, int k) {
        int n = ll.size();
        int a = n / k;
        int loop = k * a;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < loop; i++) {
            if (i % k == 0 && i != 0) {
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }

            }
            st.push(ll.get(i));

        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        for (int i = loop; i < n; i++) {
            System.out.print(ll.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseKNodes ob = new ReverseKNodes();
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the element: ");
            int a = sc.nextInt();
            ll.add(a);
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        ob.reverse(ll, k);
    }
}
