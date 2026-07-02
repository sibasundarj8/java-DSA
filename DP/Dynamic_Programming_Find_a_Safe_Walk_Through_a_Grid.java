package DP;/*
 *
 * https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
 *
 * # LC. 3286. Find a Safe Walk Through a Grid
 *
 *   Q. You are given an m x n binary matrix grid and an integer health. You start in the upper-left corner (0, 0) and
 *      would like to get to the lower-right corner (m - 1, n - 1).
 *
 *      You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains
 *      positive.
 *
 *      Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
 *
 *      Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.
 *
 *    Ex.
 *      Input : grid = [[0   1   0 > 0 > 0]
 *                       v       ^       v
 *                      [0   1   0   1   0]
 *                       v       ^       v
 *                      [0 > 0 > 0   1   0]],
 *              health = 1
 *      Output: true
 *
 *  Constraints:
 *          m == grid.length
 *          n == grid[i].length
 *          1 <= m, n <= 50
 *          2 <= m * n
 *          1 <= health <= m + n
 *          grid[i][j] is either 0 or 1.
 */

import java.util.*;

public class Dynamic_Programming_Find_a_Safe_Walk_Through_a_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimensions of the grid: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> grid = new ArrayList<>(n);

        System.out.println("Enter elements of the grid: (either 0 or 1)");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                int ele = sc.nextInt();
                if (ele != 0 && ele != 1) throw new IllegalArgumentException("Invalid input!!");
                row.add(ele);
            }
            grid.add(row);
        }

        System.out.print("Health: ");
        int health = sc.nextInt();

        System.out.println("Can I reach bottom-right corner from top-left corner?");
        System.out.println(findSafeWalk(grid, health) ? "YES" : "NO");
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-3D-DP-(DFS)-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m * (n + m))
SC : O(n * m * (n + m))
*/
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    static boolean approach_1(List<List<Integer>> grid, int health) {
        // potd.code.hub
        int n = grid.size();
        int m = grid.getFirst().size();
        health = Math.min(n + m, health);
        int[][] mat = new int[n][m];
        boolean[][][] dp = new boolean[n][m][health + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = grid.get(i).get(j);
            }
        }

        return dfs(0, 0, (mat[0][0] == 1) ? health - 1 : health, mat, n, m, dp);
    }

    private static boolean dfs(int r, int c, int health, int[][] mat, int n, int m, boolean[][][] dp) {
        // base case
        if (r == n || c == m || health == 0 || dp[r][c][health]) return false;
        if (r == n - 1 && c == m - 1) return true;

        // it also works as a visited array marker
        dp[r][c][health] = true;

        // recursive case
        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (0 <= nr && nr < n && 0 <= nc && nc < m && !dp[nr][nc][health]) {
                if (dfs(nr, nc, (mat[nr][nc] == 1) ? health - 1 : health, mat, n, m, dp)) return true;
            }
        }

        return false;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Dijkstra-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m * log(n * m))
SC : O(n * m)
*/
    static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // potd.code.hub
        int n = grid.size();
        int m = grid.getFirst().size();

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int[][] mat = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = grid.get(i).get(j);
            }
        }

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, mat[0][0]});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            if (r == n - 1 && c == m - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && health - (h + mat[nr][nc]) > 0) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{nr, nc, h + mat[nr][nc]});
                }
            }
        }

        return false;
    }
}
