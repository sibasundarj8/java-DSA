package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-enclaves/1
 * 
 * # Number Of Enclaves
 *
 *   Q. You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents
 *      a land cell.
 *
 *      A move consists of walking from one land cell to another adjacent (4-directionally) land
 *      cell or walking off the boundary of the grid.
 *
 *      Find the number of land cells in the grid for which we cannot walk off the boundary of
 *      the grid in any number of moves.
 *   Ex.
 *      Input : grid[][] = {{0, 0, 0, 1},
 *                          {0, 1, 1, 0},
 *                          {0, 1, 1, 0},
 *                          {0, 0, 0, 1},
 *                          {0, 1, 1, 0}}
 *      Output: 4
 *      Explanation:    0  0   0  1
 *                      0 <1> <1> 0
 *                      0 <1> <1> 0
 *                      0  0   0  1
 *                      0  1   1  0
 *              The highlighted cells represent the land cells.
 */
public class Graph_Number_Of_Enclaves {

    /// main Method
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 0}};

        System.out.println(numberOfEnclaves(grid));
    }

    /// Solution
    static int numberOfEnclaves(int[][] grid) {
        // potd.code.hub
        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};

        for (int i = 0;i < n;i++){
            // First Col
            if (grid[i][0] == 1)
                dfs(i, 0, n, m, grid, visited, dRow, dCol);
            // Last Col
            if (grid[i][m-1] == 1)
                dfs(i, m-1, n, m, grid, visited, dRow, dCol);
        }

        for (int i = 0;i < m;i++){
            // First Row
            if (grid[0][i] == 1)
                dfs(0, i, n, m, grid, visited, dRow, dCol);
            // Last Row
            if (grid[n-1][i] == 1)
                dfs(n-1, i, n, m, grid, visited, dRow, dCol);
        }

        // update answer
        int ans = 0;
        for (int i = 1;i < n-1;i++)
            for (int j = 1;j < m-1;j++)
                if (grid[i][j] == 1 && !visited[i][j])
                    ans++;

        return ans;
    }
    private static void dfs (int r, int c, int n, int m, int[][]grid, boolean[][]visited, int[]dRow, int[] dCol){
        visited[r][c] = true;
        for (int i = 0;i < 4;i++){
            int nr = dRow[i] + r;
            int nc = dCol[i] + c;
            if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                !visited[nr][nc] && grid[nr][nc] == 1){
                dfs(nr, nc, n, m, grid, visited, dRow, dCol);
            }
        }
    }
}
