class UnionFind {
    private int[] parent;    // Parent array to represent the disjoint set forest
    private int[] size;      // Size array to count the number of elements in each set
    public int count;        // Count of distinct sets

    // Constructor initializes each node in its own set with size 1
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    // Find the root of the set in which element x is present
    // Uses path compression for efficiency
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    // Union function to merge sets containing elements 'a' and 'b'
    // Returns true if a merge happened, false if already in the same set
    public boolean union(int a, int b) {
        int rootA = find(a - 1), rootB = find(b - 1);
        if (rootA == rootB) {
            return false;  // Already in the same set
        }
        if (size[rootA] > size[rootB]) {  // Merge smaller set into larger set
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        --count;  // Decrease the number of sets
        return true;
    }
}

class Solution {
    // Function to find the maximum number of edges that can be removed from the input graph
    // Returns -1 if Alice and Bob cannot both traverse the entire graph
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceSet = new UnionFind(n);
        UnionFind bobSet = new UnionFind(n);
        int numEdgesToRemove = 0;  // Tracks the number of edges we can remove

        // First, process type 3 edges which are shared by Alice and Bob
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 3) {
                // Union operations for shared edges. If union operation fails
                // (i.e., edge is redundant), increment numEdgesToRemove.
                if (!aliceSet.union(u, v)) {
                    numEdgesToRemove++;
                } else {
                    bobSet.union(u, v);  // We can safely ignore return val since aliceSet succeeded
                }
            }
        }

        // Process Alice-only and Bob-only edges
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 1 && !aliceSet.union(u, v)) {  // Alice-only edge
                numEdgesToRemove++;  // If edge is already connected then increment the removal count
            }
            if (type == 2 && !bobSet.union(u, v)) {  // Bob-only edge
                numEdgesToRemove++;  // If edge is already connected then increment the removal count
            }
        }

        // If both Alice's and Bob's sets are fully connected (i.e., count is 1 for both),
        // return number of edges removed. Otherwise, return -1 since they cannot
        // both traverse the entire graph.
        return (aliceSet.count == 1 && bobSet.count == 1) ? numEdgesToRemove : -1;
    }
}