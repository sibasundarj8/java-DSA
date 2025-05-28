package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1
 *
 * # Optimal binary search tree
 *
 *   Q. Given a sorted array keys[0... n-1] of search keys and an array freq[0... n-1] of frequency counts, where
 *      freq[i] is the number of searches to keys[i]. Construct a binary search tree of all keys such that the
 *      total cost of all the searches is as small as possible.
 *
 *      Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its
 *      frequency. Level of root is 1.
 *
 *    Ex.
 *      Input : N = 3
 *              keys = {10, 12, 20}
 *              freq = {34, 8, 50}
 *      Output: 142
 *      Explanation: There can be many possible BSTs
 *                   20
 *                  /
 *                 10
 *                  \
 *                   12
 *
 *              Among all possible BSTs,
 *              cost of this BST is minimum.
 *              Cost of this BST is 1*50 + 2*34 + 3*8 = 142
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Optimal_binary_search_tree {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter keys must be in sorted order: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] keys = new int[n];
        int[] freq = new int[n];


        for (int i = 0;i < n;i++){
            keys[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter frequencies: ");
        for (int i = 0;i < n;i++){
            freq[i] = sc.nextByte();
        }

        System.out.println("Optimal cost: " + tab(keys, freq, n));
    }

    /// Solution

/****************************************************<-Memoization->****************************************************/
    static int memo(int[] keys, int[] freq, int n) {
        // potd.code.hub
        int[][] dp = new int[n+1][n+1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return solve(freq, 1, n, dp);
    }

    private static int solve(int[] freq, int i, int j, int[][] dp) {
        // base case
        if (j < i) return 0;
        if (i == j) return freq[i-1];
        if (dp[i][j] != -1) return dp[i][j];

        // self work | recursive work
        int sum = sum(freq, i-1, j-1);
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int cost = solve(freq, i, k - 1, dp) + solve(freq, k + 1, j, dp) + sum;
            if (cost < ans) {
                ans = cost;
            }
        }

        return dp[i][j] = ans;
    }

    private static int sum(int[] freq, int i, int j) {
        int s = 0;
        while (i <= j) {
            s += freq[i++];
        }
        return s;
    }

/*****************************************************<-Tabulation->****************************************************/
    static int tab(int[] keys, int[] freq, int n) {
        // potd.code.hub
        int[][] dp = new int[n+2][n+2];

        for (int i = n;i > 0;i--){
            for (int j = 1;j <= n;j++){
                if (i <= j){
                    if (i == j) dp[i][j] = freq[i-1];
                    else {
                        int sum = sum(freq, i - 1, j - 1);
                        int ans = Integer.MAX_VALUE;

                        for (int k = i; k <= j; k++) {
                            int cost = dp[i][k - 1] + dp[k + 1][j] + sum;
                            if (cost < ans) {
                                ans = cost;
                            }
                        }

                        dp[i][j] = ans;
                    }
                }
            }
        }

        return dp[1][n];
    }
}
