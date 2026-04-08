package Two_Pointers;/*
 *
 * https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
 *
 * # Segregate 0s and 1s
 *
 *   Q. Given an array arr[] consisting of only 0's and 1's. Modify the array in-place to segregate 0s onto the left side
 *      and 1s onto the right side of the array.
 *
 *    Ex.
 *      Input : arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 *      Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 *      Explanation: After segregation, all the 0's are on the left and 1's are on the right. Modified array will be
 *                   [0, 0, 0, 0, 0, 1, 1, 1, 1, 1].
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q02_Segregate_0s_and_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter binary array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);

            if (arr[i] != 0 && arr[i] != 1){
                throw new RuntimeException("only 0's and 1's are accepted.");
            }
        }

        segregate0and1(arr);

        System.out.println("after segregation: ");
        System.out.println(Arrays.toString(arr));
    }

    /// Solution
    static void segregate0and1(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int z = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                arr[z++] = 0;
            }
        }
    }
}
