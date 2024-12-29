package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/generate-a-matrix-with-each-row-and-column-of-given-sum/0
 *
 * # Generate a matrix with each row and column of given sum
 *
 *   Q. Given two integer arrays rowSum[] of size n and colSum[] of size m, the task is to construct a
 *      2D matrix of size n x m such that the sum of matrix elements in ith row is rowSum[i] and the sum
 *      of matrix elements in jth column is colSum[j].
 *
 *    Note: Since multiple answers are possible, return any one of them.
 *          Arrays are generated such that answer is always possible.
 *          The driver code will print true if output matrix is correct, otherwise it will print false.
 *    Ex.
 *      Input : rowSum[] = [5, 7, 10]
 *              colSum[] = [8, 6, 8]
 *      Output: true
 *      Explanation: For the matrix [[0, 5, 0],
 *                                   [6, 1, 0],
 *                                   [2, 0, 8]]
 *                 We have row 1 with sum equal to 5 and column 1 has sum equal to 8.Row 2 has sum equal
 *                 to 7 and column 2 has sum equal to 6.Row 3 has sum equal to 10 and column 3 has sum
 *                 equal to 8.
 */
import java.util.Scanner;
 
public class Matrix_03_Generate_a_matrix_with_each_row_and_column_of_given_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]rowSum = new int[n];

        System.out.println("Elements of rowSum[]: ");
        for (int i = 0;i < n;i++) rowSum[i] = sc.nextInt();

        System.out.println("Size: ");
        n = sc.nextInt();

        int[]colSum = new int[n];

        System.out.println("Elements of colSum[]: ");
        for (int i = 0;i < n;i++) colSum[i] = sc.nextInt();

        for (int []i : generateMatrix(rowSum, colSum)){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static int[][] generateMatrix(int[] rowSum, int[] colSum) {
        // potd.code.hub
        int r = rowSum.length;
        int c = colSum.length;
        int [][]ans = new int[r][c];

        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                int ele = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ele;
                colSum[j] -= ele;
                ans[i][j] = ele;
            }
        }

        return ans;
    }
}
