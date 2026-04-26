package Graph;/*
 *
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 *
 * # 1559. Detect Cycles in 2D Grid
 *
 *   Q. Given a 2D array of characters grids of size m x n, you need to find if there exists any cycle consisting of the same
 *      value in grid.
 *
 *      A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can
 *      move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same
 *      value of the current cell.
 *
 *      Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1)
 *      is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 *
 *      Return true if any cycle of the same value exists in grid, otherwise, return false.
 *
 *    Ex.
 *      Input: grid = [["c", "c", "c", "a"],
 *                     ["c", "d", "c", "c"],
 *                     ["c", "c", "e", "c"],
 *                     ["f", "c", "c", "c"]]
 *      Output: true
 *      Explanation: There is only one valid cycle highlighted in the image below:      +---+---+---+---+
 *                                                                                      | ⭐| ⭐ | ⭐| a |
 *                                                                                      +---+---+---+---+
 *                                                                                      | ⭐| d | ⭐ | ⭐|
 *                                                                                      +---+---+---+---+
 *                                                                                      | ⭐| ⭐ | e | ⭐|
 *                                                                                      +---+---+---+---+
 *                                                                                      | f | ⭐ | ⭐| ⭐|
 *                                                                                      +---+---+---+---+
 *  Constraints:
 *        ◦ m == grid.length
 *        ◦ n == grid[i].length
 *        ◦ 1 <= m, n <= 500
 *        ◦ grid consists only of lowercase English letters.
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Detect_Cycles_in_2D_Grid {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        System.out.println("Enter elements (characters): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Cycle exists with same value: ");
        System.out.println(containsCycle(grid));
    }

    /// Solution
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    static boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && isPartOfCycle(i, j, n, m, grid, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPartOfCycle(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j, -1, -1));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int row = cur.r;
            int col = cur.c;
            int parentX = cur.pr;
            int parentY = cur.pc;

            for (int k = 0; k < 4; k++) {
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
                if (grid[newRow][newCol] != grid[row][col]) continue;

                if (visited[newRow][newCol]) {
                    if (!(newRow == parentX && newCol == parentY)) {
                        return true;
                    }
                } else {
                    queue.add(new Node(newRow, newCol, row, col));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }

    private record Node(int r, int c, int pr, int pc) {}
}
