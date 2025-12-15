package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/count-indices-to-balance-even-and-odd-sums/1
 *
 * # Count Indices to Balance Even and Odd Sums
 *
 *   Q. Given an array arr[], count the number of indices such that deleting the element at that index and shifting all
 *      elements after its one position left results in an array where the sum of elements at even indices equals the sum
 *      at odd indices.
 *    Ex.
 *      Input : arr[] = [1, 1, 1]
 *      Output: 3
 *      Explanation: Removing any element makes the sum of odd and even indexed elements equal.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 10⁴
 */

import java.util.Scanner;

public class Q07_Count_Indices_to_Balance_Even_and_Odd_Sums {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("number of indices can Balance Even and Odd Sums : ");
        System.out.println(cntWays(arr));
    }

    /// Solution
    static int cntWays(int... arr) {
        int n = arr.length;
        int count = 0;
        int[] total = {0, 0};    // 0th index -> even sum
        int[] prevSum = {0, 0};  // 1st index -> odd sum

        for (int i = 0; i < n; i++) {
            total[i & 1] += arr[i];
        }

        for (int i = 0; i < n; i++) {
            int[] currSum = {0, 0};
            currSum[0] = prevSum[0] + (total[1] - prevSum[1]);
            currSum[1] = prevSum[1] + (total[0] - prevSum[0]);
            currSum[(i ^ 1) & 1] -= arr[i];

            if (currSum[0] == currSum[1]) count++;

            prevSum[i & 1] += arr[i];
        }

        return count;
    }
}
