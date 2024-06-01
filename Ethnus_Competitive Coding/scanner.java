import java.util.*;

public class scanner {
    public static void main(String args[]) {
        String str = "Codemithra/is/a/learning/platform/";
        Scanner sc = new Scanner(str);
        sc.useDelimiter("/");
        System.out.println("---Result---");
        System.out.println("---Result---");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        System.out.println("Delimiter used: " + sc.delimiter());
    }
}
