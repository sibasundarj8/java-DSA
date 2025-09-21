package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/max-rectangle/1
 *
 * # Max rectangle
 *
 *   Q. You are given a 2D binary matrix mat[ ][ ], where each cell contains either 0 or 1. Your task is
 *      to find the maximum area of a rectangle that can be formed using only 1's within the matrix.
 *    Ex.
 *      Input : mat[][] = [[0, 1, 1, 0],
 *                         [1, 1, 1, 1],
 *                         [1, 1, 1, 1],
 *                         [1, 1, 0, 0]]
 *      Output: 8
 *      Explanation: The largest rectangle with only 1’s is from (1, 0) to (2, 3) which is
 *                   [1, 1, 1, 1]
 *                   [1, 1, 1, 1]
 *                   and area is 4 * 2 = 8.
 *
 *  Constraints:
 *      1 ≤ mat.size(), mat[0].size() ≤ 1000
 *      0 ≤ mat[][] ≤ 1
 */

import java.util.Scanner;
import java.util.Stack;

public class S15_Max_rectangle {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension (row ⨉ col) : ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Enter elements (0 | 1) : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("maximum area of a rectangle: " + maxArea(mat));
    }

    /// Solution
    static int maxArea(int[][] mat) {
        // potd.code.hub
        int m = mat[0].length;
        int ans = 0;
        int[] dynamicHistogram = new int[m];

        for (int[] arr : mat) {
            for (int j = 0; j < m; j++) {
                dynamicHistogram[j] = (arr[j] == 1) ? dynamicHistogram[j] + 1 : 0;
            }
            ans = Math.max(ans, getMaxRectAreaOfHistogram(dynamicHistogram));
        }

        return ans;
    }

    // area of largest rectangle in a histogram
    private static int getMaxRectAreaOfHistogram(int[] arr) {
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
