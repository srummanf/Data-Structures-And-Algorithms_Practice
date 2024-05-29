class Solution {
    public String defangIPaddr(String address) {
        String ans = address.replace(".", "[.]");
        return ans;
        
    }
}