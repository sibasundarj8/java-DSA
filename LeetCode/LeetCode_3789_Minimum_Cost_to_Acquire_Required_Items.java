package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 *
 * # LC. 3789. Minimum Cost to Acquire Required Items
 *
 *   Q. You are given five integers cost1, cost2, costBoth, need1, and need2.
 *
 *      There are three types of items available:
 *        ◦ An item of type 1 costs cost1 and contributes 1 unit to the type 1 requirement only.
 *        ◦ An item of type 2 costs cost2 and contributes 1 unit to the type 2 requirement only.
 *        ◦ An item of type 3 costs costBoth and contributes 1 unit to both type 1 and type 2 requirements.
 *
 *      You must collect enough items so that the total contribution toward type 1 is at least need1 and the total
 *      contribution toward type 2 is at least need2.
 *
 *      Return an integer representing the minimum possible total cost to achieve these requirements.
 *
 *    Ex.
 *      Input : cost1 = 3, cost2 = 2, costBoth = 1, need1 = 3, need2 = 2
 *      Output: 3
 *      Explanation:
 *              After buying three type 3 items, which cost 3 * 1 = 3, the total contribution to type 1 is
 *              3 (>= need1 = 3) and to type 2 is 3 (>= need2 = 2).
 *
 *              Any other valid combination would cost more, so the minimum total cost is 3.
 *
 *  Constraints:
 *        ◦ 1 <= cost1, cost2, costBoth <= 10⁶
 *        ◦ 0 <= need1, need2 <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_3789_Minimum_Cost_to_Acquire_Required_Items {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("cost1: ");
        int cost1 = sc.nextInt();

        System.out.print("cost2: ");
        int cost2 = sc.nextInt();

        System.out.print("costBoth: ");
        int costBoth = sc.nextInt();

        System.out.print("need1: ");
        int need1 = sc.nextInt();

        System.out.print("need2: ");
        int need2 = sc.nextInt();

        System.out.println("Minimum possible total cost:");
        System.out.println(minimumCost(cost1, cost2, costBoth, need1, need2));
    }

    /// Solution
    static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // potd.code.hub
        long a = (long) cost1 * need1 + (long) cost2 * need2;
        long b = (long) costBoth * need1 + (long) cost2 * Math.max(need2 - need1, 0);
        long c = (long) cost1 * Math.max(need1 - need2, 0) + (long) costBoth * need2;

        return Math.min(a, Math.min(b, c));
    }
}
