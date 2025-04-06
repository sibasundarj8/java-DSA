package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
 *
 * # Distance of nearest cell having
 *
 *   Q. Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
 *      The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column
 *      number of the current cell, and i2, j2 are the row number and column number of the nearest cell
 *      having value 1. There should be at-least one 1 in the grid.
 *   Ex.
 *      Input : grid = [[ 0, 1, 1, 0],
 *                      [ 1, 1, 0, 0],
 *                      [ 0, 0, 1, 1]]
 *      Output: [[ 1, 0, 0, 1],
 *               [ 0, 0, 1, 1],
 *               [ 1, 1, 0, 0]]
 *      Explanation:
 *              The grid is-
 *              0 1 1 0
 *              1 1 0 0
 *              0 0 1 1
 *        - 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1),
 *         (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.
 */
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Distance_of_nearest_cell_having_1 {

    /// main Method
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0},
                        {1, 1, 0, 0},
                        {0, 0, 1, 1}};
        int[][] ans = nearest(grid);

        for (int[] i : ans){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static int[][] nearest(int[][] grid){
        // potd.code.hub
        int n = grid.length, m = grid[0].length;
        int[][]ans = new int[n][m];
        bfs(grid, ans, n, m);

        return ans;
    }
    private static void bfs (int[][]grid, int[][]ans, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == 1){
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};

        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0;i < 4;i++){
                int newR = p.r + dRow[i];
                int newC = p.c + dCol[i];
                if (0 <= newR && newR < n && 0 <= newC && newC < m &&
                    ans[newR][newC] == 0 && grid[newR][newC] == 0){
                    q.offer(new Pair(newR, newC, p.d+1));
                    ans[newR][newC] = p.d+1;
                }
            }
        }
    }
    private static class Pair {
        int r, c, d;
        public Pair(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
