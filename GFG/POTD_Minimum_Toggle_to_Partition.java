package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-toogles-to-partition0135/1
 *
 * # Minimum Toggle to Partition
 *
 *   Q. Given an array arr[] containing only 0 and 1. Find the minimum toggles (switch from 0 to 1 or vice versa) required
 *      such the array become partitioned, i.e., it has first 0s then 1s.
 *
 *    Ex.
 *      Input : arr = [0, 1, 0, 0, 1, 1, 1]
 *      Output: 1
 *      Explanation: The changed array will be [0, 0, 0, 0, 1, 1, 1]. Required toggles are 1.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 1
 */

import java.util.Scanner;

public class POTD_Minimum_Toggle_to_Partition {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of binary array: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);

            if (arr[i] != 0 && arr[i] != 1) {
                throw new IllegalArgumentException("[INVALID INPUT] : elements should be either 0 or 1");
            }
        }

        System.out.println("Minimum toggles required to make array become partitioned: ");
        System.out.println(minToggle(arr));
    }

    /// Solution
    static int minToggle(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int leftOnes = 0;   // count left toggles because left side must contain 0's.
        int rightZeros = 0; // count right toggles because right side must contain 1's.

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                rightZeros++;
            }
        }

        int minToggle = leftOnes + rightZeros;

        for (int ele : arr) {
            if (ele == 0) rightZeros--;
            else leftOnes++;

            minToggle = Math.min(minToggle, leftOnes + rightZeros);
        }

        return minToggle;
    }
}
