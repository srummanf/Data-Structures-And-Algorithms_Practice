import java.util.*;

public class LastStoneWin {

  public int lastStoneWeight(int[] stones) {
    // for max heap
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : stones) {
      pq.add(i);
    }
    while(pq.size() > 1){
        int a =  pq.poll();
        int b =  pq.poll();{
            if( a != b){
                a = a-b;
                pq.add(a);
            }
        }
    }
    return pq.size()==0?0:pq.poll();
    
  }
  public static void main(String[] args) {
    int stones[] = {2,7,4,1,8,1};
    LastStoneWin ob = new LastStoneWin();
    System.out.println(ob.lastStoneWeight(stones));
  }
}
