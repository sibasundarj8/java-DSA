package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/nine-divisors3751/1
 *
 * # Nine Divisors
 *
 *   Q. Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.
 *
 *   Ex.
 *      Input : n = 200
 *      Output: 3
 *      Explanation: Numbers which have exactly 9 divisors are 36, 100, 196.
 */

import java.util.Scanner;

public class Math_Nine_Divisors {

    /// main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("count of number having exactly 9 divisors: ");
        System.out.println(countNumbers(n));
    }

    /// Solution
    private final static int[] prime = new int[(int) 1e5];
    private final static int[][] power = {
            {0, 0},
            {256, 1},
            {6561, 2},
            {390625, 3},
            {5764801, 4},
            {214358881, 5},
            {815730721, 6},
            {2147483647, 7}
    };

    static {
        for (int i = 2; i * i < 1e5; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j < 1e5; j += i) {
                    prime[j] = 1;
                }
            }
        }
        prime[2] = 1;
        for (int i = 3; i < 1e5; i++) {
            prime[i] = (prime[i] == 0) ? 1 : 0;
            prime[i] += prime[i - 1];
        }

        int start = 2;
        while (Math.pow(start, 8) < 1e9)
            start = lowerBound(start, prime[start] + 1);
    }

    static int countNumbers(int n) {
        // potd.code.hub
        int ans = 0;
        int start = 2;

        while (true) {
            int idx = (int) Math.sqrt((double) n / (start * start));
            if (idx < start) break;
            ans += prime[idx] - prime[start];
            start = lowerBound(start, prime[start] + 1);
        }

        return ans + upperBound(n);
    }

    private static int lowerBound(int i, int target) {
        int ans = 0, j = (int) 1e5;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (prime[mid] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }
        return ans;
    }

    private static int upperBound(int target) {
        int ans = 0;
        int i = 0, j = 6;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (power[mid][0] <= target) {
                ans = mid;
                i = mid + 1;
            } else j = mid - 1;
        }

        return ans;
    }
}
