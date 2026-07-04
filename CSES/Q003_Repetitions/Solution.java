package CSES.Q003_Repetitions;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dnaSequence = sc.next();

        int n = dnaSequence.length();
        int count = 1;
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (dnaSequence.charAt(i - 1) == dnaSequence.charAt(i)) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);

        System.out.println(max);
    }
}
