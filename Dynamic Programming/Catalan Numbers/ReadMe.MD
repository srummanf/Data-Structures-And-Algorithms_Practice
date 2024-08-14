### **Catalan Numbers**

Catalan numbers are a sequence of natural numbers with many applications in combinatorial mathematics. The nth Catalan number is given by the formula:

![1723544699773](image/ReadMe/1723544699773.png)

#### **Recursive Formula**:

Catalan numbers can also be defined recursively:

![1723544716868](image/ReadMe/1723544716868.png)

### **Applications of Catalan Numbers**

Catalan numbers appear in various counting problems, including:

1. **Valid Parentheses Combinations**:

   - The number of valid ways to arrange `n` pairs of parentheses.
2. **Binary Search Trees**:

   - The number of distinct binary search trees that can be constructed with `n` nodes.
3. **Triangulations**:

   - The number of ways to triangulate a convex polygon with `n + 2` sides.
4. **Mountain Ranges**:

   - The number of ways to draw n upstrokes and n downstrokes without the downstrokes going above the upstrokes.
5. **Dyck Paths**:

   - The number of paths along the edges of a grid that do not pass above the diagonal.

### **Code to Compute Catalan Numbers**

Here’s a simple dynamic programming approach to compute the nth Catalan number:

```java
// Catalan Numbers ==> Sum of f(i-1)*f(n-i)

class Solution {
    public int f(int[] dp, int n) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(dp, i - 1) * f(dp, n - i);
        }
        return ans;
    }

    public int nthCatalanNumber(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(dp, n);

    }
}
```

### **Applications on LeetCode**

Here are some LeetCode problems that involve Catalan numbers:

1. **[Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)** (LeetCode 96):

   - Given `n`, how many structurally unique BST's (binary search trees) that store values 1 ... n?
2. **[Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/)** (LeetCode 241):

   - Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
3. **[Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)** (LeetCode 22):

   - Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
4. **[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)** (LeetCode 20):

   - Although not directly related to Catalan numbers, understanding valid parentheses pairs can help with Catalan number applications.
5. **[Number of Valid Parentheses Combinations](https://leetcode.com/problems/number-of-valid-parentheses-combinations/)** (Custom problem):

   - A more direct problem would involve finding the number of valid parentheses combinations, which directly correlates with the nth Catalan number.

### **Summary**

Catalan numbers are incredibly versatile and appear in many combinatorial problems. Understanding how to compute them and recognizing when they apply can be powerful tools for solving a wide variety of problems, especially in competitive programming and algorithm challenges like those on LeetCode.
