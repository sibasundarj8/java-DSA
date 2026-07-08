package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/geeks-island--170646/1
 *
 * # Towers Reaching Both Stations
 *
 *   Q. Given a matrix mat[][] of size n x m, where mat[i][j] represents the signal strength of a communication tower.
 *
 *      Two control stations monitor the network:
 *        ◦ Station P covers the top and left boundaries of the grid.
 *        ◦ Station Q covers the bottom and right boundaries of the grid.
 *
 *      A signal can propagate from a tower to one of its neighboring towers in the four directions (North, South, East,
 *      and West) only if the neighboring tower has a signal strength less than or equal to that of the current tower.
 *
 *      Determine the number of towers (x, y) from which a signal can eventually reach both Station P and Station Q.
 *      Any tower located on a boundary covered by a station can transmit directly to that station.
 *
 *    Ex.                  +---+---+---+---+---+
 *      Input : mat[][] =  | 1 | 2 | 2 | 3 |(5)|
 *                         +---+---+---+---+---+
 *                         | 3 | 2 | 3 |(4)|(4)|
 *                         +---+---+---+---+---+
 *                         | 2 | 4 |(5)| 3 | 1 |
 *                         +---+---+---+---+---+
 *                         |(6)|(7)| 1 | 4 | 5 |
 *                         +---+---+---+---+---+
 *                         |(5)| 1 | 1 | 2 | 4 |
 *                         +---+---+---+---+---+
 *
 *      Output: 7
 *      Explanation:
 *              In the given matrix, there are 7 coordinates through which the signals can propagate to both the stations.
 *              They are (0, 4), (1, 3), (1, 4), (2, 2), (3, 0), (3, 1), and (4, 0).
 *
 *  Constraints:
 *      1 ≤ n, m ≤ 10³
 *      1 ≤ mat[i][j] ≤ 10³
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Towers_Reaching_Both_Stations {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of grid");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        System.out.println("Enter grid elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Number of cells covered by both cells: ");
        System.out.println(countCoordinates(grid));
    }

    /// Solution
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    static int countCoordinates(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visitedP = new boolean[n][m];
        boolean[][] visitedQ = new boolean[n][m];

        // left | right
        for (int i = 0; i < n; i++) {
            if (!visitedP[i][0]){
                visitedP[i][0] = true;
                solve(i, 0, n, m, mat, visitedP);
            }

            if (!visitedQ[i][m - 1]){
                visitedQ[i][m - 1] = true;
                solve(i, m - 1, n, m, mat, visitedQ);
            }
        }

        // top | bottom
        for (int i = 0; i < m; i++) {
            if (!visitedP[0][1]){
                visitedP[0][i] = true;
                solve(0, i, n, m, mat, visitedP);
            }

            if (!visitedQ[n - 1][i]){
                visitedQ[n - 1][i] = true;
                solve(n - 1, i, n, m, mat, visitedQ);
            }
        }

        // counting
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visitedP[i][j] && visitedQ[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void solve(int r, int c, int n, int m, int[][] mat, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (0 <= nr && nr < n && 0 <= nc && nc < m && mat[nr][nc] >= mat[r][c] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                solve(nr, nc, n, m, mat, visited);
            }
        }
    }
}
