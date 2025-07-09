package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/next-greater-element/1
 *
 * # Next Greater Element in Circular Array
 *
 *   Q. Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each
 *      element in the array.
 *
 *      The next greater element of an element arr[i] is the first element that is greater than arr[i] when
 *      traversing circularly. If no such element exists, return -1 for that position.
 *
 *      Circular Property:
 *          Since the array is circular, after reaching the last element, the search continues from the
 *          beginning until we have looked at all elements once.
 *    Ex:
 *      Input : arr[] = [0, 2, 3, 1, 1]
 *      Output: [2, 3, -1, 2, 2]
 *      Explanation:
 *             The next greater element for 0 is 2.
 *             The next greater element for 2 is 3.
 *             The next greater element for 3 does not exist, so return -1.
 *             The next greater element for 1 is 2 (from circular traversal).
 *             The next greater element for 1 is 2 (from circular traversal).
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S08_Next_Greater_Element_in_Circular_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Next Greater : " + nextLargerElement(arr));
    }

    /// Solution
    static ArrayList<Integer> nextLargerElement(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // finding the starting index
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[start]) start = i;
            ans.add(-1);
        }

        stack.push(arr[start]);
        ans.set(start--, -1);

        for (int i = 0; i < n; i++) {
            int hlp = start - i;
            int idx = (hlp < 0) ? n + hlp : hlp;

            while (!stack.isEmpty() && stack.peek() <= arr[idx]) stack.pop();

            if (!stack.isEmpty()) ans.set(idx, stack.peek());

            stack.push(arr[idx]);
        }

        return ans;
    }
}
