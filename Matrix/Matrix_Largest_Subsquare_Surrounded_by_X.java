package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-subsquare-surrounded-by-x0558/1
 *
 * # Largest Subsquare Surrounded by X
 *
 *   Q. Given a square matrix mat[][] of size n × n, where each cell contains either 'X' or 'O'. Find the size of the
 *      largest square submatrix whose boundary is completely surrounded by 'X'. The cells inside the submatrix can
 *      contain either 'X' or 'O'. Only the four sides of the submatrix must contain 'X'.
 *
 *      Return side length of the largest such square submatrix.
 *
 *      Note: A square of size 1 is valid if its only cell is 'X'. If no such square submatrix exists, return 0.
 *
 *    Ex.
 *      Input : mat[][] = [[X, X, X, O],
 *                         [X, O, X, X],
 *                         [X, X, X, O],
 *                         [X, O, X, X]]
 *      Output: 3
 *      Explanation: Here, the input represents following matrix of size 4 x 4
 *                                                                              X  -  X  -  X     O
 *                                                                              |           |
 *                                                                              X     O     X     X
 *                                                                              |           |
 *                                                                              X  -  X  -  X     O
 *
 *                                                                              X     O     X     X
 *
 *                   The square submatrix starting at (0,0) and ending at (2,2) is the largest submatrix surrounded by X.
 *                   Therefore, size of that matrix would be 3.
 *
 *  Constraints:
 *      1 ≤ n, mat.size(), mat[i].size() ≤ 1000
 */

import java.util.Scanner;

public class Matrix_Largest_Subsquare_Surrounded_by_X {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        char[][] matrix = new char[n][n];

        System.out.println("Enter the matrix contents: [X / O]");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Side length of the largest such square submatrix: ");
        System.out.println(largestSubsquare(matrix));
    }

    /// Solution
    static int largestSubsquare(char[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];

        // number of contigous 1s till this position from left and top.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        int[] bottom = new int[n];
        int right = 0;
        int size, max = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // number of contigous 1s till this position from right and bottom.
                if (mat[i][j] == 'X') {
                    bottom[j] = (i == n - 1) ? 1 : bottom[j] + 1;
                    right = (j == n - 1) ? 1 : right + 1;
                } else {
                    bottom[j] = 0;
                    right = 0;
                }

                // calculating square with boundary X
                size = Math.min(right, bottom[j]);

                for (int x = size - 1; x >= max; x--) {
                    int i1 = i + x;
                    int j1 = j + x;

                    if (left[i1][j1] > x && top[i1][j1] > x) {
                        max = Math.max(max, i1 - i + 1);
                        break;
                    }
                }
            }
        }

        return max;
    }
}
