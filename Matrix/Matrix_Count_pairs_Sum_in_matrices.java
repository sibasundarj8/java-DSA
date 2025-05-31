package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1
 *
 * # Count pairs Sum in matrices
 *
 *   Q. Given two matrices mat1[][] and mat2[][] of size n x n, where the elements in each matrix are arranged
 *      in strictly ascending order. Specifically, each row is sorted from left to right, and the last element
 *      of a row is smaller than the first element of the next row.
 *
 *      You're given a target value x, your task is to find and count all pairs {a, b} such that 'a' is from
 *      mat1 and 'b' is from mat2 where the sum of a + b is equal to x.
 *   Ex.
 *      Input : n = 3, x = 21,
 *              mat1[][] = [[ 1,  5,  6],
 *                          [ 8, 10, 11],
 *                          [15, 16, 18]],
 *              mat2[][] = [[ 2,  4,  7],
 *                          [ 9, 10, 12],
 *                          [13, 16, 20]]
 *      Output: 4
 *      Explanation: The pairs whose sum is found to be 21 are (1, 20), (5, 16), (8, 13) and (11, 10).
 */

public class Matrix_Count_pairs_Sum_in_matrices {

    /// main Method
    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 5, 6},
                {8, 10, 11},
                {15, 16, 18}
        };
        int[][] mat2 = {
                {2, 4, 7},
                {9, 10, 12},
                {13, 16, 20}
        };

        int x = 21;

        System.out.println("Number of pairs with sum " + x + " : " + countPairs(mat1, mat2, x));
    }

    /// Solution
    static int countPairs(int[][] mat1, int[][] mat2, int x) {
        // potd.code.hub
        int n = mat1.length, count = 0;

        int i1, i2, j1, j2;
        i1 = j1 = 0;
        i2 = j2 = n - 1;

        while (i1 < n && i2 >= 0) {
            int sum = mat1[i1][j1] + mat2[i2][j2];
            if (sum == x) count++;

            if (sum >= x) {
                j2--;
                if (j2 == -1) {
                    j2 = n - 1;
                    i2--;
                }
            } else {
                j1++;
                if (j1 == n) {
                    j1 = 0;
                    i1++;
                }
            }
        }

        return count;
    }
}
