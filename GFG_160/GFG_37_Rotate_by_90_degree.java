package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
 *
 * # Rotate by 90 degree
 *
 *   Q. Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an
 *      anti-clockwise direction without using any extra space.
 *    Ex.
 *      Input : mat[][] = [[1, 2, 3],
 *                         [4, 5, 6],
 *                         [7, 8, 9]]
 *      Output: Rotated Matrix:
 *                              [3, 6, 9]
 *                              [2, 5, 8]
 *                              [1, 4, 7]
 */
import java.util.Scanner;
 
public class GFG_37_Rotate_by_90_degree {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][]arr = new int[n][m];

        System.out.println("Enter Elements: ");
        for (int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        rotateby90(arr);

        for (int[]i : arr){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /// Solution
    static void rotateby90(int[][]mat) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;
        // reverse columns
        for (int[]i : mat) swapArray(i, c-1);
        // transpose
        for (int i = 0; i < r; i++){
            for (int j = 0; j < i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    static void swapArray(int[]arr, int n){
        int i = 0, j = n;
        while (i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
