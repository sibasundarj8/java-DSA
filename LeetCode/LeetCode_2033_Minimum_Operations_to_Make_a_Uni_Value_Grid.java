package LeetCode;/*
 * 
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 *
 * # 2033. Minimum Operations to Make a Uni-Value Grid
 *
 *   Q. You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add
 *      x to or subtract x from any element in the grid.
 *
 *      A uni-value grid is a grid where all the elements of it are equal.
 *
 *      Return the minimum number of operations to make the grid uni-value. If it is not possible,
 *      return -1.
 *   Ex.
 *      Input: grid = [[2,4],[6,8]], x = 2
 *      Output: 4
 *      Explanation: We can make every element equal to 4 by doing the following:
 *                  - Add x to 2 once.
 *                  - Subtract x from 6 once.
 *                  - Subtract x from 8 twice.
 *                  A total of 4 operations were used.
 */
import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter Dimensions: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] grid = new int[x][y];

        System.out.println("Elements: ");
        for (int i = 0;i < x;i++)
            for (int j = 0;j < y;j++)
                grid[i][j] = sc.nextInt();

        System.out.println("x: ");
        int n = sc.nextInt();

        System.out.println(minOperations(grid, n));
    }

    /// Solution
    static int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[]arr = new int[n*m];

        int k = 0, check = grid[0][0] % x;
        for (int[] i : grid) {
            for (int j : i) {
                arr[k++] = j;
                if (j % x != check)
                    return -1;
            }
        }
        Arrays.sort(arr);

        int mid = (n*m)/2, ans = 0;
        for (int i = 0;i < m*n;i++)
            ans += Math.abs(arr[i] - arr[mid])/x;

        return ans;
    }
}
