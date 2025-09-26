package Deloitte_Mock;/*
 *
 * ## Problem Statement (medium)
 *
 *      You have M coins placed on the floor, all initially showing tails.
 *
 *      1) In the 1st round, you flip all the coins to heads.
 *      2) In the 2nd round, you flip every second coin that is currently showing heads, turning it to tails.
 *      3) In the 3rd round, you flip every third coin, toggling it between heads and tails.
 *      I) In the Ith round, you flip every ith coin.
 *      M) After performing this for M rounds, where in the last round you only flip the Mth coin, determine
 *         how many coins are showing heads.
 *    Ex.
 *      Input : 3
 *      Output: 1
 *      Explanation:
 *              At first, the three Coins are -------------------> [tail, tail, tail].
 *              After the first round, the three Coins are ------> [head, head, head].
 *              After the second round, the three Coins are -----> [head, tail, head].
 *              After the third round, the three Coins are ------> [head, tail, tail].
 *              So you should Print 1 because there is only one Coin left with the head.
 *
 *   Constraints:
 *          0 <= M <= 10⁴
 */

import java.util.Scanner;

public class Q03_Coin_Head_Count {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // number of coins with all tails
        int n = sc.nextInt();

        // count of heads after n flips
        System.out.println(find(n));
    }

    /// Solution
    static int find(int m) {
        // potd.code.hub
        return (int)Math.sqrt(m);
    }
}