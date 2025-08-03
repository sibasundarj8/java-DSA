package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1
 *
 * # Maximum sum Rectangle
 *
 *   Q. Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the
 *      given matrix.
 *    Ex.
 *      Input : mat[][] = [[ 1,  2, -1, -4, -20],
 *                         [-8, -3,  4,  2,  1],
 *                         [ 3,  8, 10,  1,  3],
 *                         [-4, -1,  1,  7, -6]]
 *      Output: 29
 *      Explanation: The matrix is as follows and the green rectangle denotes the maximum sum rectangle which is
 *                   equal to 29.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q06_Maximum_sum_Rectangle {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions: ");
        int r = sc.nextByte();
        int c = sc.nextByte();

        int[][] mat = new int[r][c];

        System.out.println("Enter Elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Max rectangle sum: " + maxRectSum(mat));
    }

    /// Solution
/*------------------------------------------------------Brute-Force------------------------------------------------------*/
    static int bruteForce(int[][] mat) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int i1 = i; i1 < r; i1++) {
                    for (int j1 = j; j1 < c; j1++) {
                        int sum = 0;
                        for (int x = i; x <= i1; x++) {
                            for (int y = j; y <= j1; y++) {
                                sum += mat[x][y];
                            }
                        }
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }

        return ans;
    }

/*--------------------------------------------------Kadane's-Algorithm--------------------------------------------------*/
    static int maxRectSum(int[][] mat) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;
        int ans = Integer.MIN_VALUE;

        int[] col = new int[r];

        for (int i = 0; i < c; i++) {
            Arrays.fill(col, 0);
            for (int j = i; j < c; j++) {
                for (int x = 0; x < r; x++) {
                    col[x] += mat[x][j];
                }
                int sum = kadaneAlgo(col);
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    private static int kadaneAlgo(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int x : arr) {
            sum += x;
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0;
        }

        return ans;
    }
}
