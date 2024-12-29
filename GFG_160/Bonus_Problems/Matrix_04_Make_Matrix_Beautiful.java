package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/0
 *
 * # Make Matrix Beautiful
 *
 *   Q. A beautiful matrix is a matrix in which the sum of elements in each row and column is equal.
 *      Given a square matrix mat[][]. Find the minimum number of operation(s) that are required to
 *      make the matrix beautiful. In one operation you can increment the value of any one cell by 1.
 *    Ex.
 *      Input : mat[][] = [[1, 2, 3],
 *                         [4, 2, 3],
 *                         [3, 2, 1]]
 *      Output: 6
 *      Explanation: Increment value of cell(0, 0) by 1, increment value of cell(0, 1) by 2, increment
 *                   value of cell(2, 1) by 1, increment value of cell(2, 2) by 2. Such that all rows
 *                   and columns have sum of 9.
 */
import java.util.Scanner;
   
public class Matrix_04_Make_Matrix_Beautiful {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of Square matrix: ");
        int n = sc.nextInt();

        int[][]mat = new int[n][n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(findMinOperation(mat));
    }

    /// Solution
    static int findMinOperation(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int []rowSum = new int[n];
        int []colSum = new int[n];
        int max = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                rowSum[i] += mat[i][j];
                colSum[i] += mat[j][i];
                max = Math.max(max, Math.max(rowSum[i], colSum[i]));
            }
        }
        
        int ans = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                int r = max - rowSum[i];
                int c = max - colSum[j];
                int ele = Math.min(r, c);
                rowSum[i] += ele;
                colSum[j] += ele;
                ans += ele;
            }
        }

        return ans;
    }
}
