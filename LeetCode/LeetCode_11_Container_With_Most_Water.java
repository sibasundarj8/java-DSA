package LeetCode;/*
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * # 11. Container With Most Water
 *
 *   Q. You are given an integer array height of length n. There are n vertical lines drawn such that the two
 *      endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 *      Find two lines that together with the x-axis form a container, such that the container contains the
 *      most water.
 *
 *      Return the maximum amount of water a container can store.
 *
 *      Notice that you may not slant the container.
 *   Ex.
 *      Input : height = [1,8,6,2,5,4,8,3,7]
 *      Output: 49
 *      Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 *                   the max area of water (blue section) the container can contain is 49.
 *
 *  Constraints:
 *        n == height.length
 *        2 <= n <= 10⁵
 *        0 <= height[i] <= 10⁴
 */

import java.util.Scanner;

public class LeetCode_11_Container_With_Most_Water {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter heights: ");
        String[] s = sc.nextLine().split(" ");
        
        int n = s.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(s[i]);

        System.out.println("Max container volume: " + maxArea(heights));
    }

    /// Solution
    static int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int volume = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, volume);

            if (height[i] < height[j]) i++;
            else j--;
        }

        return res;
    }
}
