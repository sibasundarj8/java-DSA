package DP;/*
 *
 * https://leetcode.com/problems/number-of-paths-with-max-score/
 *
 * # LC. 1301. Number of Paths with Max Score
 *
 *   Q. You are given a square board of characters. You can move on the board starting at the bottom right square marked
 *      with the character 'S'.
 *
 *      You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either
 *      with a numeric character 1, 2, ..., 9 or with an obstacle 'X'.
 *
 *      In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.
 *
 *      Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and
 *      the second is the number of such paths that you can take to get that maximum sum, taken modulo 10⁹ + 7.
 *
 *      In case there is no path, return [0, 0].
 *
 *    Ex.
 *      Input : board = ["E23",
 *                       "2X2",
 *                       "12S"]
 *      Output: [7, 1]
 *
 *  Constraints:
 *      2 <= board.length == board[i].length <= 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dynamic_Programming_Number_of_Paths_with_Max_Score {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of board: ");
        int n = sc.nextInt();
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = sc.next();

            if (row.length() != n) {
                throw new IllegalArgumentException("Invalid Input");
            }

            board.add(row);
        }

        if (board.getFirst().charAt(0) != 'E' || board.getLast().charAt(n - 1) != 'S') {
            throw new IllegalArgumentException("Invalid Input");
        }

        System.out.println("ans: " + Arrays.toString(pathsWithMaxScore(board)));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--top-down-(memoization)--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n²)
SC : O(n²) + recursive call stack space (excluding int[][] grid)
*/
    static int[] approach_1(List<String> board) {
        // potd.code.hub
        int n = board.size();
        int[][] grid = new int[n][n];
        long[][][] dp = new long[n][n][];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                grid[i][j] = (Character.isDigit(ch) ? ch - '0' : -1);
            }
        }

        grid[0][0] = grid[n - 1][n - 1] = 0;

        long[] ans = solve_1(n - 1, n - 1, grid, dp);
        return new int[]{(int) ans[0], (int) ans[1]};
    }

    private static long[] solve_1(int r, int c, int[][] grid, long[][][] dp) {
        // base case
        if (r == 0 && c == 0) return new long[]{0, 1, 1};
        if (dp[r][c] != null) return dp[r][c];

        // recursive work
        long[] max = new long[]{0, 0, 0};

        if (c > 0 && grid[r][c - 1] != -1) {
            long[] left = solve_1(r, c - 1, grid, dp);
            maximize_1(max, left);
        }
        if (r > 0 && grid[r - 1][c] != -1) {
            long[] up = solve_1(r - 1, c, grid, dp);
            maximize_1(max, up);
        }
        if (r > 0 && c > 0 && grid[r - 1][c - 1] != -1) {
            long[] upLeft = solve_1(r - 1, c - 1, grid, dp);
            maximize_1(max, upLeft);
        }
        max[0] += grid[r][c];

        // self work
        return dp[r][c] = max;
    }

    private static void maximize_1(long[] max, long[] src) {
        if (src[2] != 1) return;
        max[2] = 1;
        if (src[0] > max[0]) {
            max[0] = src[0];
            max[1] = src[1];
        } else if (src[0] == max[0]) {
            max[1] = (max[1] + src[1]) % MOD;
        }
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--bottom-up-(tabulation)--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n²)
SC : O(n²) (excluding int[][] grid)
*/
    static int[] approach_2(List<String> board) {
        // potd.code.hub
        int n = board.size();
        int[][] grid = new int[n][n];
        long[][][] dp = new long[n][n][];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                grid[i][j] = (Character.isDigit(ch) ? ch - '0' : -1);
            }
        }

        grid[0][0] = grid[n - 1][n - 1] = 0;
        dp[0][0] = new long[]{0, 1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;

                // recursive work simulation
                long[] max = new long[]{0, 0, 0};

                if (c > 0 && grid[r][c - 1] != -1) {
                    long[] left = dp[r][c - 1];
                    maximize_2(max, left);
                }
                if (r > 0 && grid[r - 1][c] != -1) {
                    long[] up = dp[r - 1][c];
                    maximize_2(max, up);
                }
                if (r > 0 && c > 0 && grid[r - 1][c - 1] != -1) {
                    long[] upLeft = dp[r - 1][c - 1];
                    maximize_2(max, upLeft);
                }
                max[0] += grid[r][c];

                // self work
                dp[r][c] = max;
            }
        }

        long[] ans = dp[n - 1][n - 1];
        return new int[]{(int) ans[0], (int) ans[1]};
    }

    private static void maximize_2(long[] max, long[] src) {
        if (src[2] != 1) return;
        max[2] = 1;
        if (src[0] > max[0]) {
            max[0] = src[0];
            max[1] = src[1];
        } else if (src[0] == max[0]) {
            max[1] = (max[1] + src[1]) % MOD;
        }
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-(tabulation)-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n²)
SC : O(n) (excluding int[][] grid)
*/
    static int[] pathsWithMaxScore(List<String> board) {
        // potd.code.hub
        int n = board.size();
        int[][] grid = new int[n][n];
        long[][] prev = new long[n][];
        long[][] curr = new long[n][];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                grid[i][j] = (Character.isDigit(ch) ? ch - '0' : -1);
            }
        }

        grid[0][0] = grid[n - 1][n - 1] = 0;
        prev[0] = new long[]{0, 1, 1};
        curr[0] = new long[]{0, 1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;

                // recursive work simulation
                long[] max = new long[]{0, 0, 0};

                if (c > 0 && grid[r][c - 1] != -1) {
                    long[] left = curr[c - 1];
                    maximize(max, left);
                }
                if (r > 0 && grid[r - 1][c] != -1) {
                    long[] up = prev[c];
                    maximize(max, up);
                }
                if (r > 0 && c > 0 && grid[r - 1][c - 1] != -1) {
                    long[] upLeft = prev[c - 1];
                    maximize(max, upLeft);
                }
                max[0] += grid[r][c];

                // self work
                curr[c] = max;
            }

            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        long[] ans = prev[n - 1];
        return new int[]{(int) ans[0], (int) ans[1]};
    }

    private static void maximize(long[] max, long[] src) {
        if (src[2] != 1) return;
        max[2] = 1;
        if (src[0] > max[0]) {
            max[0] = src[0];
            max[1] = src[1];
        } else if (src[0] == max[0]) {
            max[1] = (max[1] + src[1]) % MOD;
        }
    }
}
