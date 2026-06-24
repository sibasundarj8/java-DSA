package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1
 *
 * # Rat Maze With Multiple Jumps
 *
 *   Q. Given a matrix mat[][] of size n × n, where mat[i][j] represents the maximum number of steps a rat can jump either
 *      forward (right) or downward from that cell, find a path for the rat to reach from the top-left cell (0, 0) to the
 *      bottom-right cell (n - 1, n - 1). A cell containing 0 is blocked and cannot be used in the path. It is guaranteed
 *      that the cell mat[n-1][n-1] is not 0.
 *
 *      Return an n × n matrix where 1 represents the cells included in the path and 0 represents the remaining cells.
 *      If no valid path exists, return [[-1]].
 *
 *      Note: If multiple valid paths exist, choose the path with the shortest possible jumps first. For the same jump
 *      length, moving forward (right) should be preferred over moving downward.
 *
 *    Ex.
 *      Input : mat[][] = [[2, 1, 0, 0],
 *                         [3, 0, 0, 1],
 *                         [0, 1, 0, 1],
 *                         [0, 0, 0, 1]]
 *      Output: [[1, 0, 0, 0],
 *               [1, 0, 0, 1],
 *               [0, 0, 0, 1],
 *               [0, 0, 0, 1]]
 *      Explanation:
 *              The rat starts from cell (0, 0) which contains value 2, so it can jump at most 2 steps either right or
 *              downward.
 *                 Steps:
 *                 --> Moves downward to (1, 0) which contains value 3.
 *                 --> Jumps 3 steps right to reach (1, 3).
 *                 --> Moves downward through (2, 3) and reaches the destination cell (3, 3).
 *
 *  Constraints:
 *      1 ≤ n ≤ 50
 *      0 ≤ mat[i][j] ≤ 20
 */

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Rat_Maze_With_Multiple_Jumps {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of a square matrix: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Path for the rat to reach from the cell (0, 0) to the cell (n - 1, n - 1): ");
        System.out.println(shortestDist(mat));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] failed = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        if (!solve(0, 0, n, ans, mat, failed)) {
            ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.getLast().add(-1);
        }

        return ans;
    }

    private static boolean solve(int r, int c, int n, ArrayList<ArrayList<Integer>> ans, int[][] mat, boolean[][] failed) {
        // base case
        if (r == n - 1 && c == n - 1) {
            ans.getLast().set(n - 1, 1);
            return true;
        }
        if (failed[r][c]) return false;

        // recursive case
        ans.get(r).set(c, 1);

        for (int i = 1; i <= mat[r][c]; i++) {
            int nr = r + i;
            int nc = c + i;
            if (nr >= n && nc >= n) break;

            // right
            if (nc < n && mat[r][nc] != 0) {
                if (solve(r, nc, n, ans, mat, failed)) return true;
            }

            // down
            if (nr < n && mat[nr][c] != 0) {
                if (solve(nr, c, n, ans, mat, failed)) return true;
            }
        }

        // backtrack
        ans.get(r).set(c, 0);
        failed[r][c] = true;

        return false;
    }
}
