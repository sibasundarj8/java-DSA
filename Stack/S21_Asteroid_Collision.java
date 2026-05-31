package Stack;/*
 *
 * https://leetcode.com/problems/asteroid-collision/
 *
 * # 735. Asteroid Collision
 *
 *   Q. We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the
 *      array represent their relative position in space.
 *
 *      For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
 *      right, negative meaning left). Each asteroid moves at the same speed.
 *
 *      Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 *      If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *    Ex.
 *      Input : asteroids = [3, 5, -6, 2, -1, 4]
 *      Output: [-6,2,4]
 *      Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side,
 *                   the asteroid 2 makes the asteroid -1 explode and then continues going right, without reaching asteroid
 *                   4.
 *
 *  Constraints:
 *      2 <= asteroids.length <= 10⁴
 *      -1000 <= asteroids[i] <= 1000
 *      asteroids[i] != 0
 */

import java.util.Arrays;
import java.util.Scanner;

public class S21_Asteroid_Collision {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter mass of asteroids");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] asteroids = new int[n];
        for (int i = 0; i < n; i++) {
            asteroids[i] = Integer.parseInt(s[i]);
            if (asteroids[i] == 0) {
                throw new IllegalArgumentException("invalid input");
            }
        }

        System.out.println("Remaining asteroids: ");
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    /// Solution
    static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;

        for (int ele : asteroids) {
            boolean exist = true;

            while (-1 != top && stack[top] > 0 && ele < 0) {
                int mass1 = stack[top];
                int mass2 = ele * -1;

                if (mass1 <= mass2) {
                    stack[top--] = 0;
                }

                if (mass1 >= mass2) {
                    exist = false;
                    break;
                }
            }

            if (exist) stack[++top] = ele;
        }

        int[] res = new int[top + 1];
        System.arraycopy(stack, 0, res, 0, top + 1);

        return res;
    }
}
