package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/equalize-the-towers2804/1
 *
 * # Equalize the Towers
 *
 *   Q. You are given an array heights[] representing the heights of towers and another array cost[]
 *      where each element represents the cost of modifying the height of respective tower.
 *
 *      -> The goal is to make all towers of same height by either adding or removing blocks from
 *         each tower.
 *      -> Modifying the height of tower (add or remove) 'i' by 1 unit costs cost[i].
 *      -> Return the minimum cost to equalize the heights of all towers.
 *   Ex.
 *      Input : heights[] = [7, 1, 5]
 *              cost[] = [1, 1, 1]
 *      Output: 6
 *      Explanation: The minimum cost to equalize the towers is 6, achieved by setting all towers
 *                   to height 5.
 */

import java.util.Scanner;

public class Searching_Equalize_the_Towers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Height of the towers: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] heights = new int[n];
        int[] costs = new int[n];

        System.out.println("Enter cost of modification of towers respectively: ");
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
            heights[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum cost required to equalize: " + minCost(heights, costs));
    }

    /// Solution
    static int minCost(int[] heights, int[] cost) {
        // potd.code.hub
        int lo = Integer.MAX_VALUE, up = 0, ans = -1;
        for (int i : heights) {
            lo = Math.min(lo, i);
            up = Math.max(up, i);
        }

        while (lo <= up) {
            int mid = lo + (up - lo) / 2;
            // returns and array containing cost of mid-1 and mid respectively
            int[] temp = calculateCost(heights, cost, mid);
            
            /*
         height
            ^                 /
            | \             /
            |   \         /
            |     \     /
            |       \./  <-------------- we have to find this point in the height graph
            |-----------cost-------> 
            */
            
            if (temp[0] > temp[1]) {
                ans = temp[1];
                lo = mid + 1;
            } else up = mid - 1;
        }

        return ans;
    }

    private static int[] calculateCost(int[] heights, int[] cost, int mid) {
        int n = heights.length, a0 = 0, a1 = 0;

        for (int i = 0; i < n; i++) {
            a1 += cost[i] * Math.abs(heights[i] - mid);
            a0 += cost[i] * Math.abs(heights[i] - mid + 1);
        }

        return new int[]{a0, a1};
    }
}
