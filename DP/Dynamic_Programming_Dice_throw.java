package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/dice-throw5349/1
 *
 * # Dice throw
 *
 *   Q. Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on
 *      each face when all the dice are thrown.
 *   Ex.
 *      Input : m = 6
 *              n = 3
 *              x = 12
 *      Output: 25
 *      Explanation: There are 25 total ways to get the Sum 12 using 3 dices with faces from 1 to 6.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Dice_throw {
    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Faces: ");
        int m = sc.nextByte();

        System.out.print("Number of Dice: ");
        int n = sc.nextByte();

        System.out.print("Target: ");
        int t = sc.nextByte();

        if (m > 50 || n > 50 || t > 50){
            System.out.println("Inputs must be smaller then 50 !!!");
            return;
        }

        System.out.println("Number of Ways: " + noOfWays(m, n, t));
    }

    /// Solution
    static int noOfWays(int m, int n, int x) {
        // potd.code.hub
        int[][] dp = new int[n+1][x+1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return fm(m, n, x, dp);
    }
/**************************************************<---Memoization--->**************************************************/
// TC: O(n * m * x)
// SC: O(m*x + m*x)
    private static int fm(int totalFace, int numOfDice, int target, int[][] dp) {
        // base case
        if (numOfDice == 0) {
            return (target == 0) ? 1 : 0;
        }
        if (dp[numOfDice][target] != -1) {
            return dp[numOfDice][target];
        }

        // recursive work & self work
        int ways = 0;
        for (int face = 1; face <= totalFace; face++) {
            if (face <= target) {
                ways += fm(totalFace, numOfDice - 1, target - face, dp);
                dp[numOfDice][target] = ways;
            }
        }

        return ways;
    }
}
