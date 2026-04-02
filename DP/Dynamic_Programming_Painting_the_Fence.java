package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/painting-the-fence3727/1
 *
 * # Painting the Fence
 *
 *   Q. Given a fence with n posts and k colors, find out the number of ways of painting the fence so that not more than two
 *      consecutive posts have the same colors. Answers are guaranteed to be fit into a 32-bit integer.
 *
 *    Ex.
 *      Input : n = 3, k = 2
 *      Output: 6
 *      Explanation: Let the 2 colors be 'R' and 'B'. We have following possible combinations:
 *              1. RRB
 *              2. RBR
 *              3. RBB
 *              4. BRR
 *              5. BRB
 *              6. BBR
 *
 *  Constraints:
 *          1 ≤ n ≤ 300
 *          1 ≤ k ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Painting_the_Fence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.print("k : ");
        int k = sc.nextInt();

        System.out.print("""
                 Number of ways of painting the fence so that not more than two consecutive posts
                 have the same colors :
                """);
        System.out.println(countWays(n, k));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n) + extra n for recursive call stack
*/
    static int memoization(int n, int k) {
        // potd.code.hub
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return f(n, k, dp);
    }

    private static int f(int n, int k, int[] dp) {
        // base case
        if (n == 1) return k;
        if (n == 2) return k * k;
        if (dp[n] != -1) return dp[n];

        // recursive case
        int same = f(n - 2, k, dp) * (k - 1);
        int diff = f(n - 1, k, dp) * (k - 1);

        // self work
        return dp[n] = same + diff;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Tabulation-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int tabulation(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        int[] dp = new int[n + 1];

        // base case simulation
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {

            // recursive case simulation
            int same = dp[i - 2] * (k - 1);
            int diff = dp[i - 1] * (k - 1);

            // self work
            dp[i] = same + diff;
        }

        return dp[n];
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Space-Optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int countWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        int[] dp = new int[n + 1];
        int x1, x2, x;

        // base case simulation
        x2 = k;
        x1 = k * k;

        for (int i = 3; i <= n; i++) {

            // recursive case simulation
            int same = x2 * (k - 1);
            int diff = x1 * (k - 1);

            // self work
            x = same + diff;

            x2 = x1;
            x1 = x;
        }

        return x1;
    }
}
