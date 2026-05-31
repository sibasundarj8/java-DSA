package Greedy;/*
 *
 * https://leetcode.com/problems/destroying-asteroids/
 *
 * # 2126. Destroying Asteroids
 *
 *   Q. You are given an integer mass, which represents the original mass of a planet. You are further given an integer
 *      array asteroids, where asteroids[i] is the mass of the ith asteroid.
 *
 *      You can arrange for the planet to collide with the asteroids in any arbitrary order. If the mass of the planet is
 *      greater than or equal to the mass of the asteroid, the asteroid is destroyed and the planet gains the mass of the
 *      asteroid. Otherwise, the planet is destroyed.
 *
 *      Return true if all asteroids can be destroyed. Otherwise, return false.
 *
 *    Ex.
 *      Input : mass = 10, asteroids = [3, 9, 19, 5, 21]
 *      Output: true
 *      Explanation: One way to order the asteroids is [9, 19, 5, 3, 21]:
 *              - The planet collides with the asteroid with a mass of 9. New planet mass: 10 + 9 = 19
 *              - The planet collides with the asteroid with a mass of 19. New planet mass: 19 + 19 = 38
 *              - The planet collides with the asteroid with a mass of 5. New planet mass: 38 + 5 = 43
 *              - The planet collides with the asteroid with a mass of 3. New planet mass: 43 + 3 = 46
 *              - The planet collides with the asteroid with a mass of 21. New planet mass: 46 + 21 = 67
 *              All asteroids are destroyed.
 *
 *  Constraints:
 *      1 <= mass <= 10⁵
 *      1 <= asteroids.length <= 10⁵
 *      1 <= asteroids[i] <= 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class G12_Destroying_Asteroids {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter initial mass of the planet: ");
        int mass = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter mass of asteroids: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {

            asteroids[i] = Integer.parseInt(s[i]);
            if (asteroids[i] == 0) {
                throw new IllegalArgumentException("Invalid asteroid " + asteroids[i]);
            }
        }

        System.out.println("can all asteroids be destroyed: ");
        System.err.println(asteroidsDestroyed(mass, asteroids) ? "Yes" : "No");
    }

    /// Solution
    static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long newMass = mass;
        Arrays.sort(asteroids);

        for (int ele : asteroids) {
            if (ele <= newMass) {
                newMass += ele;
            } else return false;
        }

        return true;
    }
}
