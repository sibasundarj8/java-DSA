package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/last-coin-in-a-game-of-alternates/1
 *
 * # Last Coin in a Game of Alternates
 *
 *   Q. Given an array integer arr[] , representing the values of coins arranged in a row.
 *
 *        ◦ Two players play a game by picking coins alternately.
 *
 *        ◦ At each turn, a player can pick a coin from either the beginning or the end of the array. Both players follow
 *          a greedy strategy, i.e., they always pick the coin with the maximum value among the two available ends.
 *
 *        ◦ The game continues until only one coin remains.
 *
 *      Find the value of the last remaining coin.
 *
 *    Ex.
 *      Input : arr[] = [5, 3, 1, 6, 9]
 *      Output: 1
 *      Explanation:
 *              Players always pick the larger coin from the two ends.
 *                ◦ Pick 9, remaining array: [5, 3, 1, 6]
 *                ◦ Pick 6, remaining array: [5, 3, 1]
 *                ◦ Pick 5, remaining array: [3, 1]
 *                ◦ Pick 3, remaining array: [1]
 *              Final Output: 1
 *
 *  Constraints :
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Scanner;

public class POTD_Last_Coin_in_a_Game_of_Alternates {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coins: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Value of the last remaining coin: ");
        System.out.println(coin(coins));
    }

    /// Solution
    static int coin(int[] coins) {
        // potd.code.hub
        int min = Integer.MAX_VALUE;

        for (int ele : coins) {
            min = Math.min(min, ele);
        }

        return min;
    }
}
