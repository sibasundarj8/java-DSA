package LeetCode;/*
 *
 * https://leetcode.com/problems/largest-triangle-area/
 *
 * # 812. Largest Triangle Area (Easy)
 *
 *   Q. Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the
 *      largest triangle that can be formed by any three different points. Answers within 10-5 of the actual
 *      answer will be accepted.
 *
 *    Ex.
 *      Input : points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 *      Output: 2.00000
 *      Explanation: The five points are shown in the above figure. The red triangle is the largest.
 *
 *  Constraints:
 *      •  3 <= points.length <= 50
 *      •  -50 <= xɪ, yɪ <= 50
 *      •  All the given points are unique.
 */

import java.util.Scanner;

public class LeetCode_812_Largest_Triangle_Area {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of points: ");
        int n = sc.nextInt();

        int[][] points = new int[n][2];

        System.out.println("Enter points: (xɪ and yɪ)");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println("Area of largest triangle: ");
        System.out.println(largestTriangleArea(points));
    }

    /// Solution
    static double largestTriangleArea(int[][] arr) {
        int n = arr.length;
        double ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = (double) Math.abs(
                            arr[i][0] * (arr[j][1] - arr[k][1]) +
                            arr[j][0] * (arr[k][1] - arr[i][1]) +
                            arr[k][0] * (arr[i][1] - arr[j][1])
                    ) / 2;
                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }
}
