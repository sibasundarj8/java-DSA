package Contest.weekly_500;/*
 *
 * https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/
 *
 * # Q2. Sum of Primes Between Number and Its Reverse
 *
 *   Q. You are given an integer n. Let r be the integer formed by reversing the digits of n. Return the sum of all prime
 *      numbers between min(n, r) and max(n, r), inclusive.
 *
 *      A prime number is a natural number greater than 1 with only two factors, 1 and itself.
 *
 *    Ex.
 *      Input : n = 13
 *      Output: 132
 *      Explanation:
 *              The reverse of 13 is 31. Thus, the range is [13, 31].
 *              The prime numbers in this range are 13, 17, 19, 23, 29, and 31.
 *              The sum of these prime numbers is 13 + 17 + 19 + 23 + 29 + 31 = 132.
 *
 *  Constraints:
 *          1 <= n <= 1000
 */

import java.util.Arrays;

public class Q2_Sum_of_Primes_Between_Number_and_Its_Reverse {

    /// Solution
    private final static int size = 1001;
    private final static int[] sieve = new int[size];

    static {
        Arrays.fill(sieve, -1);

        for (int i = 2; i < size; i++) {
            if (sieve[i] == -1) {
                sieve[i] = i;
                for (int j = i * i; j < size; j += i) {
                    sieve[j] = 0;
                }
            }
        }

        sieve[0] = sieve[1] = 0;

        for (int i = 2; i < size; i++) {
            sieve[i] += sieve[i - 1];
        }
    }

    public int sumOfPrimesInRange(int n) {
        int rev = reverseDigits(n);

        int l = Math.min(n, rev);
        int r = Math.max(n, rev);

        return sieve[r] - (l > 0 ? sieve[l - 1] : 0);
    }

    private int reverseDigits(int n) {
        int ans;
        for(ans = 0; n != 0; n /= 10) {
            ans = ans * 10 + n % 10;
        }

        return ans;
    }
}
