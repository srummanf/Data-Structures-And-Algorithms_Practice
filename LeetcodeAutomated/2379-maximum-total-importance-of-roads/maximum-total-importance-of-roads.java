class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long sum = 0;

        // Array to store the degree (number of connections) of each city
        int[] degree = new int[n];

        // Count the degree for each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Create a list of cities with their degrees
        List<int[]> cityDegree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cityDegree.add(new int[]{i, degree[i]});
        }

        // Sort cities based on their degrees in descending order
        cityDegree.sort((a, b) -> b[1] - a[1]);

        // Assign values from n to 1 based on sorted order
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[cityDegree.get(i)[0]] = n - i;
        }

        // Calculate the total importance of all roads
        for (int[] road : roads) {
            sum += values[road[0]] + values[road[1]];
        }

        return sum;
    }
}


// class Solution {
//     public long maximumImportance(int n, int[][] roads) {
//         long sum = 0;

//         List<List<Integer>> adj = new ArrayList<>();

//         for(int i=0; i<n; i++){
//             adj.add(new ArrayList<>());
//         }

//         int r = roads.length;

//         for(int i = 0 ; i<r; i++){
//             int a = roads[i][0];
//             int b = roads[i][1];

//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }

//         // adj.sort(Comparator.comparingInt(List::size));
//         System.out.println(adj);

//         ArrayList<Integer> vals = new ArrayList<>();

//         for(int i = 0 ; i<n; i++){
//             vals.add(adj.get(i).size());
//         }
        
//         System.out.println(vals);

//         for(int i = 0 ; i<r; i++){
//             int a = roads[i][0];
//             int b = roads[i][1];

//             sum += vals.get(a) + vals.get(b);
//         }
            
//         return sum;
//     }
// }