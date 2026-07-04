package CSES.Q004_Increasing_Array;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long moves = 0;
        int prev = sc.nextInt();
        int curr;

        for (int i = 1; i < n; i++) {
            curr = sc.nextInt();
            if (curr < prev) moves += prev - curr;
            else prev = curr;
        }

        System.out.println(moves);
    }
}
