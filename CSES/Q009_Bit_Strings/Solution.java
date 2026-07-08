package CSES.Q009_Bit_Strings;

import java.util.Scanner;

public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(twoPow(n));
    }

    private static long twoPow(long n) {
        if (n < 63) return (1L << n) % MOD;
        long x = twoPow(n >> 1);
        x = (x * x) % MOD;
        return ((n & 1) == 1) ? (x << 1) % MOD : x;
    }
}
