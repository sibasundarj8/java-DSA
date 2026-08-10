package LeetCode;/*
 *
 * https://leetcode.com/problems/stone-game-iv/
 *
 * # LC. 1510. Stone Game IV
 *
 *   Q. Alice and Bob take turns playing a game, with Alice starting first.
 *
 *      Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing
 *      any non-zero square number of stones in the pile.
 *
 *      Also, if a player cannot make a move, he/she loses the game.
 *
 *      Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both
 *      players play optimally.
 *
 *    Ex.
 *      Input : n = 4
 *      Output: true
 *      Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1510_Stone_Game_IV {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of stones: ");
        int n = sc.nextInt();

        System.out.print("Can Alice win: ");
        System.out.println(winnerSquareGame(n) ? "Yes" : "No");
    }

    /// Solution
    private static final int[] DP = new int[100001];

    static boolean winnerSquareGame(int n) {
        // base case
        if (n == 0) return false;
        if (DP[n] != 0) return DP[n] == 2;

        // recursive work
        for (int i = 1; i * i <= n; i++) {
            if (!winnerSquareGame(n - i * i)) {
                DP[n] = 2;
                return true;
            }
        }

        DP[n] = 1;
        return false;
    }
}
