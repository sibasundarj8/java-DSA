package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
 *
 * # Matrix Chain Multiplication
 *
 *   Q. Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix
 *      has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices
 *      together. The efficient way is the one that involves the least number of multiplications.
 *    Ex.
 *      Input : arr[] = [2, 1, 3, 4]
 *      Output: 20
 *      Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let these 3 input matrices
 *                   be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)),
 *                   note that the result of (M1 x M2) is a 2 x 3 matrix and the result of (M2 x M3) is a 1 x 4
 *                   matrix.
 *                   ((M1 x M2) x M3) requires (2 x 1 x 3) + (2 x 3 x 4) = 30
 *                   (M1 x (M2 x M3)) requires (1 x 3 x 4) + (2 x 1 x 4) = 20.
 *                   The minimum of these two is 20.
 */
import java.util.Scanner;

public class GFG_130_Matrix_Chain_Multiplication {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");
        int n = s.length;

        int[]arr = new int[n];
        for (int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println(matrixMultiplication(arr));
    }

    /// Solution
/*********************************************************[Recursive*Solution]**********************************************************************************************/
/// Recursive Top-Down approach with dp[n][n].
/// TC: O(n³), SC: O(n²) + O(n³)(recursive call stack)
    /*static int matrixMultiplication(int...arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int[]i : dp)
            Arrays.fill(i,-1);

        return solve(arr, 1, arr.length-1, dp);
    }
    private static int solve(int[]arr, int i, int j, int[][]dp){
        // base Case
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = (int) 1e9;
        for (int k = i;k < j;k++){
            int first = solve(arr, i, k, dp);
            int second = solve(arr, k+1, j, dp);
            int step = arr[i-1] * arr[k] * arr[j] + first + second;
            if (step < mini) mini = step;
        }

        return dp[i][j] = mini;
    }*/

/**********************************************************[Tabulation*Mrthod]**************************************************************************************************/
/// Tabulation bottom-up approach with dp[n][n]
/// TC: O(n³), SC: O(n²)
    static int matrixMultiplication(int...arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = n-1;i >= 1;i--){
            for (int j = i+1;j < n;j++){
                int mini = (int) 1e9;
                for (int k = i;k < j;k++){
                    int first = dp[i][k];
                    int second = dp[k+1][j];
                    int step = arr[i-1] * arr[k] * arr[j] + first + second;
                    if (step < mini) mini = step;
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][n-1];
    }
}
