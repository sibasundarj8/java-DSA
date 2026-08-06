package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-steps-to-get-desired-array5519/1
 *
 * # Minimum Increment or Double Operations to Convert
 *
 *   Q. Given an array arr[]. Initially, you have another array containing only 0s.
 *
 *      In one operation, you may either:
 *        ◦ Choose any one element and increase its value by 1, or
 *        ◦ Double the values of all elements in the array simultaneously.
 *
 *      Find the minimum number of operations required to transform the initial all-zero array into the given array arr[].
 *
 *    Ex.
 *      Input : arr[] = [16, 16, 16]
 *      Output: 7
 *      Explanation:
 *              First, increase each element to make the array [1, 1, 1] (3 steps).
 *              Then, multiply the whole array by 2 four times:
 *              [1,1,1] -> [2,2,2] -> [4,4,4] -> [8,8,8] -> [16,16,16]
 *              Total steps = 3 + 4 = 7.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 0 ≤ arr[i] ≤ 10⁹
 */

import java.util.Scanner;

public class POTD_Minimum_Increment_or_Double_Operations_to_Convert {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum number of operation needed to transform:");
        System.out.println(countMinOperations(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-recursive-approach-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log m)
SC : O(log m) --> recursive depth
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        return solve(arr, arr.length);
    }

    private static int solve(int[] arr, int n) {
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
          
            // producing 1s
            if ((arr[i] & 1) == 1) {
                count++;
                arr[i]--;
            }

            // doubling the entire array
            if (arr[i] > 0) {
                arr[i] >>= 1;
                flag = true;
            }
        }

        if (flag) count += 1 + solve(arr, n);

        return count;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--iterative-simulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log m)
SC : O(1)
*/
    static int approach_2(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int count = 0;

        while (true) {
            boolean flag = false;

            for (int i = 0; i < n; i++) {

                // producing 1s
                if ((arr[i] & 1) == 1) {
                    count++;
                    arr[i]--;
                }

                // doubling the entire array
                if (arr[i] > 0) {
                    arr[i] >>= 1;
                    flag = true;
                }
            }

            if (flag) count++;
            else break;
        }

        return count;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--bit-manipulation--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log m)
SC : O(1)
*/
    static int countMinOperations(int[] arr) {
        // potd.code.hub
        int totalOne = 0;
        int msb = 0;

        for (int ele : arr) {
            int num = 1;
            int i = 0;

            while (num <= ele) {
                if ((num & ele) != 0) {
                    totalOne++;
                    if (i > msb) msb = i;
                }

                num <<= 1;
                i++;
            }
        }

        return msb + totalOne;
    }
}
