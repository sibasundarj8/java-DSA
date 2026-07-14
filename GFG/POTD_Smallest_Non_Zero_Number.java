package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-smallest-non-zero-number4510/1
 *
 * # Smallest Non-Zero Number
 *
 *   Q. Given an array arr[], find the smallest number x such that when x is processed sequentially with each element of
 *      the array (from index 0 to n-1), it never becomes negative, under the following conditions:
 *        ◦ If x is greater than the current array element, x is increased by the difference between x and the array
 *          element.
 *        ◦ If x is less than or equal to the current array element, x is decreased by the difference between the array
 *          element and x.
 *
 *    Ex.
 *      Input : arr[] = [3, 4, 3, 2, 4]
 *      Output: 4
 *      Explanation: Start with x = 4:
 *                      - For arr[0] = 3, x becomes 5.
 *                      - For arr[1] = 4, x becomes 6.
 *                      - For arr[2] = 3, x becomes 9.
 *                      - For arr[3] = 2, x becomes 16.
 *                      - For arr[4] = 4, x becomes 28.
 *                  x remains positive throughout the process.
 *                  If x < 4, it would become negative at some point.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁶
 *        ◦ 1<= arr[i] <= 10⁴
 */

import java.util.Scanner;

public class POTD_Smallest_Non_Zero_Number {

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

        System.out.println("Smallest value of x: ");
        System.out.println(find(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--binary-search--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log Max_Ele)
SC : O(1)
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int max = Integer.MIN_VALUE;

        for (int ele : arr) {
            max = Math.max(max, ele);
        }

        int i = 0;
        int j = max;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);

            if (isPossible(mid, arr, max)) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }

    private static boolean isPossible(int x, int[] arr, int max) {
        for (int ele : arr) {
            if (x > ele) x += (x - ele);
            else x -= (ele - x);

            if (x < 0) return false;
            if (x >= max) return true;
        }

        return true;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--linear-traversal--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int find(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int x = 0;

        for (int i = n - 1; i >= 0; i--) {
            x = (x + arr[i] + 1) >> 1;
        }

        return x;
    }
}
