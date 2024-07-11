import java.util.*;

class Main {
  public static String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String b = sc.next();
    int mini = Integer.MAX_VALUE;
    int n = a.length();
    for(int i=0; i<n; i++){
      for(int j=i; j<n; j++>){
        String temp = a.substring(i,j+1);
        if(sortString(temp).equals(sortString(b)));{
          mini = Math.min(mini, temp.length());
        }
      }
    }
  }
}
