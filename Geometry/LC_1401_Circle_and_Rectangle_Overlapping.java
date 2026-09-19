package Geometry;/*
 *
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/
 *
 * # LC. 1401. Circle and Rectangle Overlapping
 *
 *   Q. You are given a circle represented as (radius, xCenter, yCenter) and an axis-aligned rectangle represented
 *      as (x1, y1, x2, y2), where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the
 *      coordinates of the top-right corner of the rectangle.
 *
 *      Return true if the circle and rectangle are overlapped otherwise return false. In other words, check if there
 *      is any point (xi, yi) that belongs to the circle and the rectangle at the same time.
 *
 *    Ex.
 *      Input : radius = 1,
 *              xCenter = 0, yCenter = 0,
 *              x1 = 1, y1 = -1,              ⃝ ☐
 *              x2 = 3, y2 = 1
 *      Output: true
 *      Explanation: Circle and rectangle share the point (1,0).
 *
 *  Constraints:
 *        ◦ 1 <= radius <= 2000
 *        ◦ -10⁴ <= xCenter, yCenter <= 10⁴
 *        ◦ -10⁴ <= x1 < x2 <= 10⁴
 *        ◦ -10⁴ <= y1 < y2 <= 10⁴
 */

import java.util.Scanner;

public class LC_1401_Circle_and_Rectangle_Overlapping {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Circle radius: ");
        int r = sc.nextInt();

        System.out.println("Enter Circle center position: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Enter the rectangle position: (bottom-left, top-right)");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        if (x1 >= x2 && y1 >= y2) {
            throw new IllegalArgumentException("Invalid rectangle position");
        }

        System.out.println("Does the overlap: " + (checkOverlap(r, x, y, x1, y1, x2, y2) ? "YES" : "NO"));
    }

    /// Solution
    static boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {

        // getting the closest point
        int closestX = Math.clamp(x, x1, x2);
        int closestY = Math.clamp(y, y1, y2);

        int diffX = closestX - x;
        int diffY = closestY - y;

        return (diffX * diffX) + (diffY * diffY) <= (r * r);
    }
}
