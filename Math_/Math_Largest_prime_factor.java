package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-prime-factor2601/1
 *
 * # Largest prime factor
 *
 *   Q. Given a number n, your task is to find the largest prime factor of n.
 *
 *    Ex.
 *      Input : n = 13195
 *      Output: 29
 *      Explanation: The prime factorization of 13195 is 5×7×13×29. The largest prime factor is 29.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Math_Largest_prime_factor {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Largest prime factor is: ");
        System.out.println(largestPrimeFactor(n));
    }

    /// Solution
/*------------------------------------------Pre-Computation__&__Trial-Division------------------------------------------*/
    private final static ArrayList<Integer> primes = new ArrayList<>();

    static {
        boolean[] flag = new boolean[31623];

        for (int i = 2; i * i <= 31623; i++) {
            if (!flag[i]) {
                for (int j = i * i; j < 31623; j += i) {
                    flag[j] = true;
                }
            }
        }

        for (int i = 2; i < 31623; i++) {
            if (!flag[i]) primes.add(i);
        }
    }

    static int largestPrimeFactor1(int n) {
        // potd.code.hub
        int max = 1;

        for (int prime : primes) {
            if (prime * prime > n) break;
            if (n % prime == 0) {
                max = prime;
                while (n % prime == 0) n /= prime;
            }
        }

        return (n > 1) ? n : max;
    }

/*--------------------------------------Successive-Division-by-Increasing-Integers--------------------------------------*/
    static int largestPrimeFactor(int n) {
        // potd.code.hub
        int start = 2;

        while (start * start <= n) {
            if (n % start == 0) n /= start;
            else start++;
        }

        return n;
    }
}
