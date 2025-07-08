package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/next-element-with-greater-frequency--170637/1
 *
 * # Next element with greater frequency
 *
 *   Q. Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has
 *      a higher frequency than the current element.
 *
 *      If no such element exists, return -1 for that position.
 *   Ex.
 *      Input : arr[] = [2, 1, 1, 3, 2, 1]
 *      Output: [1, -1, -1, 2, 1, -1]
 *      Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
 *              For arr[0] = 2, the next element 1 has a higher frequency → 1.
 *              For arr[1] and arr[2], no element to the right has a higher frequency → -1.
 *              For arr[3] = 3, the next element 2 has a higher frequency → 2.
 *              For arr[4] = 2, the next element 1 has a higher frequency → 1.
 *              For arr[5] = 1, no elements to the right → -1.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class S9_Next_element_with_greater_frequency {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Next more frequent element: " + findGreater(arr));
    }

    /// Solution
    static ArrayList<Integer> findGreater(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>(n);

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
            ans.add(-1);
        }

        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(arr[i])) stack.pop();
            if (!stack.isEmpty()) ans.set(i, stack.peek());
            stack.push(arr[i]);
        }

        return ans;
    }
}
