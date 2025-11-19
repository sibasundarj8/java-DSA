package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1
 *
 * # Path With Minimum Effort
 *
 *   Q. You are given a 2D array mat[][], of size n*m. Your task is to find the minimum possible path cost from the
 *      top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent
 *      cells.
 *
 *      Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive
 *            cells along that path.
 *
 *    Ex.
 *      Input : mat[][] = [[(2),(2),(2), 1],
 *                         [ 8,  1, (2), 7],
 *                         [(2),(2),(2), 8],
 *                         [(2), 1,  4,  7],
 *                         [(2),(2),(2),(2)]]
 *      Output: 0
 *      Explanation: The route of [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] has a minimum value of maximum absolute difference
 *                   between any two consecutive cells in the route, i.e., 0.
 *
 *  Constraints:
 *      1 ≤ n, m ≤ 100
 *      0 ≤ mat[i][j] ≤ 10⁶
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph_Path_With_Minimum_Effort {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] = sc.nextInt();

        System.out.println("Minimum possible path cost form (0, 0) to (n-1, m-1) : ");
        System.out.println(minCostPath(mat));
    }

    /// Solution
    public static int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int wt = cur[2];

            visited[i][j] = true;

            if(i == n - 1 && j == m - 1) return wt;

            for(int x = 0; x < 4; x++) {
                int di = i + row[x];
                int dj = j + col[x];

                if(0 <= di && di < n && 0 <= dj && dj < m && !visited[di][dj]) {
                    int cost = Math.abs(mat[i][j] - mat[di][dj]);
                    q.add(new int[]{di, dj, Math.max(wt, cost)});
                }
            }
        }

        return -1;
    }
}
