package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1
 *
 * # Max of min for every window size
 *
 *   Q. You are given an integer array arr[], the task is to find the maximum of minimum values for every
 *      window size k where 1≤ k ≤ arr.size().
 *
 *      For each window size k, consider all contiguous subarrays of length k, determine the minimum element
 *      in each subarray, and then take the maximum among all these minimums.
 *
 *      Return the results as an array, where the element at index 'i' represents the answer for window size
 *      i+1.
 *   Ex.
 *      Input : arr[] = [10, 20, 30, 50, 10, 70, 30]
 *      Output: [70, 30, 20, 10, 10, 10, 10]
 *      Explanation:
 *          Window size 1: minimums are [10, 20, 30, 50, 10, 70, 30], maximum of minimums is 70.
 *          Window size 2: minimums are [10, 20, 30, 10, 10, 30], maximum of minimums is 30.
 *          Window size 3: minimums are [10, 20, 10, 10, 10], maximum of minimums is 20.
 *          Window size 4–7: minimums are [10, 10, 10, 10], maximum of minimums is 10.
 *
 *   Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S16_Max_of_min_for_every_window_size {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Max of mins for every window: ");
        System.out.println(maxOfMins(arr));
    }

    /// Solution
    static ArrayList<Integer> maxOfMins(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] nse, pse;

        for (int i = 0; i < n; i++) list.add(-1);
        pse = prevSmaller(arr);
        nse = nextSmaller(arr);

        for (int i = 0; i < n; i++) {
            int curRange = nse[i] - pse[i] - 1;
            if (list.get(curRange - 1) < arr[i]) list.set(curRange - 1, arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {             
            list.set(i, Math.max(list.get(i), list.get(i + 1)));
        }

        return list;
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
