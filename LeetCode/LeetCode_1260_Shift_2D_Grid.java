package LeetCode;/*
 *
 * https://leetcode.com/problems/shift-2d-grid/
 *
 * # LC. 1260. Shift 2D Grid
 *
 *   Q. Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 *      In one shift operation:
 *        ◦ Element at grid[i][j] moves to grid[i][j + 1].
 *        ◦ Element at grid[i][n - 1] moves to grid[i + 1][0].
 *        ◦ Element at grid[m - 1][n - 1] moves to grid[0][0].
 *
 *      Return the 2D grid after applying shift operation k times.
 *
 *   Ex.
 *      Input : grid = [[1, 2, 3],
 *                      [4, 5, 6],
 *                      [7, 8, 9]],
 *              k = 1
 *      Output: [[9, 1, 2],
 *               [3, 4, 5],
 *               [6, 7, 8]]
 *
 *  Constraints:
 *        m == grid.length
 *        n == grid[i].length
 *        1 <= m <= 50
 *        1 <= n <= 50
 *        -1000 <= grid[i][j] <= 1000
 *        0 <= k <= 100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1260_Shift_2D_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("After k shift: ");
        List<List<Integer>> res = shiftGrid(mat, k);

        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }

    /// Solution
    static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                row.add(0);
            }

            res.add(row);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = (((j + k) / m) + i) % n;
                int c = (j + k) % m;
                res.get(r).set(c, grid[i][j]);
            }
        }

        return res;
    }
}
