package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1
 *
 * # Ways To Tile A Floor
 *
 *   Q. Given a floor of dimensions 2 x n and tiles of dimensions 2 x 1, the task is to find the number of ways the floor
 *      can be tiled. A tile can either be placed horizontally i.e. as a 1 x 2 tile or vertically i.e. as 2 x 1 tile.
 *
 *      Note: Two tiling arrangements are considered different if the placement of at least one tile differs.
 *   Ex.
 *      Input : n = 3
 *      Output: 3
 *      Explanation: We need 3 tiles to tile the board of size 2 x 3.
 *                   We can tile in following ways:
 *                       1) Place all 3 tiles vertically.
 *                       2) Place first tile vertically and remaining 2 tiles horizontally.
 *                       3) Place first 2 tiles horizontally and remaining tiles vertically.
 *  Constraints:
 *          1 ≤ n ≤ 45
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Ways_To_Tile_A_Floor {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Tiles: ");
        int n = sc.nextInt();

        System.out.println("Number of ways to tile the floor: ");
        System.out.println(numberOfWays(n));
    }

    /// Solution
/*🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒Memoization🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒*/
    static int memoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return f(n, dp);
    }

    private static int f(int n, int[] dp) {
        // base case
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];

        // recursive work
        int a = f(n - 1, dp);
        int b = f(n - 2, dp);

        return dp[n] = a + b;
    }

/*🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒Tabulation🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒*/
    static int tabulation(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n - 1];
    }

/*🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒Space-Optimized🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒🁒*/
    static int numberOfWays(int n) {
        if (n == 1) return 1;

        int p2 = 1;
        int p1 = 2;

        for (int i = 2; i < n; i++) {
            int temp = p1;
            p1 += p2;
            p2 = temp;
        }

        return p1;
    }
}
