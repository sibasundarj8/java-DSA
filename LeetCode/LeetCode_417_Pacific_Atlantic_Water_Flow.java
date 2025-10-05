package LeetCode;/*
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * # 417. Pacific Atlantic Water Flow
 *
 *   Q. There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The
 *      Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's
 *      right and bottom edges.
 *
 *      The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights
 *      where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 *      The island receives a lot of rain, and the rain water can flow to neighboring cells directly north,
 *      south, east, and west if the neighboring cell's height is less than or equal to the current cell's
 *      height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 *      Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can
 *      flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *   Ex.
 *      Input: heights = [[1, 2, 2, 3, 5],                                          <-----Pacific Ocean ✕
 *                        [3, 2, 3, 4, 4],                                          | 1   2   2   3   5 |
 *                        [2, 4, 5, 3, 1],                                          | 3   2   3   4   4 |
 *                        [6, 7, 1, 4, 5],                                          | 2   4   5   3   1 |
 *                        [5, 1, 1, 2, 4]]                                          | 6   7   1   4   5 |
 *                                                                                  | 5   1   1   2   4 |
 *                                                                                  ✕ Atlantic Ocean---->
 *      Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 *      Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
 *                   [0, 4]: [0, 4] -> Pacific Ocean
 *                           [0, 4] -> Atlantic Ocean
 *                   [1, 3]: [1, 3] -> [0, 3] -> Pacific Ocean
 *                           [1, 3] -> [1, 4] -> Atlantic Ocean
 *                   [1, 4]: [1, 4] -> [1, 3] -> [0, 3] -> Pacific Ocean
 *                           [1, 4] -> Atlantic Ocean
 *                   [2, 2]: [2, 2] -> [1, 2] -> [0, 2] -> Pacific Ocean
 *                           [2, 2] -> [2, 3] -> [2, 4] -> Atlantic Ocean
 *                   [3, 0]: [3, 0] -> Pacific Ocean
 *                           [3, 0] -> [4, 0] -> Atlantic Ocean
 *                   [3, 1]: [3, 1] -> [3, 0] -> Pacific Ocean
 *                           [3, 1] -> [4, 1] -> Atlantic Ocean
 *                   [4, 0]: [4, 0] -> Pacific Ocean
 *                           [4, 0] -> Atlantic Ocean
 *               Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 *
 *  Constraints:
 *    • m == heights.length
 *    • n == heights[r].length
 *    • 1 <= m, n <= 200
 *    • 0 <= heights[r][c] <= 10⁵
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LeetCode_417_Pacific_Atlantic_Water_Flow {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] heights = new int[n][m];

        System.out.println("Enter heights: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                heights[i][j] = sc.nextInt();

        System.out.println("Coordinates from where rain water can flow to both the Pacific and Atlantic oceans: ");
        System.out.println(pacificAtlantic(heights));
    }

    /// Solution
/*
-------------------------------------------------------Brute-Force-------------------------------------------------------
TC : O((n×m)²)
SC : O(n×m)
*/
    static List<List<Integer>> bruteForce(int[][] heights) {
        // potd.code.hub
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> coordinates = new LinkedList<>();
        boolean[][] both = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bfs(i, j, heights, both)) {
                    both[i][j] = true;
                    coordinates.add(List.of(i, j));
                }
            }
        }

        return coordinates;
    }

    private static Boolean bfs(int i, int j, int[][] heights, boolean[][] both) {
        int n = heights.length;
        int m = heights[0].length;
        boolean atlantic = false;
        boolean pacific = false;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};

        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (both[curr[0]][curr[1]]) return true;
            if (curr[0] == 0 || curr[1] == 0) pacific = true;
            if (curr[0] == n - 1 || curr[1] == m - 1) atlantic = true;

            visited[curr[0]][curr[1]] = true;

            // for four directions ---> (west -> north -> east -> south)
            for (int x = 0; x < 4; x++) {
                int ni = curr[0] + di[x];
                int nj = curr[1] + dj[x];
                if (0 <= ni && ni < n && 0 <= nj && nj < m && heights[ni][nj] <= heights[curr[0]][curr[1]] && !visited[ni][nj])
                    q.add(new int[]{ni, nj});
            }
        }

        return pacific && atlantic;
    }

/*
--------------------------------------------------------Optimized--------------------------------------------------------
TC : O(n×m)
SC : O(n×m)
*/
    static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // potd.code.hub
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> coordinates = new LinkedList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        // directions -> W -> N -> E -> S
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};

        for (int i = 0; i < m; i++) {
            if (!pacific[0][i]) dfs(0, i, n, m, di, dj, heights, pacific);
            if (!atlantic[n - 1][i]) dfs(n - 1, i, n, m, di, dj, heights, atlantic);
        }
        for (int i = 0; i < n; i++) {
            if (!pacific[i][0]) dfs(i, 0, n, m, di, dj, heights, pacific);
            if (!atlantic[i][m - 1]) dfs(i, m - 1, n, m, di, dj, heights, atlantic);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    coordinates.add(List.of(i, j));
                }
            }
        }

        return coordinates;
    }

    private static void dfs(int i, int j, int n, int m, int[] di, int[] dj, int[][] heights, boolean[][] visited) {
        // base case
        if (i < 0 || j < 0 || i >= n || j >= m) return;

        // self work
        visited[i][j] = true;

        for (int x = 0; x < 4; x++) {
            int ni = i + di[x];
            int nj = j + dj[x];
            if (0 <= ni && ni < n && 0 <= nj && nj < m && heights[ni][nj] >= heights[i][j] && !visited[ni][nj]) {
                // recursive work
                dfs(ni, nj, n, m, di, dj, heights, visited);
            }
        }
    }
}
