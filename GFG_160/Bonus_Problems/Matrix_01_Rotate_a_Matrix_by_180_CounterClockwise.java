package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/c-matrix-rotation-by-180-degree0745/1
 *
 * # Rotate a Matrix by 180 Counterclockwise
 *
 *   Q. Given a 2D square matrix mat[][] of size n x n, turn it by 180 degrees without using extra space.
 *
 *      Note: You must rotate the matrix in place and modify the input matrix directly.
 *    Ex.
 *      Input : mat[][] = [[ 1,  2,  3,  4],
 *                         [ 5,  6,  7,  8],
 *                         [ 9, 10, 11, 12],
 *                         [13, 14, 15, 16]]
 *      Output: [[16, 15, 14, 13],
 *               [12, 11, 10,  9],
 *               [ 8,  7,  6,  5],
 *               [ 4,  3,  2,  1]]
 */
import java.util.Scanner;

public class Matrix_01_Rotate_a_Matrix_by_180_CounterClockwise {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimension: ");
        int n = sc.nextInt();

        int[][]mat = new int[n][n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        rotateMatrix(mat);

        for (int[] i : mat){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static void rotateMatrix(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
      
        // rotate 180⁰
        for (int i = 0; i < n; i++){
            int m = i < (n+1)/2 ? n-i : n-i-1;
            for (int j = 0; j < m; j++){
                int i1 = n-i-1;
                int j1 = n-j-1;
                int temp = mat[i][j];
                mat[i][j] = mat[i1][j1];
                mat[i1][j1] = temp;
            }
        }
    }
}
