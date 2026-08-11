package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-square-in-a-binary-matrix-with-at-most-k-1s-for-multiple-queries/1
 *
 * # Largest Odd Squares with Limited 1s
 *
 *   Q. Given a binary matrix mat[][] of size n * m and an integer k, process a list of queries[][]. Each query contains
 *      coordinates [i, j] of the center of a square.
 *
 *      For every query, find the side length of the largest odd-sized square centered at cell (i, j) such that the
 *      square contains at most k ones.
 *
 *      A square centered at (i, j) expands outward symmetrically in all four directions by the same number of cells,
 *      so its side length is always odd.
 *
 *    Ex.
 *      Input : mat[][] = [[1, 1, 1],
 *                         [1, 1, 1],
 *                         [1, 1, 1]]
 *              queries[][] = [[1, 1],
 *                             [2, 2]]
 *              K = 9
 *      Output: [3, 1]
 *      Explanation: For query (1, 1), the largest valid square is the entire 3 × 3 matrix, which contains 9 ones.
 *                   Hence, the answer is 3.
 *
 *                   For query (2, 2), no expansion is possible without going outside the matrix, so only the 1 × 1
 *                   square centered at (2, 2) is valid. Hence, the answer is 1.
 *
 *  Constraints:
 *       ◦ 1 ≤ mat.size(), mat[0].size() ≤ 500
 *       ◦ 1 ≤ queries.size() ≤ 10⁴
 *       ◦ 0 ≤ queries[q][0] < mat.size()
 *       ◦ 0 ≤ queries[q][1] < mat[0].size()
 *       ◦ 0 ≤ k ≤ mat.size() * mat[0].size()
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q14_Largest_Odd_Squares_with_Limited_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter dimensions of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter elements of matrix (must be 0 or 1)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
                if (mat[i][j] != 0 && mat[i][j] != 1) {
                    throw new IllegalStateException("elements must be 0 or 1");
                }
            }
        }

        System.out.println("Number of queries: ");
        int q = sc.nextInt();
        int[][] queries = new int[q][2];

        System.out.println("Enter queries: ");
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Length of the largest odd-sized square centered at cell (i, j) for each query: ");
        System.out.println(largestSquare(mat, queries, k));
    }

    /// Solution
    static ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = mat[i][j];
                if (i > 0) prefix[i][j] += prefix[i - 1][j];
                if (j > 0) prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        int start, end, r, c;
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] query : queries) {
            r = query[0];
            c = query[1];

            // binary search
            start = 0;
            end = Math.min(Math.min(r, c), Math.min(n - r, m - c) - 1);

            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (countOnes(r, c, mid, prefix) <= k) start = mid + 1;
                else end = mid - 1;
            }

            list.add((end << 1) + 1);
        }

        return list;
    }

    private static int countOnes(int r, int c, int d, int[][] prefix) {
        int top = r - d;
        int bottom = r + d;
        int left = c - d;
        int right = c + d;
        int count = prefix[bottom][right];

        if (top > 0) count -= prefix[top - 1][right];
        if (left > 0) count -= prefix[bottom][left - 1];
        if (top > 0 && left > 0) count += prefix[top - 1][left - 1];

        return count;
    }
}
