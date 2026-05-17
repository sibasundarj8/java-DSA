package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/make-the-array-beautiful--170647/1
 *
 * # Make the array beautiful
 *
 *   Q. Given an array of negative and non-negative integers. You need to make the array beautiful.
 *
 *        ◦ An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or positive. You can
 *          do the following operation any number of times until the array becomes beautiful.
 *
 *        ◦ If two adjacent are different i.e. one of them is negative and other is positive, remove them.
 *
 *        ◦ Return the beautiful array after performing the above operation.
 *
 *        ◦ An empty array is also a beautiful array.
 *
 *        ◦ There can be multiple beautiful output arrays. For consistency with the test cases, scan the array from left
 *          to right for removing two adjacent.
 *
 *    Ex.
 *      Input : arr[] = [4, 2,-2, 1]
 *      Output: [4, 1]
 *      Explanation: As at indices 1 and 2 , 2 and -2 have different sign, they are removed. And the final array is: [4, 1].
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          -10⁵ ≤ arr[i] ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S20_Make_the_array_beautiful {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements:");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("The beautiful array is:");
        System.out.println(makeBeautiful(arr));
    }

    /// Solution
    static List<Integer> makeBeautiful(int[] arr) {
        // potd.code.hub
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int ele : arr) {
            if (!stack.isEmpty() && !isSame(stack.peek(), ele)) {
                stack.pop();
            } else {
                stack.push(ele);
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pollLast());
        }

        return list;
    }

    private static boolean isSame(int x, int y) {
        return (x >= 0 && y >= 0) || (x < 0 && y < 0);
    }
}
