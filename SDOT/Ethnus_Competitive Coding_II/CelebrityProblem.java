// https://www.youtube.com/watch?v=CiiXBvrX-5A

/**
 * To solve the celebrity problem, you can use a two-pass algorithm.
 In the first pass, you find a potential celebrity candidate, and in the second pass, 
you verify if the candidate meets the celebrity criteria
 */

import java.util.*;

public class CelebrityProblem {
    void findCelebrity(int[][] mat) {
        Stack<Integer> st = new Stack<Integer>();

        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (mat[i][j] == 1) {
                // i knows j , j is a celebrity
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int potential_celebrity = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != potential_celebrity) {
                if (mat[i][potential_celebrity] == 0 || mat[potential_celebrity][i] == 1) {
                    System.out.println("No celebrity");
                    return;
                }
            }

        }
        System.out.println("Celebrity : " + potential_celebrity);

    }

    public static void main(String[] args) {
        // take the matrix and write the code
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] relationshipMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                relationshipMatrix[i][j] = sc.nextInt();
            }
        }
        CelebrityProblem ob = new CelebrityProblem();

        ob.findCelebrity(relationshipMatrix);
    }
}
