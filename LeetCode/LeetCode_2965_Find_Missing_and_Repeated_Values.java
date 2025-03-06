package LeetCode;/*
 *
 * https://leetcode.com/problems/find-missing-and-repeated-values/
 *
 * #2965. Find Missing and Repeated Values
 *
 *   Q. You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range
 *      [1, n2]. Each integer appears exactly once except X which appears twice, and Y which is
 *      missing. The task is to find the repeating and missing numbers a and b.
 *
 *          Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1]
 *          equals to b.
 *    Ex.
 *      Input : grid = [[9, 1, 7],
 *                      [8, 9, 2],
 *                      [3, 4, 6]]
 *      Output: [9,5]
 *      Explanation: Number 9 is repeated and number 5 is missing, so the answer is [9,5].
 */
import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2965_Find_Missing_and_Repeated_Values {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            for (int j = 0;j < n;j++)
                mat[i][j] = sc.nextInt();

        String ans = Arrays.toString(findMissingAndRepeatedValues(mat));
        System.out.println(ans);
    }

    /// Solution
    static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long num = (long)n*n;

        long natSum = num * (num+1) / 2;         // sum of all natural numbers up-to n².
        long eleSum = 0;                         // sum of all elements present in matrix.

        long natSum2 = num*(num+1)*(2*num+1)/6;  // sum of all natural (numbers)² up-to n².
        long eleSum2 = 0;                        // sum of all (elements)² present in matrix.

        for (int[] i : grid)
            for (int j : i) {
                eleSum += j;
                eleSum2 += (long) j *j;
            }

        long v1 = eleSum - natSum;               // x - y
        long v2 = (eleSum2-natSum2) / v1;        // x + y

        v1 = (v1+v2) / 2;                        // x -> repeating
        v2 -= v1;                                // y -> missing

        return new int[]{(int)v1, (int)v2};
    }
}
