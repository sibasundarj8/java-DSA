package Greedy;/*
 *
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 *
 * # 2078. Two Furthest Houses With Different Colors
 *
 *   Q. There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed
 *      integer array colors of length n, where colors[i] represents the color of the ith house.
 *
 *      Return the maximum distance between two houses with different colors.
 *
 *      The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
 *
 *    Ex.
 *      Input : colors = [1, 1, 1, 6, 1, 1, 1]
 *      Output: 3
 *      Explanation: In the above image, color 1 is blue, and color 6 is red.
 *              The furthest two houses with different colors are house 0 and house 3.
 *              House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
 *              Note that houses 3 and 6 can also produce the optimal answer.
 *
 *  Constraints:
 *          n == colors.length
 *          2 <= n <= 100
 *          0 <= colors[i] <= 100
 *          Test data are generated such that at least two houses have different colors.
 */

import java.util.Scanner;

public class G09_Two_Furthest_Houses_With_Different_Colors {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter colors: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Maximum distance between two houses with different colors: ");
        System.out.println(maxDistance(colors));
    }

    /// Solution
    static int maxDistance(int[] colors) {
        int n = colors.length;

        for (int i = 0; i < n; i++) {
            int r = n - 1 - i;

            if (colors[0] != colors[r] || colors[i] != colors[n - 1]) {
                return r;
            }
        }

        return 0;
    }
}
