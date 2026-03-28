package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/chocolates-pickup/1
 *
 * # Chocolates Pickup
 *
 *   Q. You are given a 2D matrix grid[][] of size n * m, where each cell grid[i][j] represents the number of chocolates
 *      available at position (i, j).
 *
 *      Two robots are collecting chocolates from this grid:
 *       -  Robot 1 starts from the top-left corner (0, 0)
 *       -  Robot 2 starts from the top-right corner (0, m - 1)
 *
 *      Your task is to determine the maximum total number of chocolates both robots can collect while following these rules:
 *       -  From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 *       -  When a robot visits a cell, it collects all the chocolates there.
 *       -  If both robots land on the same cell, the chocolates in that cell are collected only once.
 *       -  Robots cannot move outside the boundaries of the grid.
 *       -  Both robots must continue moving until they reach the bottom row of the grid.
 *
 *    Ex.
 *      Input : grid[][] = [[4, 1, 2],
 *                          [3, 6, 1],
 *                          [1, 6, 6],
 *                          [3, 1, 2]]
 *      Output: 32
 *      Explanation: The path followed by first robot is: (0, 0) -> (1, 0) -> (2, 1) -> (3, 0),
 *                   so first robot collected: 4 + 3 + 6 + 3 = 16 chocolates.
 *
 *                   The path followed by second robot is: (0, 2) -> (1, 1) -> (2, 2) -> (3, 2),
 *                   so second robot collected: 2 + 6 + 6 + 2 = 16 chocolates.
 *
 *                   Total both robots collected 16 + 16 = 32 chocolates.
 *
 *  Constraint:
 *          2 ≤ n, m ≤ 70
 *          0 ≤ grid[i][j] ≤ 100
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Chocolate_Pickup {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter grid dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximum total number of chocolates both robots can collect: ");
        System.out.println(maxChocolate(grid));
    }

    /// Solution
/*
✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪-Memoization-✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪✪
TC : O(n * m * m * 9)  ≈  O(n * m²)
SC : O(n * m²) + O(n) --> extra n for recursive call stack
*/
    static int memoization(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return f(0, 0, m - 1, n, m, grid, dp);
    }

    private static int f(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        // base case
        if (j1 < 0 || m <= j1 || j2 < 0 || m <= j2) return Integer.MIN_VALUE;
        if (i == n - 1) return (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // recursive case
        int max = Integer.MIN_VALUE;
        for (int k = -1; k <= 1; k++) {
            int a = (j1 + k == j2 - 1) ? Integer.MIN_VALUE : f(i + 1, j1 + k, j2 - 1, n, m, grid, dp);
            int b = (j1 + k == j2) ? Integer.MIN_VALUE : f(i + 1, j1 + k, j2, n, m, grid, dp);
            int c = (j1 + k == j2 + 1) ? Integer.MIN_VALUE : f(i + 1, j1 + k, j2 + 1, n, m, grid, dp);

            max = Math.max(max, Math.max(a, Math.max(b, c)));
        }

        return dp[i][j1][j2] = max + grid[i][j1] + grid[i][j2];
    }

/*
✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡-Tabulation-✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡✡
TC : O(n * m² * 9)  ≈  O(n * m²)
SC : O(n * m²)
*/
    static int tabulation(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m + 2][m + 2];

        // base case
        for (int j1 = 1; j1 <= m; j1++) {
            for (int j2 = 1; j2 <= m; j2++) {
                dp[n - 1][j1][j2] = (j1 == j2) ? grid[n - 1][j1 - 1] : grid[n - 1][j1 - 1] + grid[n - 1][j2 - 1];
            }
        }

        // self work
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = m; j1 >= 1; j1--) {
                for (int j2 = m; j2 >= 1; j2--) {

                    // recursive case
                    int max = Integer.MIN_VALUE;
                    for (int k = -1; k <= 1; k++) {
                        int a = (j1 + k == j2 - 1) ? Integer.MIN_VALUE : dp[i + 1][j1 + k][j2 - 1];
                        int b = (j1 + k == j2) ? Integer.MIN_VALUE : dp[i + 1][j1 + k][j2];
                        int c = (j1 + k == j2 + 1) ? Integer.MIN_VALUE : dp[i + 1][j1 + k][j2 + 1];

                        max = Math.max(max, Math.max(a, Math.max(b, c)));
                    }

                    dp[i][j1][j2] = max + grid[i][j1 - 1] + grid[i][j2 - 1];

                }
            }
        }

        return dp[0][1][m];
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Space-Optimized-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n * m²)
SC : O(m²)
*/
    static int maxChocolate(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;

        int[][] next = new int[m + 2][m + 2];
        int[][] curr = new int[m + 2][m + 2];

        // base case
        for (int j1 = 1; j1 <= m; j1++) {
            for (int j2 = 1; j2 <= m; j2++) {
                next[j1][j2] = (j1 == j2) ? grid[n - 1][j1 - 1] : grid[n - 1][j1 - 1] + grid[n - 1][j2 - 1];
            }
        }

        // self work
        for (int i = n - 2; i >= 0; i--) {

            for (int j1 = m; j1 >= 1; j1--) {
                for (int j2 = m; j2 >= 1; j2--) {

                    // recursive case
                    int max = Integer.MIN_VALUE;
                    for (int k = -1; k <= 1; k++) {
                        int a = (j1 + k == j2 - 1) ? Integer.MIN_VALUE : next[j1 + k][j2 - 1];
                        int b = (j1 + k == j2) ? Integer.MIN_VALUE : next[j1 + k][j2];
                        int c = (j1 + k == j2 + 1) ? Integer.MIN_VALUE : next[j1 + k][j2 + 1];

                        max = Math.max(max, Math.max(a, Math.max(b, c)));
                    }

                    curr[j1][j2] = max + grid[i][j1 - 1] + grid[i][j2 - 1];

                }
            }

            int[][] temp = curr;
            curr = next;
            next = temp;
        }

        return next[1][m];
    }
}
