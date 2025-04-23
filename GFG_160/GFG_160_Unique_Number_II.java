package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/finding-the-numbers0215/1
 *
 * # Unique Number II
 *
 *   Q. Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs,
 *      whereas the other two numbers occur exactly once and are distinct. Find the other two numbers.
 *      Return the answer in increasing order.
 *   Ex.
 *      Input : arr[] = [1, 2, 3, 2, 1, 4]
 *      Output: [3, 4]
 *      Explanation: 3 and 4 occur exactly once.
 */

import java.util.Arrays;
import java.util.Scanner;

public class GFG_160_Unique_Number_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(Arrays.toString(singleNum(arr)));
    }

    /// Solution
    static int[] singleNum(int[] arr) {
        // potd.code.hub
        int xor = 0;

        for (int i : arr) {
            xor ^= i;
        }

        // getting RMSB (right most significant bit) of the xor of two non repeating element.
        int pos = 0;
        for (; pos <= 31; pos++) {
            if ((xor & (1 << pos)) != 0) {
                break;
            }
        }

        // separating in 2 groups on the basis of RMSB
        int xorA = 0, xorB = 0;
        for (int i : arr) {
            if ((i & (1 << pos)) == 0) {
                xorA ^= i;
            } else {
                xorB ^= i;
            }
        }

        int[] ans = {xorA, xorB};
        Arrays.sort(ans);

        return ans;
    }
}
