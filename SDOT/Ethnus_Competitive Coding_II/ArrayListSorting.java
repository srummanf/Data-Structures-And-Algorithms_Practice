

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);
        numbers.add(7);

        System.out.println("Original ArrayList: " + numbers);

        // Sort the ArrayList in ascending order
        Collections.sort(numbers);
        System.out.println("Ascending order: " + numbers);

        // Sort the ArrayList in descending order
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending order: " + numbers);
    }
}
