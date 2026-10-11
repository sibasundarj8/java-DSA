package Contest.weekly_523;/*
 *
 * https://leetcode.com/contest/weekly-contest-523/problems/prime-subset-selection-i/
 *
 * # Q2. Prime Subset Selection I
 *
 *   Q.You are given two integers n and s.
 *
 *      Consider all prime numbers less than or equal to n. Select some of these primes such that:
 *        ◦ The sum of the selected primes is less than or equal to s.
 *        ◦ The number of selected primes is maximized.
 *        ◦ Each prime can be selected at most once.
 *
 *      Return an integer array containing the selected primes in increasing order. If multiple optimal
 *      selections exist, return any of them.
 *
 *      If no prime can be selected, return an empty array.
 *
 *      A prime number is a natural number greater than 1 with only two factors, 1 and itself.
 *
 *    Ex.
 *      Input : n = 7, s = 20
 *      Output: [2,3,5,7]
 *      Explanation:
 *                ◦ The prime numbers less than or equal to n = 7 are 2, 3, 5, and 7.
 *                ◦ The sum of all these primes is 2 + 3 + 5 + 7 = 17, which is less than or equal to s = 20.
 *                ◦ Thus, the answer is [2, 3, 5, 7].
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁶
 *        ◦ 1 <= s <= 10⁹
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_Prime_Subset_Selection_I {

    /// Solution
    private final static int size = 1000001;
    private final static boolean[] sieve = new boolean[size];
    private final static List<Integer> primes = new ArrayList<>();

    static {
        Arrays.fill(sieve, true);

        for (long i = 2; i < size; i++) {
            if (sieve[(int) i]) {
                for (long j = i * i; j < size; j += i) {
                    sieve[(int) j] = false;
                }
            }
        }

        sieve[0] = sieve[1] = false;

        for (int i = 0; i < size; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
    }

    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> list = new ArrayList<>();

        int i = 1;
        int sum = 2;
        int prime = 2;

        while (sum <= s && prime <= n) {
            list.add(prime);
            prime = primes.get(i++);
            sum += prime;
        }

        return list;
    }
}