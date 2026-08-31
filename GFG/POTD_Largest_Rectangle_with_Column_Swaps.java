package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed0243/1
 *
 * # Largest Rectangle with Column Swaps
 *
 *   Q. Given a binary matrix mat[][] of size n × m containing only 0s and 1s, any pair of columns may be swapped
 *      any number of times. Return the maximum area of a rectangle consisting entirely of 1's that can be formed
 *      after performing the column swaps.
 *
 *    Ex.
 *      Input : mat[][] = [[0, 1, 1, 0, 0],
 *                         [1, 1, 1, 0, 1],
 *                         [1, 1, 1, 0, 1],
 *                         [1, 1, 1, 1, 1]]
 *      Output: 12
 *      Explanation: After swapping the 4th and 5th columns, the largest rectangle of 1s has an area of 12.
 *
 *  Constraints:
 *        ◦ 1 ≤ n, m ≤ 10³
 *        ◦ 0 ≤ mat[i][j] ≤ 1
 *        ◦ mat.rows = n
 *        ◦ mat.cols = m
 */

import java.util.Scanner;

public class POTD_Largest_Rectangle_with_Column_Swaps {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: [0 or 1]");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
                if (mat[i][j] != 0 && mat[i][j] != 1) {
                    throw new IllegalArgumentException("Elements must be 0 or 1");
                }
            }
        }

        System.out.println("Size of largest rectangle after column swap: ");
        System.out.println(maxArea(mat));
    }

    /// Solution
    static int maxArea(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int res = maxRectangle(mat[0], n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }

            res = Math.max(res, maxRectangle(mat[i], n));
        }

        return res;
    }

    private static int maxRectangle(int[] heights, int maxHeight) {
        int res = 0;

        // instead of sorting I am using a frequency array of size number of rows. (reduces time N.logN to N)
        int[] freq = new int[maxHeight + 1];

        for (int ele : heights) {
            freq[ele]++;
        }

        int size = 0;

        for (int i = maxHeight; i >= 0; i--) {
            if (freq[i] == 0) continue;
            size += freq[i];
            res = Math.max(res, size * i);
        }

        return res;
    }
}
