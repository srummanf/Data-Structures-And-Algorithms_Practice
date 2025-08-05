import java.util.*;

class Graph {

  static class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

  private int V;
  private List<List<Node>> adj;

  public Graph(int V) {
    this.V = V;
    adj = new ArrayList<>(V);
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public void addEdge(int source, int destination, int weight) {
    Node node = new Node(destination, weight);
    adj.get(source).add(node);
  }

  public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;
    for (Node neighbor : adj.get(v)) {
      if (!visited[neighbor.vertex]) {
        topologicalSortUtil(neighbor.vertex, visited, stack);
      }
    }
    stack.push(v);
  }

  public void topologicalSort() {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topologicalSortUtil(i, visited, stack);
      }
    }

    // Print contents of stack
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}

public class TopologicalSort {

  public static void main(String[] args) {
    int V = 6; // Number of vertices
    Graph graph = new Graph(V);
    graph.addEdge(5, 2, 1);
    graph.addEdge(5, 0, 1);
    graph.addEdge(4, 0, 1);
    graph.addEdge(4, 1, 1);
    graph.addEdge(2, 3, 1);
    graph.addEdge(3, 1, 1);

    System.out.println("Topological Sort:");
    graph.topologicalSort();
  }
}

