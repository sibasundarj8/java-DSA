package Graph;/*
 *
 *  https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
 *
 *  # Rotten Oranges
 *
 *   Q. Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2
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
 *
 *  Constraints:
 *          1 ≤ mat.size() ≤ 500
 *          1 ≤ mat[0].size() ≤ 500
 *          mat[i][j] = {0, 1, 2}
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Rotten_Oranges {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions :");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][]box = new int[n][m];

        System.out.println("Enter Oranges :");
        System.out.println("1 for fresh Orange\n2 for rotten Orange\n0 for no Orange");

        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                box[i][j] = sc.nextInt();
            }
        }

        System.out.println(orangesRot(box));
    }

    ///  Solution
    static int orangesRot(int[][] mat) {
        // potd.code.hub
        int ans = 0;
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row();
            int c = curr.col();
            int t = curr.time();
            ans = Math.max(ans, curr.time());

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1) {
                    mat[nr][nc] = 2;
                    q.add(new Pair(nr, nc, t + 1));
                }
            }
        }

        for (int[] arr : mat) {
            for (int j = 0; j < m; j++) {
                if (arr[j] == 1) return -1;
            }
        }

        return ans;
    }

    private record Pair(int row, int col, int time) {}
}
