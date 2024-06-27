import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        // Since it's a star graph, we can use the fact that the center node will appear in all the edges
        // More specifically, it will appear in the first two edges for sure
        // We can use this property to determine the center node

        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];
        int node4 = edges[1][1];
        
        if (node1 == node3 || node1 == node4) {
            return node1;
        } else {
            return node2;
        }
    }
}


// class Solution {
//     public int findCenter(int[][] edges) {

//         int r = edges.length;
//         int c = edges[0].length;

//         List<List<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i < r; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < r; i++) {
            
//                 adj.get(edges[i][1]).add(edges[i][0]);
//                 adj.get(edges[i][0]).add(edges[i][1]);
            
//         }

//         for (int i = 0; i < r; i++){
//             if(adj.get(i).size() == r){
//                 return i;
//             }
//         }

//         return -1;

//     }
// }