// import java.util.*;

// class Graph_DFS {
//     private LinkedList<Integer> adjLists[];
//     private boolean visited[];

//     // Graph_DFS creation
//   Graph_DFS(int vertices) {
//     adjLists = new LinkedList[vertices];
//     visited = new boolean[vertices];
//     for (int i = 0; i < vertices; i++)
//       adjLists[i] = new LinkedList<Integer>();
//   }

//     // Add edges
//     void addEdge(int src, int dest) {
//         adjLists[src].add(dest);
//     }// DFS algorithm

//     void DFS(int vertex) {
//         visited[vertex] = true;
//         System.out.print(vertex + " ");
//         Iterator<Integer> ite = adjLists[vertex].listIterator();
//         while (ite.hasNext()) {
//             int adj = ite.next();
//             if (!visited[adj])
//                 DFS(adj);
//         }
//     }

//     public static void main(String args[]) {
//         Graph_DFS g = new Graph_DFS(4);

//         g.addEdge(0, 1);
//         g.addEdge(0, 2);
//         g.addEdge(1, 2);
//         g.addEdge(2, 3);

//         System.out.println("Following is Depth First Traversal");

//         g.DFS(2);
//     }
// }
import java.util.*;

public class Graph_DFS {
    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    Graph_DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS algorithm
    void DFS(int s) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            s = stack.pop();
            System.out.print(s + " ");
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph_DFS g = new Graph_DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.DFS(2);
    }
}
