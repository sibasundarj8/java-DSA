package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/search-in-fully-rotated-sorted-2d-matrix/1
 *
 * # Search in fully rotated sorted 2D matrix
 *
 *   Q. You are given a 2D matrix mat[][] of size n x m that was initially filled in the following manner:
 *          • Each row is sorted in increasing order from left to right.
 *          • The first element of every row is greater than the last element of the previous row.
 *
 *      This implies that if the matrix is flattened row-wise, it forms a strictly sorted 1D array.
 *      Later, this sorted 1D array was rotated at some unknown pivot. The rotated array was then written back
 *      into the matrix row-wise to form the current matrix.
 *
 *      Given such a matrix mat[][] and an integer x, determine whether x exists in the matrix.
 *   Ex.
 *      Input : x = 3,
 *              mat[][] = [[ 7,  8,  9, 10],
 *                         [11, 12, 13,  1],
 *                         [ 2,  3,  4,  5]]
 *      Output: true
 *      Explanation: 3 is located at the 3rd row and 2nd column.
 *
 *   Constraint:
 *          1 ≤ n × m ≤ 10⁵
 *          1 ≤ mat[i][j], x ≤ 10⁶
 */

import java.util.Scanner;

public class Searching_Search_in_fully_rotated_sorted_2D_matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimensions: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Enter elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Target: ");
        int x = sc.nextInt();

        System.out.println("Search result: " + searchMatrix(mat, x));
    }

    /// Solution
    static boolean searchMatrix(int[][] mat, int target) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;

        int s = 0;
        int e = n * m - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int[] sDimension = index_2D(s, m);   //  Start Dimension
            int[] eDimension = index_2D(e, m);   //  End Dimension
            int[] mDimension = index_2D(mid, m); //  Mid Dimension

            int sEle = mat[sDimension[0]][sDimension[1]];   //  start element
            int eEle = mat[eDimension[0]][eDimension[1]];   //  end element
            int mEle = mat[mDimension[0]][mDimension[1]];   //  mid element

            if (mat[mDimension[0]][mDimension[1]] == target) {
                return true;
            } else if (sEle < eEle) {
                if (target < mEle) e = mid - 1;
                else s = mid + 1;
            } else {
                if (sEle <= mEle) {
                    if (target < sEle || target > mEle) s = mid + 1;
                    else e = mid - 1;
                } else {
                    if (target > eEle || target < mEle) e = mid - 1;
                    else s = mid + 1;
                }
            }
        }

        return false;
    }

    // finds the dimension of 1D index in 2D representation
    private static int[] index_2D(int idx, int col) {
        return new int[]{idx / col, idx % col};
    }
}
