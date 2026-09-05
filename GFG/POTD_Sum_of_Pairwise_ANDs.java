package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-products5049/1
 *
 * # Sum of Pairwise ANDs
 *
 *   Q. Given an array arr[] of integers, calculate the sum of bitwise AND for all pairs of elements such that the first
 *      index is less than the second index.
 *
 *    Ex.
 *      Input : arr = [10, 20, 30, 40]
 *      Output: 46
 *      Explanation:
 *              Consider all pairs of elements where the first index is less than the second index (i < j).
 *              For the array [10, 20, 30, 40], the valid pairs are:
 *                ◦ (10, 20) -> 10 & 20 = 0
 *                ◦ (10, 30) -> 10 & 30 = 10
 *                ◦ (10, 40) -> 10 & 40 = 8
 *                ◦ (20, 30) -> 20 & 30 = 20
 *                ◦ (20, 40) -> 20 & 40 = 0
 *                ◦ (30, 40) -> 30 & 40 = 8
 *              Now, add all these results: 0 + 10 + 8 + 20 + 0 + 8 = 46
 *              So, the total sum of bitwise ANDs for all such pairs is 46
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁸
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class POTD_Sum_of_Pairwise_ANDs {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("int[] arr: ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = st.countTokens();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Sum of bitwise AND for all pairs of elements: arr[i] & arr[j] => i < j");
        System.out.println(pairAndSum(arr));
    }

    /// Solution
    static long pairAndSum(int[] arr) {
        // potd.code.hub
        long sum = 0;
        long count, pairs;

        for (int i = 0; i < 32; i++) {
            count = 0;

            // counting ith set bits of every element
            for (int ele : arr) {
                if (((ele >> i) & 1) == 1) {
                    count++;
                }
            }

            // number of pairs who's these bit set.
            pairs = (count * (count - 1)) >> 1;

            // contribution of this bit
            sum += pairs * (1L << i);
        }

        return sum;
    }
}
