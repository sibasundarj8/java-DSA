package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/asteroid-collision/1
 *
 * # Opposite Sign Pair Reduction
 *
 *   Q. Given an array arr[] , return the final array by repeatedly apply the following operation from left to right until
 *      no more valid operations can be performed.
 *
 *      If two adjacent elements have opposite signs:
 *        ◦ If their absolute values are different, remove both elements and insert the one with the greater absolute value,
 *          preserving its sign.
 *        ◦ If their absolute values are equal, remove both elements without inserting any new element.
 *
 *    Ex.
 *      Input : arr[] = [10, -5, -8, 2, -5]
 *      Output: [10]
 *      Explanation:
 *              At Index 0 : Element 10 has positive sign.
 *              At Index 1 : -5  has lesser absolute value than 10. Replace both of them with 10.
 *              At Index 2 : -8  has lesser absolute value than 10. Replace both of them with 10.
 *              At Index 3 : 2 has positive sign. So it will be in the array.
 *              At Index 4 : -5  has greater absolute value than 2. Replace both of them with 5.
 *              Now -5  has lesser absolute value than 10. Replace both of them with 10.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          -10000 ≤ arr[i] ≤ 10000
 *          arr[i] != 0
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S19_Opposite_Sign_Pair_Reduction {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Result array after performing all valid operations: ");
        System.out.println(reducePairs(arr));
    }

    /// Solution
    static ArrayList<Integer> reducePairs(int[] arr) {
        // potd.code.hub
        Stack<Integer> stack = new Stack<>();

        for (int ele : arr) {

            while (!stack.isEmpty() && stack.peek() * ele < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(ele)) {
                    stack.pop();
                } else {
                    if (Math.abs(top) == Math.abs(ele)) {
                        stack.pop();
                    }
                    ele = 0;
                    break;
                }
            }

            if (ele != 0) {
                stack.push(ele);
            }
        }

        return new ArrayList<>(stack);
    }
}
