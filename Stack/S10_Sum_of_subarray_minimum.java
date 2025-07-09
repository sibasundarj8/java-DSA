package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-subarray-minimum/1
 *
 * # Sum of subarray minimum
 *
 *   Q. Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible
 *      subarrays.
 *
 *      Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.
 *   Ex.
 *      Input : arr[] = [3, 1, 2, 4]
 *      Output: 17
 *      Explanation: Subarrays are [3],         |->   3
 *                                 [1],         |->   1
 *                                 [2],         |->   2
 *                                 [4],         |->   4
 *                                 [3, 1],      |->   1
 *                                 [1, 2],      |->   1
 *                                 [2, 4],      |->   2
 *                                 [3, 1, 2],   |->   1
 *                                 [1, 2, 4],   |->   1
 *                                 [3, 1, 2, 4].|->   1
 *                   Sum of all these are 17.
 */

import java.util.Scanner;
import java.util.Stack;

public class S10_Sum_of_subarray_minimum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Sum of sub-array minimums: " + sumSubMins(arr));
    }

    /// Solution
/*
-------------------------------------------------------Brute-Force-------------------------------------------------------
TC : O(n²)
SC : O(1)
*/
    static int bruteForce (int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0;i < n;i++) {
            int min = arr[i];
            for (int j = i;j < n;j++) {
                min = Math.min(arr[j], min);
                ans += min;
            }
        }

        return ans;
    }
/*
-------------------------------------------------------Using-Stack-------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int sumSubMins(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;
        int[] prvSml = prevSmallerEql(arr);
        int[] nxtSml = nextSmallerEle(arr);

        for (int i = 0; i < n; i++) {
            int rd = nxtSml[i] - i; // right distance
            int ld = i - prvSml[i]; // left distance
            ans += arr[i] * (rd * ld); // total number of sub-array can be formed
        }

        return ans;
    }

    private static int[] prevSmallerEql(int[] arr) { // previous smaller or equal element
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        res[0] = -1;
        stack.add(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.add(i);
        }

        return res;
    }
    private static int[] nextSmallerEle(int[] arr) { // next smaller element
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        res[n - 1] = n;
        stack.add(n-1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            res[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.add(i);
        }

        return res;
    }
}
