package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
 *
 * # Stickler Thief
 *
 *   Q. Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two
 *      consecutive houses and aims to maximize his total loot. Given an array, arr[] where arr[i]
 *      represents the amount of money in the i-th house. Determine the maximum amount he can loot.
 *   Ex.
 *      Input: arr[] = [6, 5, 5, 7, 4]
 *      Output: 15
 *      Explanation: Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6 + 5 + 4 = 15.
 */
import java.util.Scanner;

public class GFG_127_Stickler_Thief {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of houses: ");
        int n = sc.nextInt();

        int[]houses = new int[n];

        System.out.println("Enter value: ");
        for (int i = 0;i < n;i++)
            houses[i] = sc.nextInt();

        System.out.println(findMaxSum(houses));
    }

    /// Solution
    static int findMaxSum(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int n1 = arr[n-1], n2 = 0, ans = 0;

        for (int idx = n-2;idx >= 0;idx--){
            ans = Math.max(n2+arr[idx], n1);
            n2 = n1;
            n1 = ans;
        }
        return ans;
    }

    
/// top-down tabulation approach
/// TC:O(n), SC: O(n) (no extra space)
    /*static int findMaxSum(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int[]dp = new int[n+2];
        for (int idx = n-1;idx >= 0;idx--){
            if (dp[idx] == 0) {
                int pick = 0;
                pick = dp[idx + 2]+arr[idx];
                int notPick = dp[idx + 1];
                dp[idx] = Math.max(pick, notPick);
            }
        }
        return dp[0];
    }*/

    
/// bottom-up recursive solution with memoization.
/// TC: O(n), SC: O(n) + O(n)(recursive call stack)
    /*static int findMaxSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, arr, n, dp);
    }
    private static int f(int idx, int[]arr, int n, int[]dp){
        // base Case
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];

        int pick = 0;
        pick = arr[idx] + f(idx+2, arr, n, dp);
        int notPick = f(idx+1, arr, n, dp);

        return dp[idx] = Math.max(pick, notPick);
    }*/
}
