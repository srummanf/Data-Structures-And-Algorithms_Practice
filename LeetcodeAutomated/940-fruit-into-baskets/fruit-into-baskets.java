// class Solution {
//     public int totalFruit(int[] fruits) {
//         HashSet<Integer> h = new HashSet<>();
//         int l = 0;
//         int r = 0;
//         int n = fruits.length;
//         int maxi = 0;
//         while (r < n) {
//             if (h.size() > 2) {
//                 while (h.size() > 2) {
//                     h.remove(fruits[l]);
//                     l++;
//                 }
//             }


//             if (h.contains(fruits[r]) == false) {
//                 h.add(fruits[r]);
//             }
            

//             maxi = Math.max(maxi, (r - l + 1));

//             r++;
//         }

//         return maxi;

//     }
// }


class Solution {
    public int totalFruit(int[] fruits) {
        // Use a HashMap to store the count of each fruit type
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int l = 0, r = 0;
        int n = fruits.length;
        int maxi = 0;

        while (r < n) {
            // Add the current fruit to the map
            fruitCount.put(fruits[r], fruitCount.getOrDefault(fruits[r], 0) + 1);
            
            // If we have more than 2 types of fruits, shrink the window from the left
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[l], fruitCount.get(fruits[l]) - 1);
                if (fruitCount.get(fruits[l]) == 0) {
                    fruitCount.remove(fruits[l]);
                }
                l++;
            }
            
            // Update the maximum number of fruits we can collect
            maxi = Math.max(maxi, r - l + 1);
            
            r++;
        }

        return maxi;
    }
}
