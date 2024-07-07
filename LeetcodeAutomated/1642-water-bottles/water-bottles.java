class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;  // Initialize the answer with the initial number of bottles.
        int emptyBottles = numBottles;  // The number of empty bottles initially.

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;  // Calculate how many new bottles you can get.
            ans += newBottles;  // Add the new bottles to the total.
            emptyBottles = newBottles + (emptyBottles % numExchange);  // Update the number of empty bottles.
        }

        return ans;
    }
}



// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
//         int ans = 0;
//         ans += numBottles;

//         int emptyBottles = numBottles;

//         while (emptyBottles > 0){
//             if (emptyBottles >= numExchange) {
//                 ans += emptyBottles / numExchange;
//                 emptyBottles -= (emptyBottles / numExchange)*numExchange;
//             }
//             emptyBottles += emptyBottles / numExchange;
//         } 

//         return ans;

//     }
// }