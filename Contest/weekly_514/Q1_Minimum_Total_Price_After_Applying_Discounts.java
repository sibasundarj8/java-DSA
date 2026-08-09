package Contest.weekly_514;/*
 *
 * https://leetcode.com/contest/weekly-contest-514/problems/minimum-total-price-after-applying-discounts/
 *
 * # Q1. Minimum Total Price After Applying Discounts
 *
 *   Q. You are given two integer arrays prices and discounts. The value prices[i] represents the price of the ith item,
 *      and discounts[j] represents a discount percentage.
 *
 *      You may apply discounts subject to the following rules:
 *        ◦ Each discount can be applied to at most one item.
 *        ◦ Each item can receive at most one discount.
 *        ◦ An item may also receive no discount.
 *
 *      If a discount of d percent is applied to an item with price p, its final price becomes (p * (100 - d)) / 100.
 *      The final price is not rounded.
 *
 *      Return the minimum possible sum of final prices after assigning discounts optimally. Answers within 10-5 of the
 *      actual answer will be accepted.
 *
 *    Ex.
 *      Input : prices = [10,30,21], discounts = [50,60]
 *      Output: 32.50000
 *      Explanation:
 *              Apply discounts[1] = 60 to prices[1] = 30, thus 30 * (100 - 60) / 100 = 12.
 *              Apply discounts[0] = 50 to prices[2] = 21, thus 21 * (100 - 50) / 100 = 10.5.
 *              prices[0] = 10 receives no discount, so it stays 10.
 *              The total is 12 + 10.5 + 10 = 32.50000, which is the minimum possible.
 *
 *  Constraints:
 *        ◦ 1 <= prices.length, discounts.length <= 10⁵
 *        ◦ 1 <= prices[i] <= 10⁵
 *        ◦ 1 <= discounts[j] <= 100
 */

import java.util.Arrays;

public class Q1_Minimum_Total_Price_After_Applying_Discounts {

    /// Solution
    public double minPrice(int[] p, int[] d) {
        int n = p.length;
        int m = d.length;

        Arrays.sort(p);
        Arrays.sort(d);

        double ammount = 0;

        for (int i = 0; i < n; i++) {
            double t = p[n - 1 - i];
            if (i < m) {
                t -= (t * d[m - 1 - i] / 100);
            }
            ammount += t;
        }

        return ammount;
    }
}
