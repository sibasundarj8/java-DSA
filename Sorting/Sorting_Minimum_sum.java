package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-sum4058/1
 *
 * # Minimum sum
 *
 *   Q. Given an array arr[ ] consisting of digits, your task is to form two numbers using all the digits such that their
 *      sum is minimized. Return the minimum possible sum as a string with no leading zeroes.
 *    Ex.
 *      Input : arr[] = [6, 8, 4, 5, 2, 3]
 *      Output: "604"
 *      Explanation: The minimum sum is formed by numbers 358 and 246.
 */

import java.util.Scanner;

public class Sorting_Minimum_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum sum: " + minSum(arr));
    }

    /// Solution
    static String minSum(int[] arr) {
        // potd.code.hub
        int[] freq = new int[10];
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Use frequency array instead of sorting to avoid O(n log n) complexity.
        for (int i : arr) freq[i]++;

        int i = 0;
        boolean flag = true;
        while (i < 10) {
            if (freq[i] > 0 && flag) {
                num1.append(i);
                freq[i]--;
                flag = false;
            }
            if (freq[i] > 0 && !flag) {
                num2.append(i);
                freq[i]--;
                flag = true;
            }
            if (freq[i] == 0) i++;
        }

        return findSum(num1, num2);
    }

    private static String findSum(StringBuilder s1, StringBuilder s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        int len = Math.max(n, m);
        StringBuilder ans = new StringBuilder();

        int idx1, idx2, d1, d2, sum, carry = 0;

        for (int i = 0; i < len; i++) { // adding two numbers
            idx1 = n - 1 - i;
            idx2 = m - 1 - i;
            d1 = (idx1 >= 0) ? s1.charAt(idx1) - '0' : 0;
            d2 = (idx2 >= 0) ? s2.charAt(idx2) - '0' : 0;

            sum = d1 + d2 + carry;

            ans.append(sum % 10);
            carry = sum / 10;
        }
        ans.append(carry);

        int idx = ans.length() - 1; // removing leading zeros
        while (idx > 0 && ans.charAt(idx) == '0') idx--;
        ans.delete(idx + 1, ans.length());

        return ans.reverse().toString();
    }
}
