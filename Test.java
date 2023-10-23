import java.util.*;

public class Test {

  public static void main(String[] args) {
    System.out.println("Hello World");
    ArrayList<Integer> precompute = new ArrayList<>();
    precompute.add(1);
    for (int i = 1; i <= 6; i++) {
      precompute.add(((precompute.get(i - 1) * 2) % 10000005));
    }
    System.out.println(precompute);
  }
}
