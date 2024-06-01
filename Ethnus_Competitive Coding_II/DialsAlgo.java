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

  public void dijkstra(int startVertex) {
    int[] distance = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);

    distance[startVertex] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>(
      Comparator.comparingInt(node -> node.weight)
    );

    pq.add(new Node(startVertex, 0));
    while (!pq.isEmpty()) {
      int currentVertex = pq.poll().vertex;
      for (Node neighbor : adj.get(currentVertex)) {
        int newDist = distance[currentVertex] + neighbor.weight;
        if (newDist < distance[neighbor.vertex]) {
          distance[neighbor.vertex] = newDist;
          pq.add(new Node(neighbor.vertex, newDist));
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

public class DialsAlgo {

  public static void main(String[] args) {
    int V = 5; // Number of vertices
    int source = 0; // Source vertex
    Graph graph = new Graph(V);
    graph.addEdge(0, 1, 2);
    graph.addEdge(0, 3, 1);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(3, 4, -4);
    graph.addEdge(4, 2, 1);

    graph.dijkstra(source);
  }
}
