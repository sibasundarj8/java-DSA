package LeetCode;/*
 *
 * https://leetcode.com/problems/water-bottles/
 *
 * # 1518. Water Bottles
 *
 *   Q. There are numBottles water bottles that are initially full of water. You can exchange numExchange
 *      empty water bottles from the market with one full water bottle.
 *
 *      The operation of drinking a full water bottle turns it into an empty bottle.
 *
 *      Given the two integers numBottles and numExchange, return the maximum number of water bottles you
 *      can drink.
 *   Ex.
 *      Input : numBottles = 9
 *              numExchange = 3
 *      Output: 13
 *      Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 *                   Number of water bottles you can drink: 9 + 3 + 1 = 13.
 *
 *  Constraints:
 *      1 <= numBottles <= 100
 *      2 <= numExchange <= 100
 */

import java.util.Scanner;

public class LeetCode_1518_Water_Bottles {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Bottles: ");
        int n = sc.nextInt();

        System.out.print("Bottle for Exchange: ");
        int e = sc.nextInt();

        System.out.println("Max Bottle have to drink: " + numWaterBottles(n, e));
    }

    /// Solution
/*....................................Brute-Force--(O(numBottles / (numExchange-1))).....................................*/
    static int numWaterBottlesBF(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            numBottles = empty / numExchange;
            empty -= numBottles * numExchange - numBottles;
            count += numBottles;
        }

        return count;
    }

/*..................................................Math-Formula-(O(1))..................................................*/
    static int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
