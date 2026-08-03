package LeetCode;/*
 *
 * https://leetcode.com/problems/stone-game-iii/
 *
 * # LC. 1406. Stone Game III
 *
 *   Q. Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each
 *      stone has an associated value which is an integer given in the array stoneValue.
 *
 *      Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3
 *      stones from the first remaining stones in the row.
 *
 *      The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
 *
 *      The objective of the game is to end with the highest score, and the winner is the player with the highest score
 *      and there could be a tie. The game continues until all the stones have been taken.
 *
 *      Assume Alice and Bob play optimally.
 *
 *      Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.
 *
 *    Ex.
 *      Input : stoneValue = [1, 2, 3, 7]
 *      Output: "Bob"
 *      Explanation: Alice will always lose. Her best move will be to take three piles and the score become 6. Now the
 *                   score of Bob is 7 and Bob wins.
 *
 *  Constraints:
 *        ◦ 1 <= stoneValue.length <= 5 * 10⁴
 *        ◦ -1000 <= stoneValue[i] <= 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1406_Stone_Game_III {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] stoneValue: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] stoneValue = new int[n];
        for (int i = 0; i < n; i++) {
            stoneValue[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Who gonna win if Alice starts: ");
        System.out.println(stoneGameIII(stoneValue));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n) + recursive call stack
*/
    static String approach_1(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int x = solve(0, n, stoneValue, dp);

        if (x < 0) return "Bob";
        if (x > 0) return "Alice";
        return "Tie";
    }

    private static int solve(int i, int n, int[] stoneValue, int[] dp) {
        // base case
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        // recursive case
        int max = stoneValue[i] - solve(i + 1, n, stoneValue, dp);

        if (i + 1 < n) {
            int b = stoneValue[i] + stoneValue[i + 1] - solve(i + 2, n, stoneValue, dp);
            max = Math.max(max, b);
        }

        if (i + 2 < n) {
            int c = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - solve(i + 3, n, stoneValue, dp);
            max = Math.max(max, c);
        }

        // self work
        return dp[i] = max;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--tabulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static String approach_2(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int max = stoneValue[i] - dp[i + 1];

            if (i + 1 < n) {
                int b = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
                max = Math.max(max, b);
            }

            if (i + 2 < n) {
                int c = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
                max = Math.max(max, c);
            }

            dp[i] = max;
        }

        if (dp[0] < 0) return "Bob";
        if (dp[0] > 0) return "Alice";
        return "Tie";
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp1, dp2, dp3;
        dp1 = dp2 = dp3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int max = stoneValue[i] - dp1;

            if (i + 1 < n) {
                int b = stoneValue[i] + stoneValue[i + 1] - dp2;
                max = Math.max(max, b);
            }

            if (i + 2 < n) {
                int c = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp3;
                max = Math.max(max, c);
            }

            dp3 = dp2;
            dp2 = dp1;
            dp1 = max;
        }

        if (dp1 < 0) return "Bob";
        if (dp1 > 0) return "Alice";
        return "Tie";
    }
}
