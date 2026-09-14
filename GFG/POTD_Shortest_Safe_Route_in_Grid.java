package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-shortest-safe-route-in-a-matrix/1
 *
 * # Shortest Safe Route in Grid
 *
 *   Q. Given a 2D matrix mat[][] of size n × m, where each cell is either 0 (landmine) or 1 (safe), find the minimum
 *      number of steps required to travel from any cell in the leftmost column to any cell in the rightmost column.
 *
 *      You can move only in four directions: up, down, left, and right.
 *
 *      A cell is unsafe if it contains a landmine or is directly adjacent (up, down, left, or right) to a landmine,
 *      and such cells must be avoided.
 *
 *      Return -1 if no safe path exists.
 *
 *    Ex.
 *      Input : mat[][] = [[1, 0, 1, 1, 1],
 *                         [1, 1, 1, 1, 1],
 *                         [1, 1, 1, 1, 1],
 *                         [1, 1, 1, 0, 1],
 *                         [1, 1, 1, 1, 0]]
 *                                                      X     0     X     1     1
 *
 *                                                      1     X     1  >  1  >  1
 *                                                                  ^
 *                                                      1  >  1  >  1     X     1
 *
 *                                                      1     1     X     0     X
 *
 *                                                      1     1     1     X     0
 *      Output: 6
 *      Explanation: We can see that length of shortest safe route is 6.
 *
 *  Constraints:
 *        ◦ 1 ≤ n, m ≤ 103
 *        ◦ 0 ≤ mat[i][j] ≤ 1
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class POTD_Shortest_Safe_Route_in_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimensions of the grid: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter the elements of the grid: [0 / 1]");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] != 0 && grid[i][j] != 1) {
                    throw new IllegalArgumentException("Invalid grid");
                }
            }
        }

        System.out.println("Shortest path: ");
        System.out.println(shortestPath(grid));
    }

    /// Solution
    private static final int[] D_ROW = {-1, 0, 1, 0};
    private static final int[] D_COL = {0, 1, 0, -1};

    static int shortestPath(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];

        // marking danger zone
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    visited[i][j] = true;

                    for (int x = 0; x < 4; x++) {
                        int nr = i + D_ROW[x];
                        int nc = j + D_COL[x];

                        if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }

        // BFS
        int dist = 0;
        Queue<int[]> q = new ArrayDeque<>();

        // adding the left most col
        for (int i = 0; i < n; i++) {
            if (!visited[i][0]) {
                visited[i][0] = true;
                q.offer(new int[]{i, 0});
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int x = 0; x < 4; x++) {
                    int nr = cur[0] + D_ROW[x];
                    int nc = cur[1] + D_COL[x];

                    if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc]) {

                        if (nc == m - 1) return dist;

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            dist++;
        }

        return -1;
    }
}
