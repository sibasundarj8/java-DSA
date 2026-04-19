package Contest.weekly_498;/*
 *
 * https://leetcode.com/contest/weekly-contest-498/problems/multi-source-flood-fill/
 *
 * # Q3. Multi Source Flood Fill
 *
 *   Q. You are given two integers n and m representing the number of rows and columns of a grid, respectively.
 *
 *      You are also given a 2D integer array sources, where sources[i] = [r_i, c_i, color_i] indicates that the cell (ri, ci)
 *      is initially colored with color_i. All other cells are initially uncolored and represented as 0.
 *
 *      At each time step, every currently colored cell spreads its color to all adjacent uncolored cells in the four
 *      directions: up, down, left, and right. All spreads happen simultaneously.
 *
 *      If multiple colors reach the same uncolored cell at the same time step, the cell takes the color with the maximum value.
 *
 *      The process continues until no more cells can be colored.
 *
 *      Return a 2D integer array representing the final state of the grid, where each cell contains its final color.
 *
 *    Ex.
 *      Input : n = 3, m = 3, sources = [[0, 0, 1], [2, 2, 2]]
 *      Output: [[1, 1, 2], [1, 2, 2], [2, 2, 2]]
 *      Explanation:
 *              The grid at each time step is as follows:
 *                                                        +---+---+---+           +---+---+---+           +---+---+---+
 *                                                        | 1 | 0 | 0 |     ➝     | 1 | 1 | 0 |     ➝     | 1 | 1 | 2 |
 *                                                        +---+---+---+           +---+---+---+           +---+---+---+
 *                                                        | 0 | 0 | 0 |     ➝     | 1 | 0 | 2 |     ➝     | 1 | 2 | 2 |
 *                                                        +---+---+---+           +---+---+---+           +---+---+---+
 *                                                        | 0 | 0 | 2 |     ➝     | 0 | 2 | 2 |     ➝     | 2 | 2 | 2 |
 *                                                        +---+---+---+           +---+---+---+           +---+---+---+
 *              At time step 2, cells (0, 2), (1, 1), and (2, 0) are reached by both colors, so they are assigned color 2 as it
 *              has the maximum value among them.©leetcode
 *
 *  Constraints:
 *          1 <= n, m <= 10⁵
 *          1 <= n * m <= 10⁵
 *          1 <= sources.length <= n * m
 *          sources[i] = [ri, ci, color_i]
 *          0 <= r_i <= n - 1
 *          0 <= c_i <= m - 1
 *          1 <= color_i <= 10⁶
 *          All (r_i, c_i) in sources are distinct.
 */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Q3_Multi_Source_Flood_Fill {

    /// Solution
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int[] src : sources) {
            grid[src[0]][src[1]] = src[2];
            visited[src[0]][src[1]] = true;
            queue.offer(src);
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            HashMap<String, int[]> map = new HashMap<>();

            for (int i = 0; i < len; i++) {
                int[] src = queue.poll();
                int r = src[0];
                int c = src[1];

                for (int x = 0; x < 4; x++) {
                    int nr = r + dr[x];
                    int nc = c + dc[x];

                    if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc]) {
                        String key = nr + " " + nc;
                        int[] cell = map.computeIfAbsent(key, k -> new int[]{nr, nc, 0});
                        cell[2] = Math.max(cell[2], src[2]);
                    }
                }
            }

            for (String s : map.keySet()) {
                String[] a = s.split(" ");
                int r = Integer.parseInt(a[0]);
                int c = Integer.parseInt(a[1]);

                if (!visited[r][c]) {
                    int[] cell = map.get(s);
                    visited[r][c] = true;
                    grid[r][c] = cell[2];
                    queue.offer(cell);
                }
            }
        }

        return grid;
    }
}
