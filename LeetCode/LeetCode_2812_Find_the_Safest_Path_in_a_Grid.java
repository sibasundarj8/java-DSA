package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-safest-path-in-a-grid/
 *
 * # LC. 2812. Find the Safest Path in a Grid
 *
 *   Q. You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
 *        ◦ A cell containing a thief if grid[r][c] = 1
 *        ◦ An empty cell if grid[r][c] = 0
 *
 *      You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including
 *      cells containing thieves.
 *
 *      The safeness factor of a path on the grid is defined as the minimum Manhattan distance from any cell in the path
 *      to any thief in the grid.
 *
 *      Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
 *
 *      An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
 *
 *      The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the
 *      absolute value of val.
 *
 *    Ex.
 *      Input: grid = [[0,--0,  0,  1],
 *                          |
 *                     [0,  0,--0,  0],
 *                              |
 *                     [0,  0,  0,  0],
 *                              |
 *                     [1,  0,  0,--0]]
 *      Output: 2
 *      Explanation: The path depicted in the picture above has a safeness factor of 2 since:
 *
 *                     - The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between
 *                       them is | 0 - 1 | + | 3 - 2 | = 2.
 *
 *                     - The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between
 *                       them is | 3 - 3 | + | 0 - 2 | = 2.
 *
 *                   It can be shown that there are no other paths with a higher safeness factor.
 *
 *  Constraints:
 *      1 <= grid.length == n <= 400
 *      grid[i].length == n
 *      grid[i][j] is either 0 or 1.
 *      There is at least one thief in the grid.
 */

import java.util.*;

public class LeetCode_2812_Find_the_Safest_Path_in_a_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of grid: ");
        int n = sc.nextInt();
        List<List<Integer>> grid = new ArrayList<>();

        System.out.println("Enter elements of grid: (0 for empty cell and 1 for thief): ");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int ele = sc.nextInt();
                if (0 != ele && 1 != ele) throw new IllegalArgumentException("Invalid input!");
                row.add(ele);
            }
            grid.add(row);
        }

        System.out.println("Safe score of the safest path: ");
        System.out.println(maximumSafenessFactor(grid));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--dijkstra-algo--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n² log n)
TC : O(n²)
*/
    static int approach_1(List<List<Integer>> grid) {
        int n = grid.size();
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int[][] safeScores = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        // initialize the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                } else safeScores[i][j] = -1;
            }
        }

        if (q.isEmpty()) return 0;

        // multi source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dRow[i];
                int nc = curr[1] + dCol[i];
                int newScore = curr[2] + 1;
                if (0 <= nr && nr < n && 0 <= nc && nc < n && safeScores[nr][nc] == -1) {
                    safeScores[nr][nc] = newScore;
                    q.offer(new int[]{nr, nc, newScore});
                }
            }
        }

        // Dijkstra to get longest path
        int safeScore = n;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
        pq.offer(new int[]{0, 0, safeScores[0][0]});
        safeScores[0][0] = -1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            safeScore = Math.min(safeScore, curr[2]);
            if (curr[0] == n - 1 && curr[1] == n - 1) break;

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dRow[i];
                int nc = curr[1] + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && safeScores[nr][nc] != -1) {
                    pq.add(new int[]{nr, nc, safeScores[nr][nc]});
                    safeScores[nr][nc] = -1;
                }
            }
        }

        return safeScore;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--binary-search--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n² log n)
SC : O(n²)
*/
    static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int[][] safeScores = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        // initialize the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                } else safeScores[i][j] = -1;
            }
        }

        if (q.isEmpty()) return 0;

        // multi source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dRow[i];
                int nc = curr[1] + dCol[i];
                int newScore = curr[2] + 1;
                if (0 <= nr && nr < n && 0 <= nc && nc < n && safeScores[nr][nc] == -1) {
                    safeScores[nr][nc] = newScore;
                    q.offer(new int[]{nr, nc, newScore});
                }
            }
        }

        // binary search on answer
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (isPossible(safeScores, mid, dRow, dCol)) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }

    private static boolean isPossible(int[][] grid, int score, int[] dRow, int[] dCol) {
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        if (grid[0][0] >= score) {
            q.add(new int[]{0, 0});
            visited[0][0] = true;
        }

        // BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dRow[i];
                int nc = curr[1] + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && grid[nr][nc] >= score && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}
