import java.util.*;

class G_5_BFS {

  // Function to return Breadth First Traversal of given graph.
  public ArrayList<Integer> bfsOfGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    int src
  ) {
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean vis[] = new boolean[V];
    Queue<Integer> q = new LinkedList<>();

    q.add(src);
    vis[src] = true;

    while (!q.isEmpty()) {
      int node = q.poll();
      bfs.add(node);

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      for (int it : adj.get(node)) {
        if (vis[it] == false) {
          vis[it] = true;
          q.add(it);
        }
      }
    }

    return bfs;
  }

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(4);
    adj.get(4).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);

    G_5_BFS sl = new G_5_BFS();
    int src = 0;
    int src = 0;
    ArrayList<Integer> ans = sl.bfsOfGraph(5, adj, src);
    int n = ans.size();
    for (int i = 0; i < n; i++) {
      System.out.print(ans.get(i) + " ");
    }
  }
}
