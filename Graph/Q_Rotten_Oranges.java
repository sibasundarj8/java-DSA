/*
 *  Q.  Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2
 *      which has the following meaning:
 *      0 : Empty cell
 *      1 : Cells have fresh oranges
 *      2 : Cells have rotten oranges
 *
 *      We have to determine what is the earliest time after which all the oranges are rotten.
 *      A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j],
 *      [i,j-1], [i,j+1] (up, down, left and right) in unit time.
 *
 *    Ex.   Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
 *          Output: 1
 *          Explanation: The grid is - 0 1 2
 *                                     0 1 2
 *                                     2 1 1
 *                      Oranges at positions (0,2), (1,2), (2,0)
 *                      will rot oranges at (0,1), (1,1), (2,2) and
 *                      (2,1) in unit time.
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_Rotten_Oranges {
    static class Pair{
        int row, col,time;
        Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimensions :");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]box = new int[n][m];
        System.out.println("Enter Oranges :");
        System.out.println("1 for fresh Orange\n2 for rotten Orange\n0 for no Orange");
        for (int i = 0;i < n;i++)
            for (int j = 0;j < m;j++)
                box[i][j] = sc.nextInt();

        System.out.println(orangesRotting(box));
    }
    static int orangesRotting(int[][] grid) {
        // potd.code.hub
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visit = new int[n][m];
        int fresh = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visit[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
                if (grid[i][j] == 1) fresh++;
            }
        }
        int tm = 0; // time
        int[]dRow = {-1, 0, 1, 0};
        int[]dCol = {0, 1, 0, -1};
        int count = 0;
        while (!q.isEmpty()){
            Pair p = q.remove();
            tm = Math.max(tm,p.time);
            for (int i = 0;i < 4;i++){
                int nr = dRow[i] + p.row;
                int nc = dCol[i] + p.col;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        visit[nr][nc] == 0 && grid[nr][nc] == 1){
                    visit[nr][nc] = 2;
                    q.add(new Pair(nr,nc,tm+1));
                    count++;
                }
            }
        }
        if (fresh > count) return -1;
        System.out.println("Time taken :");
        return tm;
    }
}