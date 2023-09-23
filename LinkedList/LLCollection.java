package LinkedList;
import java.util.Collection;
import java.util.LinkedList;

public class LLCollection {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst("Rumman");
        ll.addLast(2);

        System.out.println(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.peek());
    }

}
