package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-peak-element-in-a-2d-matrix/1
 *
 * # Find the Peak Element in a 2D Matrix
 *
 *   Q. Given a 2D matrix mat[][], identify any peak element within the matrix.
 *
 *      An element is considered a peak if it is greater than or equal to its four immediate neighbors: top, bottom, left,
 *      and right. For corner and edge elements, any missing neighbors are treated as having a value of negative infinity.
 *
 *      Note: A peak element is not necessarily the global maximum, it only needs to satisfy the condition relative to its
 *            adjacent elements. Multiple peak elements may exist, return any one of them.
 *    Ex.
 *      Input : mat[][] = [[10, 20, 15],
 *                        [21, 30, 14],
 *                        [ 7, 16, 32]]
 *      Output: true
 *      Explanation: One of the peak element is 30 at index (1, 1), which is greater than or equal to all its valid neighbors:
 *                     Left = 21,
 *                     Right = 14,
 *                     Top = 20,
 *                     Bottom = 16.
 *                   So, it satisfies the peak condition. Alternatively, (2, 2) with value 32 also qualifies as a peak.
 *
 *  Constraint:
 *          1 ≤ n × m ≤ 10⁶
 *          -10⁶ ≤ mat[i][j] ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Searching_Find_the_Peak_Element_in_a_2D_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Position of peak element: " + findPeakGrid(mat));
    }

    /// Solution
    static ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();

        outer:
        for(int r = 0; r < n; r++) {
            int i = 0, j = m-1;

            while(i <= j) {
                int mid = i + (j - i) / 2;

                if(isPeak(mat, r, mid, n, m)) {
                    list.add(r);
                    list.add(mid);
                    break outer;
                }
                
                if(mid < m - 1 && mat[r][mid] <= mat[r][mid+1]) i = mid + 1;
                else j = mid - 1;
            }
        }

        return list;
    }

    private static boolean isPeak(int[][] mat, int r, int c, int n, int m) {
        int[] xRow = {0, -1, 0, 1};
        int[] xCol = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++) {
            int nr = xRow[i] + r;
            int nc = xCol[i] + c;

            int val = (0 <= nr && nr < n && 0 <= nc && nc < m) ? mat[nr][nc] : Integer.MIN_VALUE;

            if(val > mat[r][c]) return false;
        }

        return true;
    }
}
