package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 *
 * # Missing And Repeating
 *
 *   Q. Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in
 *      this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing
 *      number.
 *   Ex.
 *      Input : arr[] = [4, 3, 6, 2, 1, 1]
 *      Output: [1, 5]
 *      Explanation: Repeating number is 1 and the missing number is 5.
 *
 *  Constraints:
 *          2 ≤ n ≤ 10⁶
 *          1 ≤ arr[i] ≤ n
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Array_Missing_And_Repeating {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Repeated and missing are: " + findTwoElement(arr));
    }

    ///  Solution
    static ArrayList<Integer> findTwoElement(int[] arr) {
        // potd.code.hub

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i : arr) {
            int index = Math.abs(i) - 1;
            if (arr[index] < 0) ans.add(index + 1);
            arr[index] = Math.abs(arr[index]) * -1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans.add(i + 1);
                break;
            }
        }

        return ans;
    }
}
