package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 *
 * # Spirally traversing a matrix
 *
 *   Q. You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while
 *      traversing the matrix in spiral form.
 *    Ex.
 *      Input : mat[][] = [[1,  2,  3,  4],
 *                         [5,  6,  7,  8],
 *                         [9, 10, 11, 12],
 *                         [13,14, 15, 16]]
 *      Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 *      Explanation: 1  →  2  → 3 → 4
 *                                  ↓
 *                   5  → 6 →  7    8
 *                   ↑         ↓    ↓
 *                   9    10 ← 11   12
 *                   ↑              ↓
 *                   13 ← 14 ← 15 ← 16
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GFG_36_Spirally_traversing_a_matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter Dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][]mat = new int[n][m];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(spirallyTraverse(mat));
    }

    /// Solution
    static ArrayList<Integer> spirallyTraverse(int[][]mat) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int tr = 0, br = r-1, lc = 0, rc = c-1;
        while (tr <= br && lc <= rc){
            // top row
            for (int i = lc; i <= rc; i++) ans.add(mat[tr][i]);
            tr++;
            // right column
            for (int i = tr; i <= br; i++) ans.add(mat[i][rc]);
            rc--;
            // bottom row
            if (tr <= br){
                for (int i = rc; i >= lc; i--) ans.add(mat[br][i]);
            }
            br--;
            // left column
            if (lc <= rc){
                for (int i = br; i >= tr; i--) ans.add(mat[i][lc]);
            }
            lc++;
        }

        return ans;
    }
}
