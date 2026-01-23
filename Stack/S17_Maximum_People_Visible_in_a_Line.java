package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-people-visible-in-a-line/1
 *
 * # Maximum People Visible in a Line
 *
 *   Q. You are given an array arr[ ], where arr[i] represents the height of the ith person standing in a line.
 *
 *      A person i can see another person j if:
 *        ⇨ height[j] < height[i],
 *        ⇨ There is no person k standing between them such that height[k] ≥ height[i].
 *
 *      Each person can see in both directions (front and back).
 *      Your task is to find the maximum number of people that any person can see (including themselves).
 *   Ex.
 *      Input : arr[] = [6, 2, 5, 4, 5, 1, 6 ]
 *      Output: 6
 *      Explanation:
 *              Person 1 (height = 6) can see five other people at following positions (2, 3, 4, 5. 6) in addition to himself,
 *                                    i.e. total 6.
 *              Person 2 (height: 2) can see only himself.
 *              Person 3 (height = 5) is able to see people 2nd, 3rd, and 4th person.
 *              Person 4 (height = 4) can see himself.
 *              Person 5 (height = 5) can see people 4th, 5th, and 6th.
 *              Person 6 (height =1) can only see himself.
 *              Person 7 (height = 6) can see 2nd, 3rd, 4th, 5th, 6th, and 7th people.
 *              A maximum of six people can be seen by Person 1, 7th
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁴
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Scanner;
import java.util.Stack;

public class S17_Maximum_People_Visible_in_a_Line {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter heights: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("maximum number of people that any person can see: ");
        System.out.println(maxPeople(arr));
    }

    /// Solution
    static int maxPeople(int[] arr) {
        int n = arr.length;
        int max = 0;
        int[] nge = nextGreater(arr);
        int[] pge = prevGreater(arr);

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nge[i] - pge[i] - 1);
        }

        return max;
    }

    private static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) stack.pop();
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nge;
    }

    private static int[] prevGreater(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) stack.pop();
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pge;
    }
}
