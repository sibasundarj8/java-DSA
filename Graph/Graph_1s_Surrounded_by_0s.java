package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/1s-surrounded-by-0s/1
 *
 * # 1s Surrounded by 0s
 *
 *   Q. Given an n × m binary matrix grid[][], find the total count of all cells containing 1 that are unable to move out
 *      of the grid through a path of adjacent 1s.
 *
 *       ◦ Adjacency means you can only move in four directions: Up, Down, Left, and Right. Diagonal moves are not allowed.
 *
 *       ◦ Assume that the space immediately outside the grid is an open path. Any 1 located directly on the outer boundary
 *         of the grid (first row, last row, first column, or last column) can immediately step out, and any 1 connected to
 *         it can follow and also step out of the grid.
 *
 *    Ex.
 *      Input : grid[][] = [[0, 0, 0, 0],
 *      		            [1, 0, 1, 0],
 *      		            [0, 1, 1, 0],
 *      		            [0, 0, 0, 0]]
 *      Output: 3
 *      Explanation: The highlighted cells represent the land cells.
 *
 *  Constraints:
 *      1 ≤ n, m ≤ 500
 *      0 ≤ grid[i][j] ≤ 1
 */

import java.util.Scanner;

public class Graph_1s_Surrounded_by_0s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of grid: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid elements: (must be either 0 or 1)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] != 0 && grid[i][j] != 1) {
                    throw new IllegalArgumentException(grid[i][j] + " not a valid input");
                }
            }
        }

        System.out.println("Total count of ones that are unable to move out: ");
        System.out.println(cntOnes(grid));
    }

    /// Solution
    private static final int[] dr = {0, -1, 0, 1};
    private static final int[] dc = {-1, 0, 1, 0};

    static int cntOnes(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int x = 0; x < n; x++) {
            if (grid[x][0] == 1 && !visited[x][0]) dfs(x, 0, n, m, grid, visited);
            if (grid[x][m - 1] == 1 && !visited[x][m - 1]) dfs(x, m - 1, n, m, grid, visited);
        }

        for (int x = 0; x < m; x++) {
            if (grid[0][x] == 1 && !visited[0][x]) dfs(0, x, n, m, grid, visited);
            if (grid[n - 1][x] == 1 && !visited[n - 1][x]) dfs(n - 1, x, n, m, grid, visited);
        }

        // counting the remaining one's
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j, int n, int m, int[][] grid, boolean[][] visited) {
        visited[i][j] = true;

        for (int x = 0; x < 4; x++) {
            int ni = i + dr[x];
            int nj = j + dc[x];

            if (0 <= ni && ni < n && 0 <= nj && nj < m && grid[ni][nj] == 1 && !visited[ni][nj]) {
                dfs(ni, nj, n, m, grid, visited);
            }
        }
    }
}
