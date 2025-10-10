package LeetCode;/*
 *
 * https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
 *
 * # 3147. Taking Maximum Energy From the Mystic Dungeon
 *
 *   Q. In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you
 *      energy. Some magicians can give you negative energy, which means taking energy from you.
 *
 *      You have been cursed in such a way that after absorbing energy from magician i, you will be instantly
 *      transported to magician (i + k). This process will be repeated until you reach the magician where
 *      (i + k) does not exist.
 *
 *      In other words, you will choose a starting point and then teleport with k jumps until you reach the end
 *      of the magicians' sequence, absorbing all the energy during the journey.
 *
 *      You are given an array energy and an integer k. Return the maximum possible energy you can gain.
 *
 *      Note that when you are reach a magician, you must take energy from them, whether it is negative or
 *      positive energy.
 *   Ex.
 *      Input : energy = [5, 2, -10, -5, 1], k = 3
 *      Output: 3
 *      Explanation: We can gain a total energy of 3 by starting from magician 1 absorbing 2 + 1 = 3.
 *
 *  Constraints:
 *        •  1 <= energy.length <= 10⁵
 *        •  -1000 <= energy[i] <= 1000
 *        •  1 <= k <= energy.length - 1
 */

import java.util.Scanner;

public class LeetCode_3147_Taking_Maximum_Energy_From_the_Mystic_Dungeon {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter energies: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] energy = new int[n];
        for (int i = 0; i < n; i++) energy[i] = Integer.parseInt(s[i]);

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        System.out.println("Maximum energy: " + maximumEnergy(energy, k));
    }

    /// Solution
    static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int kth = (i >= n - k) ? 0 : energy[i + k];
            energy[i] += kth;
            max = Math.max(max, energy[i]);
        }

        return max;
    }
}
