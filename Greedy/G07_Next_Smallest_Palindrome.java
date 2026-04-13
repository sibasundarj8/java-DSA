package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/next-smallest-palindrome4740/1
 *
 * # Next Smallest Palindrome
 *
 *   Q. Given a number, in the form of an array num[] containing digits from 1 to 9(inclusive). Find the next smallest palindrome
 *      strictly larger than the given number.
 *    Ex.
 *      Input : num[] = [9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2]
 *      Output: [9, 4, 1, 8, 8, 0, 8, 8, 1, 4, 9]
 *      Explanation: Next smallest palindrome is 9 4 1 8 8 0 8 8 1 4 9.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ num[i] ≤ 9
 */

import java.util.Arrays;
import java.util.Scanner;

public class G07_Next_Smallest_Palindrome {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);

            if (arr[i] < 1 || 9 < arr[i]) {
                throw new IllegalArgumentException("Array elements must be between 1 and 9");
            }
        }

        System.out.println("next smallest palindrome strictly larger than the given number: ");
        System.out.println(Arrays.toString(nextPalindrome(arr)));
    }

    /// Solution
    static int[] nextPalindrome(int[] num) {
        // potd.code.hub
        int n = num.length;
        boolean shouldAdd = true;
        int x = (n + 1) / 2;

        while (x < n) {
            int l = n - 1 - x;
            if (num[x] > num[l]) break;
            if (num[x] < num[l]) {
                shouldAdd = false;
                break;
            }
            x++;
        }

        // add one
        if (shouldAdd) {
            int carry = 1;

            for (x = (n - 1) / 2; x >= 0 && carry != 0; x--) {
                int val = num[x] + carry;
                num[x] = val % 10;
                carry = val / 10;
            }

            if (carry != 0) {
                num = new int[n + 1];
                num[0] = num[n] = 1;
                n++;
            }
        }

        // copy 2nd half
        x = (n + 1) / 2;
        while (x < n) {
            int j = n - 1 - x;
            num[x] = num[j];
            x++;
        }

        return num;
    }
}
