package Graph;/* 
 *
 * https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
 *
 * # Number of Distinct Islands
 *
 *   Q. Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct
 *      islands where a group of connected 1's (horizontally or vertically) forms an island.
 *      Two islands are considered to be distinct if and only if one island is not equal to
 *      another (not rotated or reflected).
 *   Ex.
 *      Input : grid[][] = {{1, 1, 0, 1, 1},
 *                          {1, 0, 0, 0, 0},
 *                          {0, 0, 0, 0, 1},
 *                          {1, 1, 0, 1, 1}}
 *      Output: 3
 *      Explanation: grid[][] =  {1}  {1}  0  <1>  <1>
 *                               {1}   0   0   0    0
 *                                0    0   0   0   [1]
 *                               <1>  <1>  0  [1]  [1]
 *                   Same colored islands are equal.
 *                   We have 4 islands, but 2 of them
 *                   are equal, So we have 3 distinct islands.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Graph_Number_of_Distinct_Islands {

    /// main Method
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}};

        System.out.println(countDistinctIslands(grid));
    }

    /// Solution
    static int countDistinctIslands(int[][] grid) {
        // potd.code.hub
        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};

        HashSet<List<String>> set = new HashSet<>();

        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (!visited[i][j] && grid[i][j] == 1){
                    List<String> temp = new ArrayList<>();
                    dfs(i, j, n, m, grid, visited, dRow, dCol, temp, i, j);
                    set.add(temp);
                }
            }
        }

        return set.size();
    }
    private static void dfs (int r, int c, int n, int m, int[][]grid, boolean[][]visited, int[]dRow, int[] dCol, List<String> temp, int baseR, int baseC){
        visited[r][c] = true;
        temp.add(toString(r-baseR, c-baseC));
        for (int i = 0;i < 4;i++){
            int nr = dRow[i] + r;
            int nc = dCol[i] + c;
            if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                    !visited[nr][nc] && grid[nr][nc] == 1){
                dfs(nr, nc, n, m, grid, visited, dRow, dCol, temp, baseR, baseC);
            }
        }
    }
    private static String toString(int i, int j){
        return i + "," + j;
    }
}
