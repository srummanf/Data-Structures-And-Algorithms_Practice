// class Solution {
//     public boolean canBeEqual(int[] target, int[] arr) {
//         HashMap<Integer, Integer> hash1 = new HashMap<>();
//         HashMap<Integer, Integer> hash2 = new HashMap<>();
//         for(int a : target){
//             hash1.put(a, hash1.getOrDefault(a,0)+1);
//         }
//          for(int a : arr){
//             hash2.put(a, hash2.getOrDefault(a,0)+1);
//         }

//         return hash1.equals(hash2);
        
//     }
// }

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(target[i]!=arr[i]) return false;
        }
        return true;
    }
}