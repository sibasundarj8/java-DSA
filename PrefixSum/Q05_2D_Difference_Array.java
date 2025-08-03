package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/2-d-difference-array/1
 *
 * # 2D Difference Array
 *
 *   Q. You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation
 *      is represented as an array [v, r1, c1, r2, c2], where:
 *       ▸  v is the value to be added
 *       ▸  (r1, c1) is the top-left cell of a submatrix
 *       ▸  (r2, c2) is the bottom-right cell of the submatrix (inclusive)
 *       ▸  For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2).
 *          Return the final matrix after applying all operations.
 */
    
import java.util.ArrayList;
import java.util.Scanner;

public class Q05_2D_Difference_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions: ");
        int r = sc.nextByte();
        int c = sc.nextByte();

        int[][] mat = new int[r][c];

        System.out.println("Enter elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Number of operations: ");
        int n = sc.nextInt();

        int[][] opr = new int[n][5];

        System.out.println("Enter operations: (val, dimension of top-left, dimension of bottom-right)");
        for (int i = 0; i < n; i++) {
            opr[i][0] = sc.nextInt();
            opr[i][1] = sc.nextInt();
            opr[i][2] = sc.nextInt();
            opr[i][3] = sc.nextInt();
            opr[i][4] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> ans = applyDiff2D(mat, opr);

        System.out.println("Matrix apter performing operations: ");
        for (ArrayList<Integer> x : ans) {
            System.out.println(x);
        }
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // potd.code.hub
        int r = mat.length;     // number of rows
        int c = mat[0].length;  // number of cols
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // difference array
        int[][] demo = new int[r + 1][c + 1];

        // performing operations on difference matrix
        for (int[] op : opr) {
            int val = op[0];    // value going to be added

            int r1 = op[1];     // dimension of top-left element
            int c1 = op[2];

            int r2 = op[3];     // dimension of bottom-right element
            int c2 = op[4];

            demo[r1][c1] += val;        //    ((+)ele)-----ele (-)
            demo[r1][c2 + 1] -= val;    //         |        |
            demo[r2 + 1][c1] -= val;    //        ele------ele
            demo[r2 + 1][c2 + 1] += val;//        (-)          (+)
        }

        // prefix-sum on rows
        for (int i = 0; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                demo[i][j] += demo[i][j - 1];
            }
        }

        // prefix-sum on cols
        for (int i = 1; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                demo[i][j] += demo[i - 1][j];
            }
        }

        // updating answer
        for (int i = 0; i < r; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < c; j++)
                list.add(mat[i][j] + demo[i][j]);

            ans.add(list);
        }

        return ans;
    }
}
