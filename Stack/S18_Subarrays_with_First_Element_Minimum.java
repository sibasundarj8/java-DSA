package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/subarrays-with-first-element-minimum/1
 *
 * # Subarrays with First Element Minimum
 *
 *   Q. You are given an integer array arr[ ]. Your task is to count the number of subarrays where the first element is
 *      the minimum element of that subarray.
 *
 *      Note: A subarray is valid if its first element is not greater than any other element in that subarray.
 *
 *    Ex.
 *      Input : arr[] = [1, 3, 5, 2]
 *      Output: 8
 *      Explanation: Valid subarrays are: [1], [1, 3], [1, 3, 5], [1, 3, 5, 2], [3], [3, 5], [5], [2] -> total 8
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 4 * 10⁴
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Scanner;
import java.util.Stack;

public class S18_Subarrays_with_First_Element_Minimum {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of subarrays in which first element is minimum: ");
        System.out.println(countSubarrays(arr));
    }

    /// Solution
    static int countSubarrays(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();

            int nextSmaller = (stack.isEmpty()) ? n : stack.peek();
            res += (nextSmaller - i);

            stack.push(i);
        }

        return res;
    }
}
