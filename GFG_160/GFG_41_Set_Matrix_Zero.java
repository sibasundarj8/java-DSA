package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1
 *
 * # Set Matrix Zeroes
 *
 *   Q. You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if
 *      mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in
 *      constant space complexity.
 *    Ex.
 *      Input : mat[][] = [[1, -1, 1],
 *                         [-1, 0, 1],
 *                         [1, -1, 1]]
 *      Output: [[1, 0, 1],
 *               [0, 0, 0],
 *               [1, 0, 1]]
 * Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.
 */
import java.util.Scanner;

public class GFG_41_Set_Matrix_Zeroes {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimension: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]mat = new int[r][c];

        System.out.println("Elements: ");
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        setMatrixZeroes(mat);

        for (int[]i : mat){
            for (int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean t = false, l = false;

        // Marking Zeros at top row and left column
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (mat[i][j] == 0){
                    if (i == 0 || j == 0) {
                        if (i == 0) t = true;
                        if (j == 0) l = true;
                    }
                    else {
                        mat[i][0] = 0;
                        mat[0][j] = 0;
                    }
                }
            }
        }

        // Setting rows to 0
        for (int i = 1; i < r;i++)
            for (int j = 1; j < c; j++)
                if (mat[0][j] == 0 || mat[i][0] == 0)
                    mat[i][j] = 0;

        // checking for 0th row and column
        if (t || l){
            int i = 0;
            while (i < r || i < c){
                if (i < r && l) mat[i][0] = 0;
                if (i < c && t) mat[0][i] = 0;
                i++;
            }
        }
    }
}
