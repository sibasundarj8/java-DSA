package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1
 *
 * # Kth element in Matrix
 *
 *   Q. Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the
 *      kth smallest element in the matrix.
 *    Ex.
 *      Input : n = 4
 *              mat[][] = [[10, 20, 30, 40],
 *                         [15, 25, 35, 45],
 *                         [24, 29, 37, 48],
 *                         [32, 33, 39, 50]]
 *              k = 7
 *      Output: 30
 *      Explanation: 30 is the 7th smallest element.
 */

public class Matrix_Kth_element_in_Matrix {

    /// main Method
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int k = 7;

        System.out.println("Kth element: " + kthSmallest(mat, k));
    }

    /// Solution
    static int kthSmallest(int[][] matrix, int k) {
        // potd.code.hub
        int n = matrix.length;
        int ans = 0;

        int i = matrix[0][0];
        int j = matrix[n - 1][n - 1];

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int count = count(matrix, mid);

            if (count >= k) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

    private static int count(int[][] mat, int k) {
        int n = mat.length;
        int r = 0, c = n - 1, count = 0;

        while (r < n && c >= 0) {
            if (mat[r][c] <= k) {
                count += c + 1;
                r++;
            } else c--;
        }

        return count;
    }
}
