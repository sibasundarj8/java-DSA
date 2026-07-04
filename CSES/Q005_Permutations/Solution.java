package CSES.Q005_Permutations;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder sb = new StringBuilder();

        // Even numbers
        for (int i = 2; i <= n; i += 2) {
            sb.append(i).append(" ");
        }

        // Odd numbers
        for (int i = 1; i <= n; i += 2) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
