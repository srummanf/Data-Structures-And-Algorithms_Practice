Certainly! Here's a table summarizing the different sorting methods using lambda expressions:

| **Use Case**                                              | **Sorting Criterion**                                                      | **Code**                                                                                                 |
| --------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **Ascending Order by Integer Field**                      | Integer field in ascending order                                                 | `people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));`                                        |
| **Ascending Order by String Field**                       | String field in ascending order                                                  | `people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));`                                             |
| **2D Array Ascending by First Element**                   | First element of 2D array in ascending order                                     | `Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));`                                                 |
| **Descending Order by Integer Field**                     | Integer field in descending order                                                | `people.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));`                                        |
| **Descending Order by String Field**                      | String field in descending order                                                 | `people.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));`                                             |
| **2D Array Descending by First Element**                  | First element of 2D array in descending order                                    | `Arrays.sort(array, (a, b) -> Integer.compare(b[0], a[0]));`                                                 |
| **PriorityQueue (Frequency Ascending, Value Descending)** | Frequency in ascending order, value in descending order if frequencies are equal | `pq = new PriorityQueue<>((a, b) -> a.get(0).equals(b.get(0)) ? b.get(1) - a.get(1) : a.get(0) - b.get(0));` |

### Ascending Order

Thank you for providing that comprehensive table. I'll add the comparator we discussed earlier to this table in a similar format:

| Use Case                                  | Sorting Criterion                                                                                | Code                                                                                                                                           |
| ----------------------------------------- | ------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------- |
| Sort by Mapped Value, then Original Index | First by mapped value (ascending), then by original index (ascending) if mapped values are equal | `Collections.sort(mappedList, (a, b) -> { if (a[0] != b[0]) { return Integer.compare(a[0], b[0]); } return Integer.compare(a[1], b[1]); });` |

This new entry fits well with the existing table, providing another example of a more complex comparator that sorts based on multiple criteria. Would you like me to explain how this comparator relates to or differs from the others in the table?

1. **Sort by an Integer Field:**

   ```java
   people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
   ```
2. **Sort by a String Field:**

   ```java
   people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
   ```
3. **Sort 2D Array by First Element (Ascending):**

   ```java
   Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
   ```

### Descending Order

1. **Sort by an Integer Field:**

   ```java
   people.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));
   ```
2. **Sort by a String Field:**

   ```java
   people.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
   ```
3. **Sort 2D Array by First Element (Descending):**

   ```java
   Arrays.sort(array, (a, b) -> Integer.compare(b[0], a[0]));
   ```

### PriorityQueue with Custom Comparator

1. **Sort by Frequency (Ascending) and Value (Descending) if Frequencies are Equal:**

   ```java
   pq = new PriorityQueue<>((a, b) -> a.get(0).equals(b.get(0)) ? b.get(1) - a.get(1) : a.get(0) - b.get(0));
   ```
