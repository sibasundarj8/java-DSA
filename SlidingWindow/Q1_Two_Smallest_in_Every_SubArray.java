/*
 *    Q.Input: arr = [4, 3, 1, 5, 6]
 *      Output: 11
 *      Explanation:
 *          Sub-arrays with smallest and 2nd smallest are,
 *          Sub-array: [4, 3],          smallest = 3,   2nd smallest = 4,   sum = 7
 *          Sub-array: [4, 3, 1],       smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [4, 3, 1, 5],    smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [4, 3, 1, 5, 6], smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [3, 1],          smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [3, 1, 5],       smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [3, 1, 5, 6],    smallest = 1,   2nd smallest = 3,   sum = 4
 *          Sub-array: [1, 5],          smallest = 1,   2nd smallest = 5,   sum = 6
 *          Sub-array: [1, 5, 6] ,      smallest = 1,   2nd smallest = 5,   sum = 6
 *          Sub-array: [5, 6],          smallest = 5,   2nd smallest = 6,   sum = 11
 *
 *          Maximum sum among all above choices is, 5 + 6 = 11, hence the answer is 11.
 */
package Sliding_Window;

import java.util.Scanner;

public class Q1_Two_Smallest_in_Every_SubArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Output :");
        System.out.println(pairWithMaxSum(arr, n));
    }
    static int pairWithMaxSum(int[] arr, int n) {
        // potd.code.hub
        if (n < 2) return -1;

        int ans = arr[0] + arr[1];
        for (int i = 1;i < n-1;i++)
            ans = Math.max(ans, arr[i]+arr[i+1]);

        return ans;
    }
}