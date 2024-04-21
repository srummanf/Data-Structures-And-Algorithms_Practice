class Solution {

    public boolean isPath(boolean vis[], ArrayList<Integer> graph[], int src, int dest ){
        if(src==dest) return true;
        vis[src] = true;
        for(int neighbour: graph[src]){
            if(vis[neighbour] == false){
                if(isPath(vis, graph, neighbour, dest)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       ArrayList<Integer> graph[] = new ArrayList[n];
       for(int i=0; i<n; i++){
        graph[i] = new ArrayList<Integer>();
       }
       for(int[] edge: edges){
        int v1 = edge[0];
        int v2 = edge[1];
        graph[v1].add(v2);
        graph[v2].add(v1);
       }    
       boolean vis[] = new boolean[n];
       return isPath(vis, graph, source, destination);
    }
}