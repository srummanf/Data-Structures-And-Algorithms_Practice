import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    int cap;
    LinkedList<Integer> order;
    HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cap = capacity;
        order = new LinkedList<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // Move the accessed key to the front of the list
            order.remove((Integer) key); // Remove the old position
            order.addFirst(key); // Add it to the front
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value and move the key to the front of the list
            cache.put(key, value);
            order.remove((Integer) key); // Remove the old position
            order.addFirst(key); // Add it to the front
        } else {
            if (order.size() >= cap) {
                // Remove the least recently used key
                int lru = order.pollLast();
                cache.remove(lru);
            }
            // Add the new key-value pair
            cache.put(key, value);
            order.addFirst(key); // Add to the front
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
