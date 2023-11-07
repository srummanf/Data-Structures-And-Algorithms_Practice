import java.util.*;

public class Test {

  public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        ArrayList<Double> time = new ArrayList<>();
        for(int i=0; i<n;i++){
            time.add((double)dist[i]/speed[i]);
        }
        Collections.sort(time);

        int count=1;
        int time_passed=1;

        for(int i=1; i<n;i++){
            if((time.get(i)-time_passed) <= 0){
                return count;
            }
            count++;
            time_passed +=1;
        }


        return count;
        
    }

  public static void main(String[] args) {
    Test t = new Test();
    int dist[] = {3,5,7,4,5};
    int speed[] = {2,3,6,3,2};
    System.out.println(t.eliminateMaximum(dist, speed));
  }
}
