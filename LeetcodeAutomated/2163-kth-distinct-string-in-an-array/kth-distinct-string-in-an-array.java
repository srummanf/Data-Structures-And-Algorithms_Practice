class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedList<String> ll = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        for(String s : arr){
            if(!hash.contains(s)){
                ll.add(s);
                hash.add(s);
            } else {
                ll.remove(s);
            }
        }
        return ll.size()<k?"":ll.get(k-1);
    }
}