package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-possible-route-in-a-matrix-with-hurdles/1
 *
 * # Longest Possible Route in a Matrix with Hurdles
 *
 *   Q. Given a binary matrix mat[][] of size n × m containing values 0 and 1, and four integers xs, ys, xd, and yd
 *      representing the source cell (xs, ys) and destination cell (xd, yd), find the length of the longest possible
 *      path from the source cell to the destination cell.
 *
 *      From any cell, you can move to its adjacent cells in the up, down, left, and right directions.
 *
 *        ◦ 1 represents a traversable cell.
 *        ◦ 0 represents a blocked cell that cannot be visited.
 *        ◦ A cell can be visited at most once in a path.
 *        ◦ If the destination cannot be reached from the source, return -1.
 *
 *    Ex.
 *      Input : mat[][] = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
 *                         [1, 1, 0, 1, 1, 0, 1, 1, 0, 1],
 *                         [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]],
 *              xs = 0, ys = 0,
 *              xd = 1, yd = 7
 *      Output: 24
 *      Explanation: The longest valid path from (0, 0) to (1, 7) without revisiting any cell has length 24.
 *
 *  Constraints:
 *        1 ≤ n, m ≤ 10
 *        mat[i][j] == 0 or mat[i][j] == 1
 *        The source and destination cells are always inside the matrix.
 */

import java.util.Scanner;

public class POTD_Longest_Possible_Route_in_a_Matrix_with_Hurdles {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of binary matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: (allowed: 0 or 1)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ele = sc.nextInt();
                if (ele != 0 && ele != 1) throw new IllegalArgumentException("Invalid input!");
                mat[i][j] = ele;
            }
        }

        System.out.println("Enter source position: ");
        int xs = sc.nextInt();
        int ys = sc.nextInt();

        if (xs < 0 || xs >= n || ys < 0 || ys >= m) throw new IllegalArgumentException("Invalid source position!");

        System.out.println("Enter destination position: ");
        int xd = sc.nextInt();
        int yd = sc.nextInt();

        if (xd < 0 || xd >= n || yd < 0 || yd >= m) throw new IllegalArgumentException("Invalid destination position!");

        System.out.println("Longest part from source to destination: ");
        System.out.println(longestPath(mat, xs, ys, xd, yd));
    }

    /// Solution
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    static int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // potd.code.hub
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) return -1;

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[xs][ys] = true;

        return solve(xs, ys, xd, yd, n, m, mat, visited);
    }

    private static int solve(int x, int y, int xd, int yd, int n, int m, int[][] mat, boolean[][] visited) {
        // base case
        if (x == xd && y == yd) return 0;

        // recursive case
        int max = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dRow[i];
            int ny = y + dCol[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m && mat[nx][ny] != 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                max = Math.max(max, solve(nx, ny, xd, yd, n, m, mat, visited));
                visited[nx][ny] = false;
            }
        }

        return (max == -1) ? -1 : max + 1;
    }
}
