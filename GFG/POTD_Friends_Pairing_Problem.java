package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
 *
 * # Friends Pairing Problem
 *
 *   Q. Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be
 *      paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
 *
 *    Ex.
 *      Input : n = 3
 *      Output: 4
 *      Explanation:
 *              {1}, {2}, {3} : All single
 *              {1}, {2,3} : 2 and 3 paired but 1 is single.
 *              {1,2}, {3} : 1 and 2 are paired but 3 is single.
 *              {1,3}, {2} : 1 and 3 are paired but 2 is single.
 *              Note that {1,2} and {2,1} are considered same.
 *
 *  Constraints:
 *        1 ≤ n ≤ 18
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Friends_Pairing_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.println("Total number of ways in which friends can remain single or can be paired up: ");
        System.out.println(countFriendsPairings(n));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n) + extra recursive call stack
*/
    static int approach_1(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        // base case
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];

        // recursive work
        int rem = n - 1;
        return dp[n] = solve(rem, dp) + rem * solve(n - 2, dp);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_2(int n) {
        // potd.code.hub
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int countFriendsPairings(int n) {
        // potd.code.hub
        int prv1 = 1;
        int prv2 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = prv1;
            prv1 = prv1 + (i - 1) * prv2;
            prv2 = temp;
        }

        return prv1;
    }
}
