package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/search-in-a-row-wise-sorted-matrix/1
 *
 * # Search in a row-wise sorted matrix
 *
 *   Q. Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element
 *      x is present in the matrix.
 *
 *      Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds,
 *            mat[i][j] <= mat[i][j+1].
 *    Ex.
 *      Input : mat[][] = [[3,  4,  9],
 *                         [2,  5,  6],
 *                         [9, 25, 27]]
 *              x = 9
 *      Output: true
 *      Explanation: 9 is present in the matrix, so the output is true.
 */
import java.util.Scanner;

public class GFG_39_Search_in_a_row_wise_sorted_matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]mat = new int[r][c];

        System.out.println("Elements: ");
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Target: ");
        int x = sc.nextInt();

        System.out.println(searchRowMatrix(mat, x));
    }

    /// Solution
    static boolean searchRowMatrix(int[][] mat, int x) {
        // potd.code.hub
        int c = mat[0].length;
        for (int[]i : mat){
            if (i[0] <= x && x <= i[c-1])
                if (binarySearch(i, c, x)) return true;
        }

        return false;
    }
    private static boolean binarySearch(int[]arr, int n, int target){
        int i = 0, j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) j = mid-1;
            else i = mid+1;
        }
        return false;
    }
}
