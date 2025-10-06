package LeetCode;/*
 *
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * # 778. Swim in Rising Water
 *
 *   Q. You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at
 *      that point (i, j).
 *
 *      It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any
 *      cell with elevation less than equal to t is submerged or reachable.
 *
 *      You can swim from a square to another 4-directionally adjacent square if and only if the elevation
 *      of both squares individually are at most t. You can swim infinite distances in zero time. Of course,
 *      you must stay within the boundaries of the grid during your swim.
 *
 *      Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at
 *      the top left square (0, 0).
 *   Ex.
 *      Input : grid = [[ 0,  1,  2,  3,  4],
 *                      [24, 23, 22, 21,  5],
 *                      [12, 13, 14, 15, 16],
 *                      [11, 17, 18, 19, 20],
 *                      [10,  9,  8,  7,  6]]
 *      Output: 16
 *      Explanation: The final route is shown.
 *                   We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 *
 *  Constraints:
 *      •  n == grid.length
 *      •  n == grid[i].length
 *      •  1 <= n <= 50
 *      •  0 <= grid[i][j] < n²
 *      •  Each value grid[i][j] is unique.
 */

import java.util.*;

public class LeetCode_778_Swim_in_Rising_Water {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter elements for " + n + "×" + n + " matrix: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        System.out.println("Minimum time to swim from (0,0) to (" + (n - 1) + "," + (n - 1) + "): ");
        System.out.println(swimInWater(grid));
    }

    /// Solution
/*
.......................................................Brute-Force.......................................................
TC : O(n² log n)   ---> traversing the grid for many value of t.
SC : O(n²)
*/
    static int bruteForce(int[][] grid) {
        int l = 0;  // min possible answer
        int r = 0;  // max possible answer
        int time = 0;

        for (int[] arr : grid)
            for (int ele : arr)
                r = Math.max(r, ele);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canReach(mid, grid)) {
                time = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        return time;
    }

    // helper method
    private static boolean canReach(int t, int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        if(grid[0][0] <= t) q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            visited[i][j] = true;

            // for four directions
            for (int x = 0; x < 4; x++) {
                int ni = i + di[x];
                int nj = j + dj[x];

                if (0 <= ni && ni < n && 0 <= nj && nj < n && grid[ni][nj] <= t && !visited[ni][nj]) {
                    if (ni == n - 1 && nj == n - 1) return true;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        return false;
    }

/*
........................................................Optimized........................................................
TC : O(n² log n)  --> traverse the array for only once and store the time;
SC : O(n²)
*/
    static int swimInWater(int[][] grid) {
        int n = grid.length;
        int t = grid[0][0];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> grid[a[0]][a[1]]));
        boolean[][] visited = new boolean[n][n];
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        pq.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int i = cur[0];
            int j = cur[1];

            if (grid[i][j] > t) t = grid[i][j];
            if (i == n - 1 && j == n - 1) break;

            // for four directions
            for (int x = 0; x < 4; x++) {
                int ni = i + di[x];
                int nj = j + dj[x];

                if (0 <= ni && ni < n && 0 <= nj && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.add(new int[]{ni, nj});
                }
            }
        }

        return t;
    }
}
