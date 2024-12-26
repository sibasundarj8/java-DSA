package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/create-a-spiral-matrix-of-nm-size-from-given-array/0
 *
 * # Create a spiral matrix of N*M size from given array
 *
 *   Q. You are given two positive integers n and m, and an integer array arr[] containing total (n*m) elements.
 *      Return a 2D matrix of dimensions n x m by filling it in a clockwise spiral order using the elements from
 *      the given array.
 *    Ex.
 *      Input : n = 3
 *              m = 4
 *              arr[] =[1, 8, 6, 3, 8, 6, 1, 6, 3, 2, 5, 3]
 *      Output: [[1, 8, 6, 3],
 *               [2, 5, 3, 8],
 *               [3, 6, 1, 6]]
 */
import java.util.Scanner;

public class Matrix_02_Create_a_spiral_matrix_of_NxM_size_from_given_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Number of Rows: ");
        n = sc.nextInt();

        System.out.println("Number of Columns: ");
        int m = sc.nextInt();


        for (int[] i : spiralFill(n, m, arr)){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static int[][] spiralFill(int n, int m, int[] arr) {
        // potd.code.hub
        int[][]mat = new int[n][m];
        int tr = 0, br = n-1, lc = 0, rc = m-1, x = 0;
        while (tr <= br && lc <= rc){
            // top row
            for (int i = lc; i <= rc; i++) mat[tr][i] = arr[x++];
            tr++;
            // right column
            for (int i = tr; i <= br; i++) mat[i][rc] = arr[x++];
            rc--;
            // bottom row
            if (tr <= br)
                for (int i = rc; i >= lc; i--) mat[br][i] = arr[x++];          
            br--;
            // left column
            if (lc <= rc)
                for (int i = br; i >= tr; i--) mat[i][lc] = arr[x++];            
            lc++;
        }

        return mat;
    }
}
