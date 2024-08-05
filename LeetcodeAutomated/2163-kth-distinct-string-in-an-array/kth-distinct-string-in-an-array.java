class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hm = new HashMap<>();
        for (String s : arr) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        int ctr = 0;
        for (String s : arr) {
            if (hm.get(s) == 1) {
                ctr++;
                if (ctr == k) {
                    return s;
                }
            }
        }
        return "";
    }
}


// Solution 2:
// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         LinkedList<String> ll = new LinkedList<>();
//         HashSet<String> hash = new HashSet<>();
//         for(String s : arr){
//             if(!hash.contains(s)){
//                 ll.add(s);
//                 hash.add(s);
//             } else {
//                 ll.remove(s);
//             }
//         }
//         return ll.size()<k?"":ll.get(k-1);
//     }
// }