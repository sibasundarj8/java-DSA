package LeetCode;/*
 *
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 *
 * # 2257. Count Unguarded Cells in the Grid
 *
 *   Q. You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays
 *      guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith
 *      guard and jth wall respectively.
 *
 *      A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their
 *      position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that
 *      can see it.
 *
 *      Return the number of unoccupied cells that are not guarded.
 *   Ex.
 *      Input : m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 *      Output: 7
 *      Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
 *                   There are a total of 7 unguarded cells, so we return 7.
 *
 *  Constraints:
 *      • 1 <= m, n <= 10⁵
 *      • 2 <= m * n <= 10⁵
 *      • 1 <= guards.length, walls.length <= 5 * 10⁴
 *      • 2 <= guards.length + walls.length <= m * n
 *      • guards[i].length == walls[j].length == 2
 *      • 0 <= rowi, rowj < m
 *      • 0 <= coli, colj < n
 *      • All the positions in guards and walls are unique.
 */

public class LeetCode_2257_Count_Unguarded_Cells_in_the_Grid {

    /// main Method
    public static void main(String[] args) {
        int m = 4;
        int n = 6;

        int[][] guards = {
                {0,0},
                {1,1},
                {2,3}
        };
        int[][] walls = {
                {0,1},
                {2,2},
                {1,4}
        };

        System.out.println("Number of unguarded cells: " + countUnguarded(m, n, guards, walls));
    }

    /// Solution
    static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] flag = new int[m][n];

        for(int[] i : guards) flag[i[0]][i[1]] = 1;
        for(int[] i : walls) flag[i[0]][i[1]] = -1;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(flag[i][j] == 1) simulate(i, j, m, n, flag);

        int ans = 0;
        for(int[] i : flag)
            for(int j : i)
                if(j == 0) ans++;

        return ans;
    }

    private static void simulate(int i, int j, int m, int n, int[][] flag) {
        // down
        for (int x = i + 1; x < m; x++) {
            if (flag[x][j] == -1 || flag[x][j] == 1) break;
            flag[x][j] = 5;
        }

        // up
        for (int x = i - 1; x >= 0; x--) {
            if (flag[x][j] == -1 || flag[x][j] == 1) break;
            flag[x][j] = 5;
        }

        // right
        for (int x = j + 1; x < n; x++) {
            if (flag[i][x] == -1 || flag[i][x] == 1) break;
            flag[i][x] = 5;
        }

        // left
        for (int x = j - 1; x >= 0; x--) {
            if (flag[i][x] == -1 || flag[i][x] == 1) break;
            flag[i][x] = 5;
        }
    }
}
