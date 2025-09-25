package LeetCode;/*
 *
 * https://leetcode.com/problems/triangle/
 *
 * # 120. Triangle
 *
 *   Q. Given a triangle array, return the minimum path sum from top to bottom.
 *
 *      For each step, you may move to an adjacent number of the row below. More formally, if you are on
 *      index i on the current row, you may move to either index i or index i + 1 on the next row.
 *    Ex.
 *      Input : triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 *      Output: 11
 *      Explanation: The triangle looks like:
 *             2
 *            3 4
 *           6 5 7
 *          4 1 8 3
 *          The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 *   Constraints:
 *        1 <= triangle.length <= 200
 *        triangle[0].length == 1
 *        triangle[i].length == triangle[i - 1].length + 1
 *        -10⁴ <= triangle[i][j] <= 10⁴
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_120_Triangle {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> triangle = new LinkedList<>();

        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.println("Enter elements: ");

        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new LinkedList<>();

            for (int j = 0; j < i; j++)
                temp.add(sc.nextInt());

            triangle.add(temp);
        }

        System.out.println("minimum cost: " + minimumTotal(triangle));
    }

    /// Solution
/*......................................................Brute-force......................................................*/
    static int bruteForce(List<List<Integer>> triangle) {
        return bf(triangle, 0, 0, triangle.size());
    }

    private static int bf(List<List<Integer>> triangle, int i, int j, int n) {
        if (i == n-1) return triangle.get(i).get(j);

        int left = bf(triangle, i + 1, j, n);
        int right = bf(triangle, i + 1, j + 1, n);

        return triangle.get(i).get(j) + Math.min(left, right);
    }

/*......................................................Memoization......................................................*/
    static int memoization(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][];

        for (int i = 0; i < n; i++)
            dp[i] = new Integer[i + 1];

        return minCost(triangle, 0, 0, n, dp);
    }

    private static int minCost(List<List<Integer>> triangle, int i, int j, int n, Integer[][] dp) {
        if (i == n - 1) return triangle.get(i).get(j);
        if (dp[i][j] != null) return dp[i][j];

        int left = minCost(triangle, i + 1, j, n, dp);
        int right = minCost(triangle, i + 1, j + 1, n, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
    }

/*.......................................................Tabulation......................................................*/
    static int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++)
            dp[i] = new int[i + 1];

        for (int i = 0; i < n; i++)
            dp[n - 1][i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j < i + 1; j++)
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);

        return dp[0][0];
    }

/*....................................................Space-Optimized....................................................*/
    static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j < i + 1; j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);

        return dp[0];
    }
}
