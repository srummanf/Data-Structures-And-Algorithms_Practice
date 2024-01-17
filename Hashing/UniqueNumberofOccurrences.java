/*
1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int x : arr){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            ar.add(e.getValue());
        }
        Collections.sort(ar);
        int n = ar.size();
        for(int i = 0; i<n-1; i++){
            if(ar.get(i) == ar.get(i+1)){
                return false;
            }
        }
        return true;
        
    }
}
