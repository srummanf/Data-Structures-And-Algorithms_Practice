
### AVL Tree: Theory and Properties

**AVL Tree** (Adelson-Velsky and Landis Tree) is a type of self-balancing binary search tree (BST). In an AVL tree, the heights of the two child subtrees of any node differ by at most one. If the difference becomes greater than one, the tree is rebalanced using **rotation operations**.

#### Key Properties of AVL Trees:

1. **Balance Factor**:

   - The balance factor of a node is defined as the difference between the height of its left and right subtrees.
   - `BalanceFactor = height(left_subtree) - height(right_subtree)`
   - An AVL tree requires the balance factor of every node to be in the range of `-1, 0, 1`.
2. **Height of AVL Tree**:

   - For an AVL tree with `n` nodes, the height is always O(log n). This ensures that operations such as insertion, deletion, and search have logarithmic time complexity.
3. **Rotations**:

   - To maintain the balance factor within the acceptable range, AVL trees use rotations. These are basic tree restructuring operations that help restore balance. There are four types of rotations:
     1. **Left Rotation (LL Rotation)**: Performed when a subtree becomes **right-heavy** due to insertion in the right subtree.
     2. **Right Rotation (RR Rotation)**: Performed when a subtree becomes **left-heavy** due to insertion in the left subtree.
     3. **Left-Right Rotation (LR Rotation)**: Performed when the left subtree of a node is **right-heavy** (i.e., first a left rotation on the left child and then a right rotation).
     4. **Right-Left Rotation (RL Rotation)**: Performed when the right subtree of a node is **left-heavy** (i.e., first a right rotation on the right child and then a left rotation).
4. **Imbalance Situations**:

   - **Left-Heavy Situation**: Occurs when the balance factor of a node is `> 1`. This means that the left subtree is taller than the right subtree.
   - **Right-Heavy Situation**: Occurs when the balance factor of a node is `< -1`. This means that the right subtree is taller than the left subtree.
5. **Rebalancing via Rotations**:

   - **Single Rotation**:
     - If a node becomes **left-heavy** due to insertion in the left subtree of its left child (LL Case), a **Right Rotation** is performed.
     - If a node becomes **right-heavy** due to insertion in the right subtree of its right child (RR Case), a **Left Rotation** is performed.
   - **Double Rotation**:
     - In the case of an **LR imbalance** (insertion in the right subtree of the left child), an **LR Rotation** (left rotation followed by right rotation) is performed.
     - In the case of an **RL imbalance** (insertion in the left subtree of the right child), an **RL Rotation** (right rotation followed by left rotation) is performed.

#### Operations in an AVL Tree:

1. **Insertion**:

   - When a node is inserted, the balance factor of each node on the path from the inserted node to the root is updated. If the balance factor of any node goes outside the range `[-1, 1]`, rotations are performed to restore balance.
   - Time Complexity: O(log n).
2. **Deletion**:

   - Deleting a node from an AVL tree can cause imbalances. After deletion, the heights and balance factors are updated, and rotations are performed to restore balance.
   - Time Complexity: O(log n).
3. **Traversal**:

   - AVL trees can be traversed in the same way as any binary tree (in-order, pre-order, post-order).
   - In-order traversal of an AVL tree always produces a sorted sequence of the data.
4. **Searching**:

   - The search operation in an AVL tree is similar to that in a regular binary search tree. However, due to the self-balancing property, the height of the tree remains O(log n), ensuring efficient search operations.
   - Time Complexity: O(log n).

#### Special Cases in AVL Tree:

1. **Left-Left (LL) Case**:

   - A node becomes left-heavy because an element is inserted in the left subtree of its left child. It is solved by a single **Right Rotation**.
2. **Right-Right (RR) Case**:

   - A node becomes right-heavy because an element is inserted in the right subtree of its right child. It is solved by a single **Left Rotation**.
3. **Left-Right (LR) Case**:

   - A node becomes left-heavy because an element is inserted in the right subtree of its left child. It is solved by performing a **Left Rotation** on the left child, followed by a **Right Rotation** on the node.
4. **Right-Left (RL) Case**:

   - A node becomes right-heavy because an element is inserted in the left subtree of its right child. It is solved by performing a **Right Rotation** on the right child, followed by a **Left Rotation** on the node.

#### Time Complexity of AVL Tree Operations:

- **Insertion**: O(log n)
- **Deletion**: O(log n)
- **Searching**: O(log n)
- **Traversal**: O(n)

#### Advantages of AVL Trees:

- **Balanced Height**: AVL trees maintain a logarithmic height, ensuring efficient time complexity for search, insertion, and deletion operations.
- **Guaranteed Logarithmic Performance**: AVL trees provide better performance for search-heavy operations in comparison to other self-balancing trees such as Red-Black trees.

#### Disadvantages of AVL Trees:

- **More Rotations**: AVL trees may require more rotations during insertion and deletion compared to other balanced trees like Red-Black trees, which might make them less efficient for frequently updated datasets.

### Conclusion:

AVL trees are a robust choice for maintaining balanced binary search trees, ensuring efficient lookup, insertion, and deletion operations. Understanding the balance factor, rotations, and imbalance situations like left-heavy and right-heavy are crucial for AVL tree-related technical interview questions.

### AVL Tree Implementation in Java:

```java
class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
    }
}

class AVLTree {
    private Node root;

    // Get the height of the node
    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Calculate balance factor of the node
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a node into the AVL tree
    public Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node; // Duplicate data is not allowed

        // Update height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Get balance factor and balance the tree
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find the node with the minimum value
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node from the AVL tree
    public Node delete(Node root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        // If the tree had only one node, return
        if (root == null)
            return root;

        // Update height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get balance factor and balance the tree
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // In-order Traversal (Sorted order)
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    // Find maximum value in the AVL Tree
    public int findMax(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Tree is empty");

        while (node.right != null)
            node = node.right;
        return node.data;
    }

    // Find minimum value in the AVL Tree
    public int findMin(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Tree is empty");

        while (node.left != null)
            node = node.left;
        return node.data;
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Wrapper for inserting into the AVL tree
    public void insert(int data) {
        root = insert(root, data);
    }

    // Wrapper for deleting from the AVL tree
    public void delete(int data) {
        root = delete(root, data);
    }

    // Wrapper for in-order traversal
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    // Wrapper for finding maximum value
    public int findMax() {
        return findMax(root);
    }

    // Wrapper for finding minimum value
    public int findMin() {
        return findMin(root);
    }

    // Wrapper to check if the tree is empty
    public boolean isEmptyTree() {
        return isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        // In-order traversal
        System.out.print("In-order traversal: ");
        tree.inOrderTraversal();

        // Find min and max
        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());

        // Delete a node
        tree.delete(30);
        System.out.print("In-order traversal after deletion: ");
        tree.inOrderTraversal();

        // Check if tree is empty
        System.out.println("Is tree empty? " + tree.isEmptyTree());
    }
}
```

### Explanation:

1. **Insertion**: Inserts nodes while maintaining the balance of the AVL tree.
2. **Deletion**: Deletes a node and ensures the tree remains balanced.
3. **Traversal**: In-order traversal prints the tree nodes in sorted order.
4. **Max/Min**: Functions to find the maximum and minimum values in the tree.
5. **IsEmpty**: Checks if the tree is empty.
