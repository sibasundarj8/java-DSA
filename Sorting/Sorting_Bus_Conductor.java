package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/bus-conductor--170647/1
 *
 * # Bus Conductor
 *
 *   Q. You are conductor of a bus. You are given two arrays chairs[] and passengers[] of equal length, where chairs[i] is
 *      the position of the ith chair and passengers[j] is the position of the jth passenger. You may perform the following
 *      move any number of times:
 *          ➢ Increase or decrease the position of the ith passenger by 1 (i.e., moving the ith passenger from position x
 *            to x+1 or x-1)
 *
 *      Return the minimum number of moves required to move each passenger to get a chair.
 *
 *      Note: Although multiple chairs can occupy the same position, each passenger must be assigned to exactly one unique
 *            chair.
 *   Ex.
 *      Input : chairs[] = [2, 2, 6, 6],
 *              passengers[] = [1, 3, 2, 6]
 *      Output: 4
 *      Explanation: Note that there are two chairs at position 2 and two chairs at position 6.
 *                   The passengers are moved as follows:
 *                      - The first passenger is moved from position 1 to position 2 using 1 move.
 *                      - The second passenger is moved from position 3 to position 6 using 3 moves.
 *                      - The third passenger is not moved.
 *                      - The fourth passenger is not moved.
 *                   In total, 1 + 3 + 0 + 0 = 4 moves were used.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ chairs[i], passengers[j] ≤ 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Bus_Conductor {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Chairs position: ");
        String[] c = sc.nextLine().split(" ");

        System.out.println("Enter Passengers position: ");
        String[] p = sc.nextLine().split(" ");

        int n = c.length;
        if (p.length != n) return;

        int[] chairs = new int[n];
        int[] passengers = new int[n];

        for (int i = 0; i < n; i++) {
            passengers[i] = Integer.parseInt(p[i]);
            chairs[i] = Integer.parseInt(c[i]);
        }

        System.out.println("Minimum number of moves required to provide at-least one Chair to each Passenger: ");
        System.out.println(findMoves(chairs, passengers));
    }

    /// Solution
    static int findMoves(int[] chairs, int[] passengers) {
        int n = passengers.length;
        int ans = 0;

        Arrays.sort(chairs);
        Arrays.sort(passengers);

        for (int i = 0; i < n; i++) {
            ans += Math.abs(chairs[i] - passengers[i]);
        }
        return ans;
    }
}
