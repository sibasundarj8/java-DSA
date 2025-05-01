package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/nth-catalan-number0817/1
 *
 * # Nth Catalan Number
 *
 *   Q. Given a number n. The task is to find the nth catalan number.
 *      The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430,
 *      4862, …
 *
 *      Catalan Number for n is equal to the number of expressions containing n pairs of parenthesis
 *      that are correctly matched, i.e., for each of the n(' there exist n ')' on their right and
 *      vice versa.
 *
 *      Note: Positions start from 0 as shown above.
 *   Ex.
 *      Input : n = 3
 *      Output: 5
 *      Explanation: Possible expressions are, ((())), (()()), ()(()), (())(), ()()()
 */

import java.util.Scanner;

public class Dynamic_Programming_Nth_Catalan_Number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of parenthesis: ");
        int n = sc.nextInt();

        System.out.println("Combinations: " + findCatalan1(n));
    }

    /// Solution
/**************************************************Dynamic-Programming**************************************************/
// TC : O(n)
// SC : O(n)
    static int findCatalan(int n) {
        // potd.code.hub
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int pos = 2; pos <= n; pos++){
            for (int i = 0;i < pos;i++){
                dp[pos] += dp[i] * dp[pos - 1 - i];
            }
        }

        return dp[n];
    }
/*************************************************Binomial-Coefficient**************************************************/
// TC : O(n)
// SC : O(1)
    static int findCatalan1(int n) {
        // potd.code.hub
        long res = 1;

        for (int i = 0; i < n; ++i) {
            res *= (2L * n - i);
            res /= (i + 1);
        }

        return (int)(res / (n + 1));
    }
}
