package LeetCode;/*
 *
 * https://leetcode.com/problems/trapping-rain-water-ii/
 *
 * # 407. Trapping Rain Water II  (Hard)
 *
 *   Q. Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation
 *      map, return the volume of water it can trap after raining.
 *    Ex.
 *      Input : heightMap = [[1, 4, 3, 1, 3, 2],
 *                           [3, 2, 1, 3, 2, 4],
 *                           [2, 3, 3, 2, 3, 1]]
 *      Output: 4
 *      Explanation: After the rain, water is trapped between the blocks.
 *                   We have two small ponds 1 and 3 units trapped.
 *                   The total volume of water trapped is 4.
 *  Constraints:
 *        m == heightMap.length
 *        n == heightMap[i].length
 *        1 <= m, n <= 200
 *        0 <= heightMap[i][j] <= 2 * 10⁴
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class LeetCode_407_Trapping_Rain_Water_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of matrix: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] heightMap = new int[r][c];

        System.out.println("Enter heights: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                heightMap[i][j] = sc.nextInt();
            }
        }

        System.out.println("volume of water trapped: " + trapRainWater(heightMap));
    }

    /// Solution
/*
.......................................................Brute-Force.......................................................
TC: O((r×c)² log(r×c))
SC: O(r×c)
*/
    static int bruteForce(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        int volume = 0;

        int[][] visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1)
                    visited[i][j] = heightMap[i][j];
                else visited[i][j] = -1;
            }
        }

        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                if (visited[i][j] == -1) {
                    dijkstra(i, j, r, c, heightMap, visited);
                }
            }
        }

        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                volume += visited[i][j] - heightMap[i][j];
            }
        }

        return volume;
    }

    // helper method  --> dijkstra like approach
    private static void dijkstra(int i, int j, int r, int c, int[][] heightMap, int[][] visited) {
        int x = i;
        int y = j;

        int[][] parentRow = new int[r][c];
        int[][] parentCol = new int[r][c];
        boolean[][] visit = new boolean[r][c];
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};

        Queue<int[]> q = new PriorityQueue<>((u, v) -> {
            int a = Math.max(heightMap[u[0]][u[1]], visited[u[0]][u[1]]);
            int b = Math.max(heightMap[v[0]][v[1]], visited[v[0]][v[1]]);
            return a - b;
        });

        q.add(new int[]{i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (visited[cur[0]][cur[1]] != -1) {
                x = cur[0];
                y = cur[1];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (0 <= ni && ni < r && 0 <= nj && nj < c && !visit[ni][nj]) {
                    q.add(new int[]{ni, nj});
                    visit[ni][nj] = true;
                    parentRow[ni][nj] = cur[0];
                    parentCol[ni][nj] = cur[1];
                }
            }
        }

        while (x != i || y != j) {
            int val = visited[x][y];
            int t = x;
            x = parentRow[x][y];
            y = parentCol[t][y];
            visited[x][y] = Math.max(heightMap[x][y], val);
        }
    }

/*
.........................................................Optimal.........................................................
*/
    static class Cell {
        int r, c, height;

        Cell(int r, int c, int height) {
            this.r = r;
            this.c = c;
            this.height = height;
        }
    }

    static int trapRainWater(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        int volume = 0;

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        boolean[][] visited = new boolean[r][c];
        Queue<Cell> q = new PriorityQueue<>((a, b) -> a.height - b.height);

        // setting all boundary elements to start traversing form the shortest  boundary Cell.
        for (int i = 0; i < r; i++) {
            visited[i][0] = true;
            visited[i][c - 1] = true;
            q.add(new Cell(i, 0, heightMap[i][0]));
            q.add(new Cell(i, c - 1, heightMap[i][c - 1]));
        }
        for (int i = 0; i < c; i++) {
            visited[0][i] = true;
            visited[r - 1][i] = true;
            q.add(new Cell(0, i, heightMap[0][i]));
            q.add(new Cell(r - 1, i, heightMap[r - 1][i]));
        }

        // dijkstra like algorithm
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            volume += cell.height - heightMap[cell.r][cell.c];

            for (int x = 0; x < 4; x++) {
                int ni = cell.r + di[x];
                int nj = cell.c + dj[x];

                if (0 <= ni && ni < r && 0 <= nj && nj < c && !visited[ni][nj]) {
                    q.add(new Cell(ni, nj, Math.max(heightMap[ni][nj], cell.height)));
                    visited[ni][nj] = true;
                }
            }
        }

        return volume;
    }
}
