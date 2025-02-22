package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1
 *
 * # Largest rectangular sub-matrix whose sum is 0
 *
 *   Q. Given a matrix mat[][]. Find the size of the largest sub-matrix whose sum is equal to zero.
 *      The size of a matrix is the product of rows and columns. A sub-matrix is a matrix obtained
 *      from the given matrix by deletion of several (possibly, zero or all) rows/columns from the
 *      beginning and several (possibly, zero or all) rows/columns from the end.
 *    Ex.
 *      Input: mat[][] = [[9,  7, 16,  5],
 *                        [1, -6, -7,  3],
 *                        [1,  8,  7,  9],
 *                        [7, -2,  0, 10]]
 *      Output: 6
 *      Explanation:      [9,   7,  16,   5],
 *                            |---------|
 *                        [1, |-6,  -7, | 3],
 *                            |         |
 *                        [1, | 8,   7, | 9],
 *                            |         |
 *                        [7, |-2,   0, |10]
 *                            |---------|
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PrefixSum_03_Largest_rectangular_sub_matrix_whose_sum_is_0 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("dimension: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Elements: ");
        for (int i = 0;i < r;i++)
            for (int j = 0;j < c;j++)
                mat[i][j] = sc.nextInt();

        System.out.println(zeroSumSubmat(mat));
    }

    /// Solution
    static int zeroSumSubmat(int[][] mat) {
        // potd.code.hub
        int r = mat.length, c = mat[0].length;
        int[]rectangle = new int[r];
        int ans = 0;

        for (int i = 0;i < c;i++){
            for (int j = i;j < c;j++){
                for (int k = 0;k < r;k++)
                    rectangle[k] += mat[k][j];
                ans = Math.max(ans, zeroSum(rectangle, i, j));
            }
            Arrays.fill(rectangle, 0);
        }

        return ans;
    }
    private static int zeroSum(int[]temp, int l, int r){
        int n = temp.length, sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0;i < n;i++){
            sum += temp[i];
            ans = Math.max(ans, i - map.getOrDefault(sum, i));
            map.putIfAbsent(sum, i);
        }
        return ans * (r-l+1);
    }
}
