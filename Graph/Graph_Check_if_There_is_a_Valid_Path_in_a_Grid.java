package Graph;/*
 *
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 *
 * # 1391. Check if There is a Valid Path in a Grid
 *
 *   Q. You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
 *        ◦ 1 ⁃ which means a street connecting the left cell and the right cell.
 *        ◦ 2 ⁃ which means a street connecting the upper cell and the lower cell.
 *        ◦ 3 ⁃ which means a street connecting the left cell and the lower cell.
 *        ◦ 4 ⁃ which means a street connecting the right cell and the lower cell.
 *        ◦ 5 ⁃ which means a street connecting the left cell and the upper cell.
 *        ◦ 6 ⁃ which means a street connecting the right cell and the upper cell.
 *
 *                  +-------------+        +-------------+        +-------------+        +-------------+
 *                  |             |        |     | |     |        |             |        |             |
 *                  |             |        |     | |     |        |             |        |             |
 *                  | ----------- |        |     | |     |        | ______      |        |     _______ |
 *                  | ----------- |        |     | |     |        | ____  \     |        |    /   ____ |
 *                  |             |        |     | |     |        |     |  |    |        |    |  |     |
 *                  |             |        |     | |     |        |     |  |    |        |    |  |     |
 *                  +-------------+        +-------------+        +-------------+        +-------------+
 *                      Street-1              Street-2                Street-3              Street-4
 *
 *                               +-------------+                               +-------------+
 *                               |     |  |    |                               |    |  |     |
 *                               |     |  |    |                               |    |  |     |
 *                               | ----`  /    |                               |     \  `----|
 *                               | ------`     |                               |      `------|
 *                               |             |                               |             |
 *                               |             |                               |             |
 *                               +-------------+                               +-------------+
 *                                   Street-5                                       Street-6
 *
 *      You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path that
 *      starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1). The path should only
 *      follow the streets.
 *
 *      Notice that you are not allowed to change any street.
 *
 *      Return true if there is a valid path in the grid or false otherwise.
 *
 *    Ex.
 *      Input : grid = [[2, 4, 3], [6, 5, 2]]
 *      Output: true
 *      Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
 *
 *  Constraints:
 *          m == grid.length
 *          n == grid[i].length
 *          1 <= m, n <= 300
 *          1 <= grid[i][j] <= 6
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Check_if_There_is_a_Valid_Path_in_a_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter elements: (1 <= ele <= 6)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] < 1 || 6 < grid[i][j]) {
                    throw new IllegalArgumentException("Invalid input");
                }
            }
        }

        System.out.println("is a valid path in the grid: [(0,0) --> (n-1, m-1)]");
        System.out.println(hasValidPath(grid));
    }

    /// Solution
    private record Pair(int r, int c) {}
    private record Cell(int[] dRow, int[] dCol) {}
    private static final ArrayList<Cell> adjacency;

    static {
        adjacency = new ArrayList<>();
        adjacency.add(null);
        adjacency.add(new Cell(new int[]{0, 0}, new int[]{-1, +1}));  // 1
        adjacency.add(new Cell(new int[]{-1, +1}, new int[]{0, 0}));  // 2
        adjacency.add(new Cell(new int[]{0, +1}, new int[]{-1, 0}));  // 3
        adjacency.add(new Cell(new int[]{0, +1}, new int[]{+1, 0}));  // 4
        adjacency.add(new Cell(new int[]{0, -1}, new int[]{-1, 0}));  // 5
        adjacency.add(new Cell(new int[]{-1, 0}, new int[]{0, +1}));  // 6
    }

    static boolean hasValidPath(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            Cell cell = adjacency.get(grid[r][c]);
            int[] dRow = cell.dRow;
            int[] dCol = cell.dCol;

            if (r == n - 1 && c == m - 1) {
                return true;
            }

            for (int x = 0; x < 2; x++) {
                int nextR = r + dRow[x];
                int nextC = c + dCol[x];

                if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m && !visited[nextR][nextC] && isValidCell(r, c, nextR, nextC, grid)) {
                    visited[nextR][nextC] = true;
                    q.add(new Pair(nextR, nextC));
                }
            }
        }

        return false;
    }

    private static boolean isValidCell(int srcX, int srcY, int destX, int destY, int[][] grid) {
        Cell cell = adjacency.get(grid[destX][destY]);
        int[] dRow = cell.dRow;
        int[] dCol = cell.dCol;

        return (destX + dRow[0] == srcX && destY + dCol[0] == srcY) || (destX + dRow[1] == srcX && destY + dCol[1] == srcY);
    }
}
