package LeetCode;/*
 *
 * https://leetcode.com/problems/water-bottles-ii/
 *
 * # 3100. Water Bottles II  (Medium)
 *
 *   Q. You are given two integers numBottles and numExchange. numBottles represents the number of full water
 *      bottles that you initially have.
 *
 *      In one operation, you can perform one of the following operations:
 *        • Drink any number of full water bottles turning them into empty bottles.
 *        • Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
 *
 *      Note: you cannot exchange multiple batches of empty bottles for the same value of numExchange.
 *            For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water
 *            bottles for 3 full bottles.
 *
 *      Return the maximum number of water bottles you can drink.
 *
 *   Ex.
 *      Input : numBottles = 13, numExchange = 6
 *      Output: 15                      +--------------+----------------+----------------+---------------+
 *      Explanation:                    | Full Bottles | Empty Bottles  | numExchange    | Bottles Drunk |
 *                         +------------+--------------+----------------+----------------+---------------+
 *                         | Initially  |      13      |       0        |       6        |       0       |
 *                         +------------+--------------+----------------+----------------+---------------+
 *                         | Drink 13   |       0      |      13        |       6        |      13       |
 *                         +------------+--------------+----------------+----------------+---------------+
 *                         | Exchange   |       1      |       7        |       7        |      13       |
 *                         +------------+--------------+----------------+----------------+---------------+
 *                         | Exchange   |       2      |       0        |       8        |      13       |
 *                         +------------+--------------+----------------+----------------+---------------+
 *                         | Drink 2    |       0      |       2        |       8        |      15       |
 *                         +------------+--------------+----------------+----------------+---------------+
 *
 *  Constraints:
 *          1 <= numBottles <= 100
 *          1 <= numExchange <= 100
 */

import java.util.Scanner;

public class LeetCode_3100_Water_Bottles_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of bottles: ");
        int n = sc.nextInt();

        System.out.print("Number of empty for one full: ");
        int e = sc.nextInt();

        System.out.println("Maximum bottle drunk: " + maxBottlesDrunk(n, e));
    }

    /// Solution
    static int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            count++;
            empty -= numExchange++ - 1;
        }

        return count;
    }
}
