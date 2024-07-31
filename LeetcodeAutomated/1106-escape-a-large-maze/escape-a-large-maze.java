

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int BASE = (int) 1e6;
    private Set<Integer> blockedSet;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] * BASE + block[1]);
        }
      
        return isReachable(source, target, new HashSet<>()) && isReachable(target, source, new HashSet<>());
    }

    private boolean isReachable(int[] current, int[] target, Set<Integer> visited) {
        int x = current[0], y = current[1];
      
        if (x < 0 || x >= BASE || y < 0 || y >= BASE || blockedSet.contains(x * BASE + y) || visited.contains(x * BASE + y)) {
            return false;
        }
      
        visited.add(x * BASE + y);
      
        if (visited.size() > 20000 || (x == target[0] && y == target[1])) {
            return true;
        }
      
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isReachable(new int[] {newX, newY}, target, visited)) {
                return true;
            }
        }
      
        return false;
    }
}
