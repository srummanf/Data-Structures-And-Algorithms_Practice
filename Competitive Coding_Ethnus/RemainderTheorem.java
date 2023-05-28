// Chinese Remainder Theorem

import java.io.*;
import java.util.*;

class RemainderTheorem {
    static int findMinX(int num[], int rem[], int k) {
        int x = 1;
        while (true) {
            int j;
            for (j = 0; j < k; j++)
                if (x % num[j] != rem[j])
                    break;
            if (j == k)
                return x;
            x++;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of congruence relations: ");
        int size = sc.nextInt();
        System.out.println("Enter the values of a: ");
        int a[] = new int[size];
        for (int i = 0; i < size; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter the values of m: ");
        int m[] = new int[size], p = 1;
        for (int i = 0; i < size; i++) {
            m[i] = sc.nextInt();
        }
        System.out.println("x is " + findMinX(a, m, size));
    }
}
