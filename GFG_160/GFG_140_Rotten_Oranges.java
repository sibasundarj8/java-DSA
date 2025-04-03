package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
 *
 * # Rotten Oranges
 *
 *   Q. Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values
 *      0, 1 or 2,
 *
 *      Which has the following meaning:
 *       0: Empty cell
 *       1: Cell have fresh oranges
 *       2: Cell have rotten oranges
 *
 *      We have to determine what is the earliest time after which all the oranges are rotten.
 *      A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j),
 *      (i, j-1), (i, j+1) (up, down, left and right) in a unit time.
 *
 *      Note: Your task is to return the minimum time to rot all the fresh oranges. If not
 *            possible, returns -1.
 *    Ex.
 *      Input : mat[][] = [[0, 1, 2],
 *                         [0, 1, 2],
 *                         [2, 1, 1]]
 *      Output: 1
 *      Explanation: Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1),
 *                   (2,2) and (2,1) in unit time.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GFG_140_Rotten_Oranges {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimension matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        System.out.println("""
                            Enter 0 -> Empty cell
                                  1 -> Cell have fresh oranges
                                  2 -> Cell have rotten oranges
                            """);
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(orangesRotting(arr));
    }

    /// Solution
    static int orangesRotting(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                if (mat[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    visited [i][j] = true;
                }
            }
        }
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};
        int ans = 0;
        while (!q.isEmpty()){
            Pair p = q.poll();
            ans = Math.max(ans, p.t);
            for (int i = 0;i < 4;i++){
                int nr = p.r + dRow[i];
                int nc = p.c + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                    ! visited[nr][nc] && mat[nr][nc] == 1){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc, p.t+1));
                }
            }
        }

        for (boolean[] i : visited)
            for (boolean flag : i)
                if (!flag) return -1;

        return ans;
    }
    private static class Pair{
        int r;
        int c;
        int t;
        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
