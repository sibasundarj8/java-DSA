package Two_Pointers;/*
 *
 * https://www.geeksforgeeks.org/problems/dam-of-candies--141631/1
 *
 * # Maximum Area Between Bars
 *
 *   Q. Given an integer array height[], where height[i] represents the height of the ith bar arranged in a row, find the
 *      maximum rectangular area that can be formed by selecting any two bars. The area is calculated based on the original
 *      positions of the selected bars.
 *
 *    Ex.
 *      Input : height[] = [2, 5, 4, 3, 7]
 *      Output: 10
 *      Explanation:         ↓                       ↓
 *                         +---+                   +---+
 *                         |   |                   |   |
 *                         |   |:::::::::::::::::::|   |
 *                         | 5 |   +---+           | 7 |
 *                         |   |   | 4 |           |   |
 *                         |   |   |:::|   +---+   |   |
 *                         |   |   |:::|   | 3 |   |   |
 *                 +---+   |   |   |:::|   |:::|   |   |
 *                 | 2 |   |   |   |:::|   |:::|   |   |
 *                 |   |   |   |   |:::|   |:::|   |   |
 *              ===+===+===+===+===+===+===+===+===+===+===
 *              The maximum rectangular area is formed by selecting the bars of heights 5 and 7.
 *              There are 2 bars between them, so the area is: min(5, 7) × 2 = 10
 *
 *  Constraints:
 *         1 ≤ height.size() ≤ 10⁵
 *         1 ≤ height[i] ≤ 10⁴
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q06_Maximum_Area_Between_Bars {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> heights = new ArrayList<>();

        System.out.println("Enter height of bars: ");
        String[] s = sc.nextLine().split(" ");

        for (String height : s) {
            heights.add(Integer.parseInt(height));
        }

        System.out.println("Max rectangle possible using bars: ");
        System.out.println(maxArea(heights));
    }

    /// Solution
    static int maxArea(List<Integer> height) {
        // potd.code.hub
        int i = 0;
        int j = height.size() - 1;
        int maxRectangle = 0;

        while (j - i > 1) {
            int l = height.get(i);
            int r = height.get(j);
            int size = Math.min(l, r) * (j - i - 1);
            maxRectangle = Math.max(maxRectangle, size);

            if (l < r) i++;
            else j--;
        }

        return maxRectangle;
    }
}
