package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
 *
 * # Search in a Row-Column sorted matrix
 *
 *   Q. Given a 2D integer matrix mat[][] of size n × m, where every row and column is sorted in
 *      increasing order and a number x, the task is to find whether element x is present in the
 *      matrix.
 *    Ex.Input : mat[][] = [[ 3, 30, 38]
 *                          [20, 52, 54]
 *                          [35, 60, 69]]
 *               x = 62
 *       Output: false
 *       Explanation: 62 is not present in the matrix, so output is false.
 */
import java.util.Scanner;
 
public class GFG_38_Search_in_a_Row_Column_sorted_matrix {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]mat = new int[r][c];

        System.out.println("Elements: ");
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("The number which you want to search: ");
        int target = sc.nextInt();

        System.out.println(matSearch(mat, target));
    }

    /// Solution
    static boolean matSearch(int[][]mat, int x) {
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
