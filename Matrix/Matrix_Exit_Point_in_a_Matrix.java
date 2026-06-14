package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
 *
 * # Exit Point in a Matrix
 *
 *   Q. Given a matrix mat[][] of size n × m consisting of 0s and 1s. You start at the top-left cell (0, 0) and initially
 *      move in the left-to-right direction (i.e., towards the right).
 *
 *      While traversing the matrix, follow these rules:
 *        ◦ If the current cell contains 0, continue moving in the same direction.
 *        ◦ If the current cell contains 1, change your direction to the right (clockwise turn), and update the cell
 *          value to 0.
 *
 *      You continue this process until you move outside the boundaries of the matrix. Your task is to determine the
 *      coordinates (row and column index) of the cell from which you exit the matrix.
 *
 *    Ex.
 *      Input : mat[][] = [[0, 1, 0],
 *                         [0, 1, 1],
 *                         [0, 0, 0]]
 *      Output: [1, 0]
 *      Explanation:
 *              From the image we can see that, enter the matrix at (0, 0)
 *              -> then move towards (0, 1) ->  1 is encountered
 *              -> turn right towards (1, 1)  -> again 1 is encountered
 *              -> turn right again towards (1, 0)
 *              -> now, the boundary of matrix will be crossed. Hence, exit point reached at [1, 0].
 *
 *  Constraints:
 *      1 ≤ n, m ≤ 100
 */

import java.util.List;
import java.util.Scanner;

public class Matrix_Exit_Point_in_a_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of the matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: (either 0 or 1)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
                if (mat[i][j] != 0 && mat[i][j] != 1) {
                    throw new IllegalArgumentException("matrix elements must be either 0 or 1");
                }
            }
        }

        System.out.println("Exit point of the matrix: ");
        System.out.println(exitPoint(mat));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-recursive-method-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(n * m)
*/
    static List<Integer> approach_1(int[][] mat) {
        // potd.code.hub
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        return solve(0, 0, 1, mat, mat.length, mat[0].length, dRow, dCol);
    }

    private static List<Integer> solve(int i, int j, int dir, int[][] mat, int n, int m, int[] dRow, int[] dCol) {
        if (mat[i][j] == 1) {
            mat[i][j] = 0;
            dir = (dir + 1) % 4;
        }
        int nr = i + dRow[dir];
        int nc = j + dCol[dir];

        if (0 <= nr && nr < n && 0 <= nc && nc < m) {
            return solve(nr, nc, dir, mat, n, m, dRow, dCol);
        } else {
            return List.of(i, j);
        }
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-iterative-method-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(1)
*/
    static List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int r = 0;
        int c = 0;
        int dir = 1;

        while (true) {
            if (mat[r][c] == 1) {
                dir = (dir + 1) % 4;
                mat[r][c] = 0;
            }

            int nr = r + dRow[dir];
            int nc = c + dCol[dir];

            if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                r = nr;
                c = nc;
            } else {
                return List.of(r, c);
            }
        }
    }
}
