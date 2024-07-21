Here's a well-formatted Markdown table for the worst-case time complexities of Java built-in methods:

### Time Complexities of Java Built-in Methods

#### **String**

| Method                                                     | Complexity |
| ---------------------------------------------------------- | ---------- |
| `new String("str")`                                      | O(n)       |
| `"str1" + "str2"`                                        | O(n)       |
| `concat(String str)`                                     | O(n)       |
| `StringBuilder append()`                                 | O(1)       |
| `length()`                                               | O(1)       |
| `charAt(int index)`                                      | O(1)       |
| `indexOf(int ch)`                                        | O(n)       |
| `indexOf(int ch, int fromIndex)`                         | O(n)       |
| `indexOf(String str)`                                    | O(n)       |
| `indexOf(String str, int fromIndex)`                     | O(n)       |
| `lastIndexOf(int ch)`                                    | O(n)       |
| `lastIndexOf(int ch, int fromIndex)`                     | O(n)       |
| `lastIndexOf(String str)`                                | O(n)       |
| `lastIndexOf(String str, int fromIndex)`                 | O(n)       |
| `substring(int beginIndex)`                              | O(n)       |
| `substring(int beginIndex, int endIndex)`                | O(n)       |
| `toLowerCase()`                                          | O(n)       |
| `toUpperCase()`                                          | O(n)       |
| `contains(CharSequence charSeq)`                         | O(n)       |
| `equals(Object obj)`                                     | O(n)       |
| `equalsIgnoreCase(String str)`                           | O(n)       |
| `startsWith(String prefix)`                              | O(n)       |
| `endsWith(String suffix)`                                | O(n)       |
| `replace(char oldChar, char newChar)`                    | O(n)       |
| `replace(CharSequence target, CharSequence replacement)` | O(n)       |
| `replaceAll(String regex, String replacement)`           | O(n)       |
| `split(String regex)`                                    | O(n)       |
| `split(String regex, int limit)`                         | O(n)       |
| `toCharArray()`                                          | O(n)       |
| `isEmpty()`                                              | O(1)       |
| `isBlank()`                                              | O(n)       |
| `strip()`                                                | O(n)       |
| `stripLeading()`                                         | O(n)       |
| `stripTrailing()`                                        | O(n)       |
| `trim()`                                                 | O(n)       |
| `indent(int numberSpaces)`                               | O(n)       |
| `stripIndent()`                                          | O(n)       |
| `translateEscapes()`                                     | O(n)       |
| `format(String format, Object args...)`                  | O(n)       |
| `formatted(Object args...)`                              | O(n)       |

#### **StringBuilder**

| Method                                                      | Complexity |
| ----------------------------------------------------------- | ---------- |
| `new StringBuilder("sb")`                                 | O(n)       |
| `append(String str)`                                      | O(1)       |
| `append(int i)`                                           | O(1)       |
| `append(double d)`                                        | O(1)       |
| `insert(int offset, String str)`                          | O(n)       |
| `delete(int startIndex, int endIndex)`                    | O(n)       |
| `deleteCharAt(int index)`                                 | O(n)       |
| `replace(int startIndex, int endIndex, String newString)` | O(n)       |
| `reverse()`                                               | O(n)       |
| `setCharAt(int index, char ch)`                           | O(1)       |
| `substring(int beginIndex)`                               | O(n)       |
| `substring(int beginIndex, int endIndex)`                 | O(n)       |
| `length()`                                                | O(1)       |
| `charAt(int index)`                                       | O(1)       |
| `toString()`                                              | O(n)       |

#### **ArrayList** (implements List interface)

| Method                          | Complexity |
| ------------------------------- | ---------- |
| `get(int index)`              | O(1)       |
| `remove(int index)`           | O(n)       |
| `remove(E element)`           | O(n)       |
| `Iterator.remove()`           | O(n)       |
| `add(int index, E element)`   | O(n)       |
| `add(E element)`              | O(1)       |
| `ListIterator.add(E element)` | O(n)       |
| `contains(Object o)`          | O(n)       |
| `set(int index, E element)`   | O(1)       |
| `indexOf(Object o)`           | O(n)       |
| `lastIndexOf(Object o)`       | O(n)       |
| `clear()`                     | O(n)       |
| `size()`                      | O(1)       |
| `isEmpty()`                   | O(1)       |

#### **LinkedList** (implements List and Deque interfaces)

| Method                          | Complexity |
| ------------------------------- | ---------- |
| `get(int index)`              | O(n)       |
| `remove(int index)`           | O(n)       |
| `remove(E element)`           | O(n)       |
| `Iterator.remove()`           | O(1)       |
| `add(int index, E element)`   | O(n)       |
| `add(E element)`              | O(1)       |
| `ListIterator.add(E element)` | O(1)       |
| `contains(Object o)`          | O(n)       |
| `set(int index, E element)`   | O(1)       |
| `indexOf(Object o)`           | O(n)       |
| `lastIndexOf(Object o)`       | O(n)       |
| `clear()`                     | O(n)       |
| `size()`                      | O(1)       |
| `isEmpty()`                   | O(1)       |

#### **HashSet** (implements Set interface)

| Method                 | Complexity |
| ---------------------- | ---------- |
| `add(E element)`     | O(1)       |
| `contains(Object o)` | O(1)       |
| `remove(Object o)`   | O(1)       |
| `size()`             | O(1)       |
| `isEmpty()`          | O(1)       |
| `clear()`            | O(n)       |
| `toArray()`          | O(n)       |

#### **TreeSet** (implements Set interface)

| Method                 | Complexity |
| ---------------------- | ---------- |
| `add(E element)`     | O(logn)    |
| `contains(Object o)` | O(logn)    |
| `remove(Object o)`   | O(logn)    |
| `size()`             | O(1)       |
| `isEmpty()`          | O(1)       |
| `clear()`            | O(n)       |
| `first()`            | O(logn)    |
| `last()`             | O(logn)    |
| `lower(E element)`   | O(logn)    |
| `higher(E element)`  | O(logn)    |
| `floor(E element)`   | O(logn)    |
| `ceiling(E element)` | O(logn)    |
| `toArray()`          | O(n)       |

#### **HashMap** (implements Map interface)

| Method                                       | Complexity |
| -------------------------------------------- | ---------- |
| `containsKey(Object key)`                  | O(n)       |
| `containsValue(Object value)`              | O(n)       |
| `get(Object key)`                          | O(n)       |
| `getOrDefault(Object key, V defaultValue)` | O(n)       |
| `put(K key, V value)`                      | O(n)       |
| `putIfAbsent(K key, V value)`              | O(n)       |
| `remove(Object key)`                       | O(n)       |
| `remove(Object key, Object value)`         | O(n)       |
| `replace(K key, V value)`                  | O(n)       |
| `replace(K key, V oldValue, V newValue)`   | O(n)       |
| `size()`                                   | O(1)       |
| `isEmpty()`                                | O(1)       |
| `clear()`                                  | O(n)       |
| `keySet()`                                 | O(1)       |
| `values()`                                 | O(1)       |
| `entrySet()`                               | O(1)       |

#### **TreeMap** (implements Map interface)

| Method                                       | Complexity |
| -------------------------------------------- | ---------- |
| `containsKey(Object key)`                  | O(logn)    |
| `containsValue(Object value)`              | O(n)       |
| `get(Object key)`                          | O(logn)    |
| `getOrDefault(Object key, V defaultValue)` | O(logn)    |
| `put(K key, V value)`                      | O(logn)    |
| `putIfAbsent(K key, V value)`              | O(logn)    |
| `remove(Object key)`                       | O(logn)    |
| `size()`                                   | O(1)       |
| `isEmpty()`                                | O(1)       |
| `clear()`                                  | O(n)       |
| `keySet()`                                 | O(1)       |
| `values()`                                 | O(1)       |
| `entrySet()`                               | O(1)       |
| `firstKey()`                               | O(logn)    |
| `lastKey()`                                | O(logn)    |
| `lowerKey(K key)`                          | O(logn)    |
| `floorKey(K key)`                          | O(logn)    |
| `ceilingKey(K key)`                        | O(logn)    |
| `higherKey(K key)`                         | O(logn)    |

#### **PriorityQueue** (implements Queue interface)

| Method               | Complexity |
| -------------------- | ---------- |
| `add(E element)`   | O(logn)    |
| `offer(E element)` | O(logn)    |
| `element()`        | O(1)       |
| `peek()`           | O(1)       |
| `remove()`         | O(logn)    |
| `poll()`           | O(logn)    |
| `size()`           | O(1)       |

#### **ArrayDeque** (implements Deque interface)

| Method                    | Complexity |
| ------------------------- | ---------- |
| `addFirst(E element)`   | O(1)       |
| `offerFirst(E element)` | O(1)       |
| `push(E element)`       | O(1)       |
| `addLast(E element)`    | O(1)       |
| `offerLast(E element)`  | O          |
