/**
 * 
 * Enter the size of arrow : 8
 *
 *
 ***
 *****
 *******
 *********
 ***********
 *************
 ***************
 ***
 ***
 ***
 ***
 * 
 */
import java.util.Scanner;
public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = 1;
        int D = (int) Math.ceil(N / 2.0);
        for (int i = 0; i < N; i++) {
            for (int m = 0; m < N - i; m++) {
                System.out.print(" ");
            }

            for (int j = 0; j < P; j++) {
                System.out.print("*");
            }
            System.out.println();
            P = P + 2;
        }

        for (int f = 0; f < N; f++) {
            for (int m = 0; m < (P - 1) / 2 - 2; m++) {
                System.out.print(" ");
            }
            for (int x = 0; x < D; x++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
