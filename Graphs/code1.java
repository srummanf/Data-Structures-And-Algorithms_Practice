import java.util.*;

public class code1 {

  static class Edge {

    int src, dest, weight;

    public Edge(int s, int d, int w) {
      src = s;
      dest = d;
      weight = w;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 2, 2));

    graph[1].add(new Edge(1, 2, 10));
    graph[1].add(new Edge(1, 3, 0));

    graph[2].add(new Edge(2, 0, 2));
    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, -1));

    graph[3].add(new Edge(3, 1, 0));
    graph[3].add(new Edge(3, 2, -1));
  }

  public static void BFS(
    ArrayList<Edge> graph[],
    int V,
    boolean visited[],
    int start
  ) {
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    while (!q.isEmpty()) {
      int curr = q.remove();
      if (visited[curr] == false) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          q.add(e.dest);
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];

    createGraph(graph);

    // print 2's neighbours
    for (int i = 0; i < graph[2].size(); i++) {
      Edge e = graph[2].get(i);
      System.out.println(e.src + " --> " + e.dest + " with weight " + e.weight);
    }
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        BFS(graph, V, visited, i);
      }
    }
  }
}
