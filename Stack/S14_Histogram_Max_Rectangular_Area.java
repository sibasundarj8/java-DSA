package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
 *
 * # Histogram Max Rectangular Area
 *
 *   Q. You are given a histogram represented by an array arr[], where each element of the array denotes
 *      the height of the bars in the histogram. All bars have the same width of 1 unit.
 *
 *      Your task is to find the largest rectangular area possible in the given histogram, where the
 *      rectangle can be formed using a number of contiguous bars.
 *
 *    Ex.
 *      Input : arr[] = [60, 20, 50, 40, 10, 50, 60]
 *
 *                       60 | ⨉               ⨉
 *                       50 | ⨉   ⨉        ⁜  ⁜
 *                       40 | ⨉   ⨉  ⨉     ⁜  ⁜
 *                       30 | ⨉   ⨉  ⨉     ⁜  ⁜
 *                       20 | ⨉ ⨉ ⨉  ⨉     ⁜  ⁜
 *                       10 | ⨉ ⨉ ⨉  ⨉ ⨉   ⁜  ⁜
 *                  --------------------------------
 *                          |60 20 50 40 10 50 60
 *                          |
 *      Output: 100
 *      Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is
 *                   computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      0 ≤ arr[i] ≤ 10⁴
 */

import java.util.Scanner;
import java.util.Stack;

public class S14_Histogram_Max_Rectangular_Area {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter histogram heights: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("area of largest rectangle possible: " + getMaxArea(arr));
    }

    /// Solution
    static int getMaxArea(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        int[] pse = prevSmaller(arr);
        int[] nse = nextSmaller(arr);

        for (int i = 0; i < n; i++) {
            int possRectArea = (nse[i] - pse[i] - 1) * arr[i];
            ans = Math.max(ans, possRectArea);
        }

        return ans;
    }

    // previous smaller element
    private static int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        pse[0] = -1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    // next smaller element
    private static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        nse[n - 1] = n;
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nse[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }
}
