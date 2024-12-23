package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1
 *
 * # Search in a sorted Matrix
 *
 *   Q. Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number
 *      x is present in the matrix or not.
 *
 *      Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the
 *            first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.
 *    Ex.
 *      Input : mat[][] = [[ 1,  5,  9],
 *                         [14, 20, 21],
 *                         [30, 34, 43]],
 *              x = 14
 *      Output: true
 *      Explanation: 14 is present in the matrix, so output is true.
 */
import java.util.Scanner;

public class GFG_40_Search_in_a_sorted_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        int[][]mat = new int[r][c];

        System.out.println("Elements must be strictly sorted row wise also column wise");
        System.out.println("Enter elements: ");
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Target: ");
        int x = sc.nextInt();
        
        System.out.println(searchMatrix(mat, x));
    }

    // Solution
    static boolean searchMatrix(int[][] mat, int x) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;

        int i = 0, j = c-1;
        while (i < r && j >= 0){
            if (mat[i][j] == x) return true;
            else if (x < mat[i][j]) j--;
            else i++;
        }

        return false;
    }
}
