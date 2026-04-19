package Contest.weekly_497;/*
 *
 * https://leetcode.com/contest/weekly-contest-497/problems/angles-of-a-triangle/
 *
 * # Q2. Angles of a Triangle
 *
 *   Q. You are given a positive integer array sides of length 3. Determine if there exists a triangle with positive area
 *      whose three side lengths are given by the elements of sides.
 *
 *      If such a triangle exists, return an array of three floating-point numbers representing its internal angles (in degrees),
 *      sorted in non-decreasing order. Otherwise, return an empty array.
 *
 *      Answers within 10⁻⁵ of the actual answer will be accepted.
 *
 *    Ex.
 *      Input: sides = [3,4,5]
 *      Output: [36.86990,53.13010,90.00000]
 *      Explanation:
 *              You can form a right-angled triangle with side lengths 3, 4, and 5. The internal angles of this triangle are
 *              approximately 36.869897646, 53.130102354, and 90 degrees respectively.
 *
 *              Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
 *
 *  Constraints:
 *          sides.length == 3
 *          1 <= sides[i] <= 1000
 */

import java.util.Arrays;

public class Q2_Angles_of_a_Triangle {

    /// Solution
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);

        if (sides[0] + sides[1] <= sides[2]) return new double[0];

        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        double A = (b * b + c * c - a * a) / (2 * b * c);
        double B = (a * a + c * c - b * b) / (2 * a * c);
        double C;

        // angle in radian
        A = Math.acos(A);
        B = Math.acos(B);

        A = Math.toDegrees(A);
        B = Math.toDegrees(B);
        C = 180 - (A + B);

        double[] angles = new double[3];
        angles[0] = A;
        angles[1] = B;
        angles[2] = C;

        Arrays.sort(angles);

        return angles;
    }
}
