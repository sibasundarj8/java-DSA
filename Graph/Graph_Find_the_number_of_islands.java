package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-number-of-islands/0
 *
 * # Find the number of islands
 *
 *   Q. Given a grid of size n*m (n is the number of rows, and m is the number of columns in the
 *      grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.
 *
 *      Note: An island is either surrounded by water or the boundary of a grid and is formed by
 *            connecting adjacent lands horizontally or vertically or diagonally, i.e., in all 8
 *            directions.
 *    Ex.
 *      Input: grid[][] = [[L, L, W, W, W],
 *                         [W, L, W, W, L],
 *                         [L, W, W, L, L],
 *                         [W, W, W, W, W],
 *                         [L, W, L, L, W]]
 *      Output: 4
 *      Explanation:
 *              The image below shows all the 4 islands in the grid.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Graph_Find_the_number_of_islands {

    /// main Method
    public static void main(String[] args) {
        char[][] grid = {{'L', 'L', 'W', 'W', 'W'},
                         {'W', 'L', 'W', 'W', 'L'},
                         {'L', 'W', 'W', 'L', 'L'},
                         {'W', 'W', 'W', 'W', 'W'},
                         {'L', 'W', 'L', 'L', 'W'}};

        System.out.println(countIslands(grid));
    }

    /// Solution
    static int countIslands(char[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;

        boolean[][]visited = new boolean[n][m];
        int ans = 0;

        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (grid[i][j] == 'L' && !visited[i][j]){
                    ans++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return ans;
    }
    private static void bfs(char[][] grid, boolean[][]visited, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;
        int[] dRow = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dCol = {-1, -1, 0, 1, 1, 1, 0, -1};
        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0;i < 8;i++){
                int nr = p.r + dRow[i];
                int nc = p.c + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                    grid[nr][nc] == 'L' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
    private static class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
