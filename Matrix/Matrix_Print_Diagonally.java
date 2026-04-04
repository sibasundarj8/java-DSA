package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/print-diagonally4331/1
 *
 * # Print Diagonally
 *
 *   Q. Give an n * n square matrix mat[][], return all the elements of its anti-diagonals from top to bottom.
 *    Ex.
 *      Input : n = 3
 *              mat[][] = [[1, 2, 3],
 *                         [4, 5, 6],
 *                         [7, 8, 9]]
 *      Output: [1, 2, 4, 3, 5, 7, 6, 8, 9]
 *      Explanation:
 *                   (1) (2) (3)
 *                  ↙   ↙   ↙
 *                   (4) (5) (6)
 *                  ↙   ↙   ↙
 *                   (7) (8) (9)
 *                  ↙   ↙   ↙
 *  Constraints:
 *          1 ≤ n ≤ 10³
 *          0 ≤ mat[i][j] ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix_Print_Diagonally {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of squire matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Anti-diagonals: ");
        System.out.println(diagonalView(mat));
    }

    /// Solution
    static ArrayList<Integer> diagonalView(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

        int startI = 0;
        int startJ = 0;

        while (startI < n) {
            int i = startI;
            int j = startJ;

            while (0 <= i && i < n && 0 <= j && j < n) {
                result.add(mat[i++][j--]);
            }

            if (startJ == n - 1) startI++;
            else startJ++;
        }

        return result;
    }
}
