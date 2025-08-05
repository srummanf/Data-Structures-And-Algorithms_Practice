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

  public void bellmanFord(int startVertex) {
    int[] distance = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[startVertex] = 0;

    // Relax all edges |V| - 1 times
    for (int i = 0; i < V - 1; i++) {
      for (int j = 0; j < V; j++) {
        for (Node node : adj.get(j)) {
          if (
            distance[j] != Integer.MAX_VALUE &&
            distance[j] + node.weight < distance[node.vertex]
          ) {
            distance[node.vertex] = distance[j] + node.weight;
          }
        }
      }
    }

    // Check for negative cycles
    for (int i = 0; i < V - 1; i++) {
      for (int j = 0; j < V; j++) {
        for (Node node : adj.get(j)) {
          if (
            distance[j] != Integer.MAX_VALUE &&
            distance[j] + node.weight < distance[node.vertex]
          ) {
            System.out.println("Graph contains negative cycle");
            return;
          }
        }
      }
    }

    // Print the distances
    System.out.println("Vertex\tDistance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i + "\t" + distance[i]);
    }
  }
}

public class BellmanFord {

  public static void main(String[] args) {
    int V = 5; // Number of vertices
    int source = 0; // Source vertex
    Graph graph = new Graph(V);
    // graph.addEdge(0, 1, 2);
    // graph.addEdge(0, 3, 1);
    // graph.addEdge(1, 2, 3);
    // graph.addEdge(1, 3, 2);
    // graph.addEdge(3, 4, 4);
    // graph.addEdge(4, 2, 1);
    graph.addEdge(0, 1, 2);
    graph.addEdge(0, 3, 1);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(3, 4, -4);
    graph.addEdge(4, 2, 1);

    graph.bellmanFord(source);
  }
}
