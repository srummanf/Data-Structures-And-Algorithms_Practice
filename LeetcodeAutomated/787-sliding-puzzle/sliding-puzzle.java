import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String TARGET = "123450";
    private static final int ROWS = 2;
    private static final int COLS = 3;

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        if (start.equals(TARGET)) return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Set<String> visited = new HashSet<>();
        pq.offer(new Node(start, 0, heuristic(start)));
        visited.add(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.state.equals(TARGET)) {
                return current.moves;
            }

            int zeroIndex = current.state.indexOf('0');
            int zeroRow = zeroIndex / COLS;
            int zeroCol = zeroIndex % COLS;

            for (int[] dir : DIRS) {
                int newRow = zeroRow + dir[0];
                int newCol = zeroCol + dir[1];
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
                    int newIndex = newRow * COLS + newCol;
                    char[] newState = current.state.toCharArray();
                    swap(newState, zeroIndex, newIndex);
                    String newStateStr = new String(newState);

                    if (!visited.contains(newStateStr)) {
                        visited.add(newStateStr);
                        int newMoves = current.moves + 1;
                        int newHeuristic = heuristic(newStateStr);
                        pq.offer(new Node(newStateStr, newMoves, newMoves + newHeuristic));
                    }
                }
            }
        }
        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int heuristic(String state) {
        int manhattanDistance = 0;
        for (int i = 0; i < state.length(); i++) {
            char ch = state.charAt(i);
            if (ch != '0') {
                int targetX = (ch - '1') / COLS;
                int targetY = (ch - '1') % COLS;
                int currentX = i / COLS;
                int currentY = i % COLS;
                manhattanDistance += Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
            }
        }
        return manhattanDistance;
    }

    private static class Node {
        String state;
        int moves;
        int cost;

        Node(String state, int moves, int cost) {
            this.state = state;
            this.moves = moves;
            this.cost = cost;
        }
    }
}
